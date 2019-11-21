/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.UserDAO;
import br.senac.codesquad.projeto.pi3.enums.Roles;
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

    public static boolean create(String mail, String password, String name, String permissionNew, String permission) {
        if (permission.equalsIgnoreCase("TI")) {
            try {
                User user = new User(mail, password, name) {
                };
                return UserDAO.create(user, Roles.valueOf(permissionNew));
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }

    public static boolean update(int id, String name, String password, String permission) {
        if (permission.equalsIgnoreCase("TI") || permission.equalsIgnoreCase("RH")) {
            try {
                User user = new User(name, password){};
                return UserDAO.update(user, id);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;

    }

    public static boolean delete(int id, String permission) {
        if (permission.equalsIgnoreCase("TI") || permission.equalsIgnoreCase("RH")) {
           try {
                return UserDAO.delete(id);
            } catch (SQLException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return false;
    }

    public static ArrayList<User> read(String permission) {
        ArrayList<User> user = null;
        if (permission.equalsIgnoreCase("VENDAS") || permission.equalsIgnoreCase("BACKOFFICE")) {
            return user;
        } else if (permission.equalsIgnoreCase("DIRETORIA") || permission.equalsIgnoreCase("GERENTE") || permission.equalsIgnoreCase("RH") || permission.equalsIgnoreCase("TI")) {
            return UserDAO.read();
        }
        return user;
    }

    public static User findById(int id) {
        return UserDAO.findBydId(id);
    }

}
