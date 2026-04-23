package relationaldatabases.dao;

import relationaldatabases.dao.ProductDao;
import relationaldatabases.dao.ProductDaoImpl;
import relationaldbs.model.Product;

public class ProductDaoTest {
    public static void main(String[] args) {

        // Insert test
        ProductDao productDao = new ProductDaoImpl();

        // Creamos un producto con datos de prueba
        Product product = new Product(
                0,
                "Teclado mecánico",
                "Teclado RGB para gaming",
                49.99,
                10,
                "Periféricos",
                "Logitech",
                "SKU-001",
                true
        );

        productDao.insert(product);
    }
}
