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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.hsantos21
 */
public class ClientController {

    public static boolean create(String name, String cpf, String address, String mail) throws SQLException {
        Client client = new Client(name, cpf, address, mail);
        return ClientDAO.create(client);

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
        try {
            return ClientDAO.findBydId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Client> findByName(String name) {
        try {
            List<Client> clientList = ClientDAO.findByName(name);
            if (clientList == null) {
                clientList = new ArrayList<>();
                return clientList;
            }
            return clientList;
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
