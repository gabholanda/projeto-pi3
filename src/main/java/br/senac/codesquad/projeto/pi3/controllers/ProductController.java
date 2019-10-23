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

    public static boolean create(String nameProduct, double values, double valueSale, String details, int idBranchOffice) {
        Product product = new Product(nameProduct, values, valueSale, details, idBranchOffice);
        return ProductDAO.save(product);

    }

    public static boolean update(int id, String nameProduct, double values, double valueSale, String details) throws Exception {
        Product product = new Product(id, nameProduct, values, valueSale, details);
        return ProductDAO.update(product);

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
