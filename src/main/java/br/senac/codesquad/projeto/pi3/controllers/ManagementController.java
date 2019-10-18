/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ManagementDAO;
import br.senac.codesquad.projeto.pi3.models.Management;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class ManagementController {

    public static boolean save(int id, String name, String mail, String password) {
        Management management = new Management(name, mail, password);
        return ManagementDAO.save(management);

    }

    public static boolean update(int id, String name, String mail, String password) {
        Management management = new Management(name, mail, password);
        return ManagementDAO.update(management);

    }
    
     public static boolean delete(int id) {
        return ManagementDAO.delete(id);
    }
     
     public static ArrayList<String[]> getManagement() {
        ArrayList<Management> management = ManagementDAO.getManagement();
        ArrayList<String[]> Listmanagements = new ArrayList<>();

        for (int i = 0; i < management.size(); i++) {
           Listmanagements.add(new String[]{String.valueOf(management.get(i).getId()), 
               management.get(i).getName(), 
               management.get(i).getMail(), 
               management.get(i).getPassword(), 
               
           }); 
        }

        return Listmanagements;

    }
    

}
