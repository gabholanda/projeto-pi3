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

    public static boolean create(String nameProduct, double values, double valueSale, String details) {
        return ProductDAO.create(nameProduct, values, valueSale, details);
    }

    public static boolean update(int id, String nameProduct, double values, double valueSale, String details) throws Exception {
        return ProductDAO.update(id, nameProduct, values, valueSale, details);

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

    

 

}
