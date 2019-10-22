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

    public static boolean save(String nameProduct, double values, double valueSale, String details, int amount, int idBranchOffice) {
        Product product = new Product(nameProduct, values, valueSale, details,amount,idBranchOffice);
        return ProductDAO.save(product);

    }

    public static boolean update(int id, String nameProduct, double values, double valueSale, String details, int amount) throws Exception {
        Product product = new Product(id, nameProduct, values, valueSale,amount, details);
        return ProductDAO.update(product);

    }

    public static boolean delete(int id) throws SQLException {
        return ProductDAO.delete(id);
    }

     public static ArrayList<Product> read() throws Exception {
        return ProductDAO.read();
    }

    public static Product findById(int id) {
        return ProductDAO.findBydId(id);
    }

    public static void update(int parseInt, String nameProduct, double parseDouble, double parseDouble0, String details) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

}
