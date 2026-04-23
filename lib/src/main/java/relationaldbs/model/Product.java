package relationaldbs.model;

/**
 * Modelo de datos para Productos Representa un producto en el sistema con sus
 * propiedades principales
 * 
 * @author pablo
 * @date 21 abr 2026
 */
public class Product {

	// Campos privados (fields)
	private long id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private String category;
	private String brand;
	private String sku; // Stock Keeping Unit
	private boolean active;

	// Constructor completo con todos los parámetros
	public Product(long id, String name, String description, double price, int stock, String category, String brand,
			String sku, boolean active) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.category = category;
		this.brand = brand;
		this.sku = sku;
		this.active = active;
	}

	// Constructor vacío (por defecto)
	public Product() {
	}

	// Getters y Setters ordenados por campos

	/**
	 * @return el ID único del producto
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id el ID único del producto
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return el nombre del producto
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name el nombre del producto
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return la descripción detallada del producto
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description la descripción detallada del producto
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return el precio del producto
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price el precio del producto
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return la cantidad en stock del producto
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock la cantidad en stock del producto
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return la categoría del producto
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category la categoría del producto
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return la marca del producto
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand la marca del producto
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return el SKU (código único del producto)
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku el SKU (código único del producto)
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return true si el producto está activo/disponible
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active true si el producto está activo/disponible
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	// Métodos adicionales útiles para Product

	/**
	 * Verifica si hay stock disponible
	 * 
	 * @return true si hay stock > 0
	 */
	public boolean hasStock() {
		return stock > 0;
	}

	/**
	 * Reduce el stock en la cantidad especificada
	 * 
	 * @param quantity cantidad a reducir
	 * @return true si se pudo reducir el stock
	 */
	public boolean reduceStock(int quantity) {
		if (quantity > 0 && stock >= quantity) {
			this.stock -= quantity;
			return true;
		}
		return false;
	}

	/**
	 * Aumenta el stock en la cantidad especificada
	 * 
	 * @param quantity cantidad a aumentar
	 */
	public void increaseStock(int quantity) {
		if (quantity > 0) {
			this.stock += quantity;
		}
	}

	/**
	 * Representación en string del producto para debugging
	 */
	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", stock=" + stock
				+ ", category='" + category + '\'' + ", brand='" + brand + '\'' + ", sku='" + sku + '\'' + ", active="
				+ active + '}';
	}

	/**
	 * Compara productos por ID
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product product = (Product) obj;
		return id == product.id;
	}

	/**
	 * Hashcode basado en el ID
	 */
	@Override
	public int hashCode() {
		return Long.hashCode(id);
	}
}