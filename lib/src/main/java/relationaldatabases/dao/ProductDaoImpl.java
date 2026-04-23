package relationaldatabases.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import relationaldbs.model.Product; // Cambiado de User a Product

/**
 * Implementación del DAO para operaciones CRUD con productos en PostgreSQL
 * 
 * @author pablo
 * @date 21 abr 2026
 */
public class ProductDaoImpl implements ProductDao {

	// Configuración de conexión a PostgreSQL
	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";
	private static String username = "postgres";
	private static String password = "admin";

	// Sentencias SQL para gestión de la tabla products
	private static String dropTableSQL = "DROP TABLE IF EXISTS products CASCADE";
	private static String createTableSQL = """
			CREATE TABLE IF NOT EXISTS products (
			    id SERIAL PRIMARY KEY,
			    name VARCHAR(100) NOT NULL,
			    price DECIMAL(10,2) NOT NULL,
			    stock INTEGER NOT NULL DEFAULT 0,
			    category VARCHAR(50),
			    description TEXT,
			    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
			)
			""";

	/**
	 * Inserta un nuevo producto en la base de datos
	 * 
	 * @param product el objeto Product a insertar
	 * @return true si la inserción fue exitosa, false en caso contrario
	 */
	@Override
	public boolean insert(Product product) {
		String insertSQL = """
				INSERT INTO products(name, price, stock, category, description)
				VALUES(?, ?, ?, ?, ?)
				""";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement ps = conn.prepareStatement(insertSQL)) {

			// Establecer parámetros del PreparedStatement
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getStock());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getDescription());

			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0; // Retorna true si se insertó al menos 1 fila

		} catch (SQLException e) {
			System.err.println("Error al insertar producto: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Elimina un producto por su ID
	 * 
	 * @param id el ID del producto a eliminar
	 * @return true si la eliminación fue exitosa, false en caso contrario
	 */
	@Override
	public boolean delete(long id) {
		String deleteSQL = "DELETE FROM products WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

			ps.setLong(1, id);
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;

		} catch (SQLException e) {
			System.err.println("Error al eliminar producto ID " + id + ": " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Actualiza un producto existente
	 * 
	 * @param product el objeto Product con los datos actualizados
	 * @return true si la actualización fue exitosa, false en caso contrario
	 */
	@Override
	public void update(Product product) {
		String updateSQL = """
				UPDATE products
				SET name = ?, price = ?, stock = ?, category = ?, description = ?
				WHERE id = ?
				""";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement ps = conn.prepareStatement(updateSQL)) {

			// Establecer parámetros de actualización
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getStock());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getDescription());
			ps.setLong(6, product.getId());

			int rowsAffected = ps.executeUpdate();
			System.out.println("Productos actualizados: " + rowsAffected);

		} catch (SQLException e) {
			System.err.println("Error al actualizar producto: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Busca un producto por su ID
	 * 
	 * @param id el ID del producto a buscar
	 * @return el objeto Product si existe, null en caso contrario
	 */
	@Override
	public Product find(long id) {
		String selectSQL = "SELECT * FROM products WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement ps = conn.prepareStatement(selectSQL)) {

			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return mapResultSetToProduct(rs);
			}

		} catch (SQLException e) {
			System.err.println("Error al buscar producto ID " + id + ": " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Busca un producto por su nombre
	 * 
	 * @param name el nombre del producto a buscar
	 * @return el objeto Product si existe, null en caso contrario
	 */
	@Override
	public Product findByName(String name) {
		String selectSQL = "SELECT * FROM products WHERE name = ? LIMIT 1";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement ps = conn.prepareStatement(selectSQL)) {

			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return mapResultSetToProduct(rs);
			}

		} catch (SQLException e) {
			System.err.println("Error al buscar producto por nombre '" + name + "': " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Obtiene todos los productos de la base de datos
	 * 
	 * @return lista de todos los productos
	 */
	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		String selectSQL = "SELECT * FROM products ORDER BY name";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectSQL)) {

			while (rs.next()) {
				products.add(mapResultSetToProduct(rs));
			}

		} catch (SQLException e) {
			System.err.println("Error al obtener todos los productos: " + e.getMessage());
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * Método auxiliar para mapear ResultSet a objeto Product
	 * 
	 * @param rs ResultSet con los datos del producto
	 * @return objeto Product mapeado
	 * @throws SQLException si hay error al leer el ResultSet
	 */
	private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setStock(rs.getInt("stock"));
		product.setCategory(rs.getString("category"));
		product.setDescription(rs.getString("description"));
		return product;
	}

	/**
	 * Crea la tabla products si no existe (método utilitario)
	 */
	public void createTable() {
		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				Statement stmt = conn.createStatement()) {
			stmt.execute(createTableSQL);
			System.out.println("Tabla 'products' creada o verificada correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear tabla products: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Elimina la tabla products (método utilitario - USAR CON CUIDADO)
	 */
	public void dropTable() {
		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				Statement stmt = conn.createStatement()) {
			stmt.execute(dropTableSQL);
			System.out.println("Tabla 'products' eliminada correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al crear la tabla products: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Product findBySku(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findProductsInStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsBySku(String sku) {
		// TODO Auto-generated method stub
		return false;
	}
}