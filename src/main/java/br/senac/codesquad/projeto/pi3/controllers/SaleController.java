/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.SaleDAO;
import br.senac.codesquad.projeto.pi3.models.Client;
import br.senac.codesquad.projeto.pi3.models.Product;
import br.senac.codesquad.projeto.pi3.models.Sale;
import br.senac.codesquad.projeto.pi3.models.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class SaleController {

    public static boolean create(Sale sale, User user) throws Exception {
        return SaleDAO.create(sale, user);
    }

    public static void update() {

    }

    public static boolean delete(int id) throws SQLException {
        return SaleDAO.delete(id);
    }

    public static ArrayList<Sale> read(int idBranch,String permission) throws Exception {
        if(permission.equalsIgnoreCase("DIRETORIA") || permission.equalsIgnoreCase("GERENTE GLOBAL")){
            return SaleDAO.getSales();
        }
        return SaleDAO.getSalesToBranch(idBranch);
        
    }

    public static Sale findByIdSale(int id) throws SQLException {
        return SaleDAO.findBydIdSale(id);
    }

    public static Client findByIdClient(int id) throws SQLException {
        return SaleDAO.findBydIdClient(id);
    }

    public static ArrayList<Product> findByIdProduct(int id) throws SQLException {
        return SaleDAO.findBydIdProduct(id);
    }

}
