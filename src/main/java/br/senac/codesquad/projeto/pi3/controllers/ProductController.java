/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ProductDAO;
import br.senac.codesquad.projeto.pi3.models.Product;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ProductController {

    public static boolean save(int id, String nameProduct, double values, double valeusSale, int amount, int stock, String details, int idBranchOffice) {
        Product product = new Product(id, nameProduct, values, valeusSale, amount, stock, details, idBranchOffice);
        return ProductDAO.save(product);

    }

    public static boolean update(int id, String nameProduct, double values, double valuesSale, int amount, int stock, String details, int idBranchOffice) {
        Product product = new Product(id, nameProduct, values, valuesSale, amount, stock, details, idBranchOffice);
        return ProductDAO.update(product);

    }

    public static boolean delete(int id) {
        return ProductDAO.delete(id);
    }

    public static ArrayList<String[]> getProduct() {
        ArrayList<Product> product = ProductDAO.getProduct();
        ArrayList<String[]> Listproducts = new ArrayList<>();

        for (int i = 0; i < product.size(); i++) {
            Listproducts.add(new String[]{String.valueOf(product.get(i).getId()),
                product.get(i).getNameProduct(),
                String.valueOf(product.get(i).getValues()),
                String.valueOf(product.get(i).getValeusSale()),
                String.valueOf(product.get(i).getAmount()),
                String.valueOf(product.get(i).getStock()),
                product.get(i).getDetails(),
                String.valueOf(product.get(i).getIdBranchOffice()),});

        }
        return Listproducts;
    }
}
