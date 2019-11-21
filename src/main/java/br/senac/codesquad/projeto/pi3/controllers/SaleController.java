/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.SaleDAO;
import br.senac.codesquad.projeto.pi3.models.Sale;

/**
 *
 * @author gabriel.hsantos21
 */
public class SaleController {

    public static boolean create(Sale sale) throws Exception {
        return SaleDAO.create(sale);
    }

    public static void update() {

    }

    public static void delete() {

    }

    public static void read() {

    }
}
