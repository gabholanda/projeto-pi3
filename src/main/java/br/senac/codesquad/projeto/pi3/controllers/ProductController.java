package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ProductDAO;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ProductController {

    public static boolean save(String nameProduct, double values, double valueSale, int amount, int stock, String details, int idBranchOffice) {
        Product product = new Product(nameProduct, values, valueSale, amount, stock, details, idBranchOffice);
        return ProductDAO.save(product);

    }

    public static boolean update(int id, String nameProduct, double values, double valueSale, int amount, int stock, String details) throws Exception {
        Product product = new Product(id, nameProduct, values, valueSale, amount, stock, details);
        return ProductDAO.update(id, nameProduct, values, valueSale, amount, stock, details);

    }

    public static boolean delete(int id) throws SQLException {
        return ProductDAO.delete(id);
    }

    public static ArrayList<Product> getProduct() throws Exception {
        return ProductDAO.getProduct();

    }

}
