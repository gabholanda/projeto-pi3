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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gabriel.hsantos21
 */
public class SaleController {

    public static boolean create(double totalValue, int clientId, ArrayList<Product> productList) throws SQLException, Exception {
        Sale sale = new Sale(totalValue, clientId, productList);
        return SaleDAO.create(sale);

    }

    public static boolean update(int id, int clientId, double totalValue,
            ArrayList<Product> productList, Date date) throws SQLException, Exception {
        Sale sale = new Sale(id, totalValue, id, date, productList);
        return SaleDAO.update(sale);
    }

    public static boolean delete(int id) throws SQLException {
        return SaleDAO.delete(id);
    }

    public static ArrayList<String[]> getSale() {
        ArrayList<Sale> sales = SaleDAO.getSales();
        ArrayList<String[]> sales2 = new ArrayList<>();

        for (int i = 0; i < sales2.size(); i++) {
            //Sales.add(new String[]
        }

        return sales2;

    }

}
