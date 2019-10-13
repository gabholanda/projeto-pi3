/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.application.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ProductDAO;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.util.ArrayList;

/**

 * @author gabriel.hsantos21
 */
public class ProductController {
    
    public static boolean save(int id, String nameProduct, double values, int amount, int stock, String details, int idBranchOffice) {
        Product product = new Product(id, nameProduct, values, amount, stock, details, idBranchOffice);
        return ProductDAO.save;

    }

    public static boolean update(int id, String nameProduct, double values, int amount, int stock, String details, int idBranchOffice) {
        Product product = new Product (id, nameProduct, values, amount, stock, details, idBranchOffice); 
        return ProductDAO.update;

    }

    public static boolean delete(int id) {
        return ProductDAO.delete;
    }
    
    public static ArrayList<String[]> getProduct() {
        ArrayList<Product> product = ProductDAO.getProduct();
        ArrayList<String[]> products = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
           // product.add(new String[]
        }

        return products; 

    }
    
}
