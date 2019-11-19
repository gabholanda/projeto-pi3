/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ClientDAO;
import br.senac.codesquad.projeto.pi3.DAOs.UserDAO;
import br.senac.codesquad.projeto.pi3.models.Client;
import br.senac.codesquad.projeto.pi3.models.Management;
import br.senac.codesquad.projeto.pi3.models.Manager;
import br.senac.codesquad.projeto.pi3.models.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcelo.moraes
 */
public class UserController {

    public static boolean create(String mail, String password, String name, String permission) {
        if (permission.equalsIgnoreCase("funcionario")) {
            return false;
        } else if (permission.equalsIgnoreCase("gerencia")) {
            try {
                Management management = new Management(name, mail, password);
                return UserDAO.create(management, management.getPermission());
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (permission.equalsIgnoreCase("gerente")) {
            return false;
        }
        return false;
    }

    public static boolean update(int id, String name, String mail, String password, String permission) {
        if (permission.equalsIgnoreCase("funcionario")) {
            return false;
        } else if (permission.equalsIgnoreCase("gerencia")) {
            try {
                Management management = new Management(name, mail, password);
                return UserDAO.update(management, id);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (permission.equalsIgnoreCase("gerente")) {
            try {
                Manager manager = new Manager(name, mail, password);
                return UserDAO.update(manager, id);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    public static boolean delete(int id, String permission) {
        if (permission.equalsIgnoreCase("funcionario")) {
            return false;
        } else if (permission.equalsIgnoreCase("gerencia")) {
            try {
                return UserDAO.delete(id);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (permission.equalsIgnoreCase("gerente")) {
            return false;
        }
        return false;
    }

    public static ArrayList<User> getUsers(String permission) {
        ArrayList<User> user = null;
        if (permission.equalsIgnoreCase("funcionario")) {
            return user;
        } else if (permission.equalsIgnoreCase("gerencia")) {
            return UserDAO.read();
        } else if (permission.equalsIgnoreCase("gerente")) {
            return UserDAO.read();
        }
        return user;
    }
    
        public static Client findById(int id) {
        return ClientDAO.findBydId(id);
    }

}
