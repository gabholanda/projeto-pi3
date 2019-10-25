/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ClientDAO;
import br.senac.codesquad.projeto.pi3.models.Client;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ClientController {

    public static boolean create(String name, String cpf, String address, String mail) throws SQLException {
        return ClientDAO.create(name, cpf, address, mail);

    }

    public static boolean update(int id, String name, String cpf, String address, String mail) throws SQLException {
        Client client = new Client(id, name, cpf, address, mail);
        return ClientDAO.update(client);

    }

    public static boolean delete(int id) throws SQLException {
        return ClientDAO.delete(id);
    }

    public static ArrayList<Client> read() throws Exception {
        return ClientDAO.read();
    }

    public static Client findById(int id) {
        return ClientDAO.findBydId(id);
    }

}
