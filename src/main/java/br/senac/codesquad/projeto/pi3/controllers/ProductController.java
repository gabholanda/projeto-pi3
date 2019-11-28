package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ProductDAO;
import br.senac.codesquad.projeto.pi3.models.Category;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.hsantos21
 */
public class ProductController {

    public static boolean create(String nameProduct, double values, double valueSale,
            String details, int idBranchoffice, int categoryId, int quantity) {
        Product p = new Product(nameProduct, values, valueSale, details, idBranchoffice, categoryId);
        try {
            return ProductDAO.create(p, quantity);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean update(int id, String nameProduct, double values,
            double valueSale, String details, int categoryId) throws Exception {
        Product p = new Product(id, nameProduct, values, valueSale, details, categoryId);
        return ProductDAO.update(p);

    }

    public static boolean delete(int id) throws SQLException {
        // ESSE DELETE APENAS A DIRETORIA TEM QUE TER PERMISSÃO PRA REALIZAR
        return ProductDAO.delete(id);
    }

    public static ArrayList<Product> read() throws Exception {
        return ProductDAO.getProduct();
    }

    public static Product findById(int id) {
        try {
            return ProductDAO.findBydId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Product> findByName(String name) {
        try {
            List<Product> productList = ProductDAO.findByName(name);
            if (productList == null) {
                productList = new ArrayList<>();
                return productList;
            }
            return productList;
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Category> findCategory() throws SQLException {
        return ProductDAO.findCategoryName();
    }
}
