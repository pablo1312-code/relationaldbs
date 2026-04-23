package relationaldatabases.dao;

import java.util.List;

import relationaldbs.model.Product;

/**
 * Interfaz que define las funcionalidades para interactuar con la tabla de
 * productos en la base de datos. Proporciona operaciones CRUD completas
 * (Create, Read, Update, Delete) para entidades Product.
 * 
 * @author pablo
 * @date 21 abr 2026
 */
public interface ProductDao {

	/**
	 * Inserta un objeto Product en la base de datos.
	 * 
	 * @param product el objeto Product a insertar
	 * @return true si la inserción fue exitosa, false en caso contrario
	 */
	public boolean insert(Product product);

	/**
	 * Elimina un producto por su ID.
	 * 
	 * @param id el ID del producto a eliminar
	 * @return true si la eliminación fue exitosa, false en caso contrario
	 */
	public boolean delete(long id);

	/**
	 * Actualiza un producto existente en la base de datos. El objeto Product debe
	 * tener el ID establecido para identificar qué registro actualizar.
	 * 
	 * @param product el objeto Product con los datos actualizados
	 */
	public void update(Product product);

	/**
	 * Busca un producto por su ID.
	 * 
	 * @param id el ID del producto a buscar
	 * @return el objeto Product si existe, null en caso contrario
	 */
	public Product find(long id);

	/**
	 * Busca un producto por su nombre. Realiza búsqueda exacta por nombre de
	 * producto.
	 * 
	 * @param name el nombre del producto a buscar
	 * @return el objeto Product si existe, null en caso contrario
	 */
	public Product findByName(String name);

	/**
	 * Busca un producto por su SKU (Stock Keeping Unit). El SKU es un identificador
	 * único del producto.
	 * 
	 * @param sku el SKU del producto a buscar
	 * @return el objeto Product si existe, null en caso contrario
	 */
	public Product findBySku(String sku);

	/**
	 * Recupera todos los productos de la base de datos.
	 * 
	 * @return lista de todos los productos ordenados por nombre
	 */
	public List<Product> findAll();

	/**
	 * Recupera productos por categoría.
	 * 
	 * @param category la categoría de productos a buscar
	 * @return lista de productos de esa categoría
	 */
	public List<Product> findByCategory(String category);

	/**
	 * Recupera productos con stock disponible.
	 * 
	 * @return lista de productos que tienen stock > 0
	 */
	public List<Product> findProductsInStock();

	/**
	 * Cuenta el número total de productos en la base de datos.
	 * 
	 * @return número total de productos
	 */
	public long countAll();

	/**
	 * Verifica si existe un producto con el SKU especificado.
	 * 
	 * @param sku el SKU a verificar
	 * @return true si existe, false en caso contrario
	 */
	public boolean existsBySku(String sku);
}
