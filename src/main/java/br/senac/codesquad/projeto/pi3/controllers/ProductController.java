package br.senac.codesquad.projeto.pi3.controllers;
import br.senac.codesquad.projeto.pi3.models.ItemOrdered;
import br.senac.codesquad.projeto.pi3.DAOs.ProductDAO;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel.hsantos21
 */
public class ProductController {

    public static boolean create(String nameProduct, double values, double valueSale,
            String details, int categoryId) {
        Product p = new Product(nameProduct, values, valueSale, details, categoryId);
        return ProductDAO.create(p);
    }

    public static boolean update(int id, String nameProduct, double values,
            double valueSale, String details, int categoryId) throws Exception {
        Product p = new Product(id, nameProduct, values, valueSale, details, categoryId);
        return ProductDAO.update(p);

    }

    public static boolean delete(int id) throws SQLException {
        return ProductDAO.delete(id);
    }

    public static ArrayList<Product> read() throws Exception {
        return ProductDAO.getProduct();
    }

    public static Product findById(int id) {
        return ProductDAO.findBydId(id);
    }

    public static List<Product> findByName(String name) {
        List<Product> productList = ProductDAO.findByName(name);
        if (productList == null) {
            productList = new ArrayList<>();
            return productList;
        }
        return productList;
    }
}
