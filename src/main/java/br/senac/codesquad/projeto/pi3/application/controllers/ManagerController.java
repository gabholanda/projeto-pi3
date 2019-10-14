/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.application.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ManagerDAO;
import br.senac.codesquad.projeto.pi3.models.Manager;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class ManagerController {

    public static boolean save(int id, String name, String mail, String password) {
        Manager manager = new Manager(name, mail, password);
        return ManagerDAO.save(manager);
    }

    public static boolean update(int id, String name, String mail, String password) {
        Manager manager = new Manager(name, mail, password);
        return ManagerDAO.update(manager);
    }

    public static boolean delete(int id) {
        return ManagerDAO.delete(id);
    }

    public static ArrayList<String[]> getManager() {
        ArrayList<Manager> manager = ManagerDAO.getManager();
        ArrayList<String[]> ListManager = new ArrayList<>();

        for (int i = 0; i < manager.size(); i++) {
            ListManager.add(new String[]{String.valueOf(manager.get(i).getId()),
                manager.get(i).getName(),
                manager.get(i).getMail(),
                manager.get(i).getPassword(),
            });
        }
        return ListManager; 
    }

}
