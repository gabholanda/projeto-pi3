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

    public  boolean create(int id, String nameProduct, double values, double valeusSale, int amount, int stock, String details, int idBranchOffice) throws Exception {
        Product product = new Product(id, nameProduct, values, amount, stock, details, idBranchOffice);
        return ProductDAO.create(nameProduct,  values, valeusSale,amount,details,stock, idBranchOffice);

    }

    public  boolean update( String nameProduct, double values,double valeusSale, int amount, int stock, String details, int idBranchOffice) throws Exception {
        Product product = new Product( nameProduct, values, amount, stock, details, idBranchOffice);
        return ProductDAO.update( nameProduct,  values, valeusSale, details, amount, stock);

    }

    public  boolean delete() throws Exception {
        return ProductDAO.delete();
    }

    public  ArrayList<Product> getProduct() throws Exception {

        return ProductDAO.getProduct();

    }

}

