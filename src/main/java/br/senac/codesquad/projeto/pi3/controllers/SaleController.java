/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.SaleDAO;
import br.senac.codesquad.projeto.pi3.models.Sale;
import br.senac.codesquad.projeto.pi3.models.User;
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

    public static void delete() {

    }

public static ArrayList<Sale> read() throws Exception {
        return SaleDAO.getSales();
    }
}
