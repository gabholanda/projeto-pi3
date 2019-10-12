/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.application.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ClientDAO;
import br.senac.codesquad.projeto.pi3.models.Client;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ClientController {

    public static boolean save(int id, String name, String cpf, String address, String mail) {
        Client client = new Client(id, name, cpf, address, mail);
        return ClientDAO.save;

    }

    public static boolean update(int id, String name, String cpf, String address, String mail) {
        Client client = new Client (id, name, cpf, address, mail); 
        return ClientDAO.update;

    }

    public static boolean delete(int id) {
        return ClientDAO.delete;
    }
    
     public static ArrayList<String[]> getClient() {
        ArrayList<Client> clientes = ClientDAO.getClient();
        ArrayList<String[]> Clients = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            //Clients.add(new String[]
        }

        return Clients;

    }
    

}


