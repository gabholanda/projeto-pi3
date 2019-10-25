/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.models.Employee;
import br.senac.codesquad.projeto.pi3.models.Management;
import br.senac.codesquad.projeto.pi3.models.Manager;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class UserController {

    public static boolean create(String mail, String password, String name, String permission) {
        if (permission.equalsIgnoreCase("funcionario")) {
            return false;
        } else if (permission.equalsIgnoreCase("gerencia")) {
            Management management = new Management(name, mail, password);
            return ManagementDAO.save(management, management.getPermission());  
        }else if (permission.equalsIgnoreCase("gerente")){
            return false;
        }
        return false;
    }
    public static boolean update(int id, String name, String mail, String password,String permission ) {
        if (permission.equalsIgnoreCase("funcionario")) {
            return false;
        }else if (permission.equalsIgnoreCase("gerencia")) {
            Management management = new Management(name, mail, password);
            return ManagementDAO.update(management, id);
        }else if (permission.equalsIgnoreCase("gerente")){
            Manager manager = new Manager(name, mail, password);
            return ManagerDAO.update(manager, id);
        }
        return false;

    }
    public static boolean delete(int id, String permission) {
        if (permission.equalsIgnoreCase("funcionario")) {
            return false;
        }else if (permission.equalsIgnoreCase("gerencia")) {
            return ManagementDAO.delete(id);
        }else if (permission.equalsIgnoreCase("gerente")){
            return false;
        }
        return false;
    }
    
    public static ArrayList<String[]> getUsers(String permission) {
        ArrayList<String[]> User = null;
       if (permission.equalsIgnoreCase("funcionario")){
           return User;
       }else if(permission.equalsIgnoreCase("gerencia")){
           return ManagementDAO.getManagement();
       }else if(permission.equalsIgnoreCase("gerente")){
           return ManagerDAO.getManager();
       }
       return User;
    }
    
}
