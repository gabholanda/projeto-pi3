/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.UserDAO;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import br.senac.codesquad.projeto.pi3.models.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author marcelo.moraes
 */
public class UserController {

    public static boolean create(String mail, String password, String name, String permissionNew, int IdEmpresa, String permission) {
        if (permission.equalsIgnoreCase("TI")) {
            try {
                return UserDAO.create(mail, BCrypt.hashpw(password, BCrypt.gensalt()), name, Roles.valueOf(permissionNew), IdEmpresa);
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
                return UserDAO.update(id, name, BCrypt.hashpw(password, BCrypt.gensalt()));
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
        } else if (permission.equalsIgnoreCase("DIRETORIA") || permission.equalsIgnoreCase("GERENTE") || permission.equalsIgnoreCase("GERENTE GLOBAL")
                || permission.equalsIgnoreCase("RH") || permission.equalsIgnoreCase("TI")) {
            return UserDAO.read();
        }
        return user;
    }

    public static User findById(int id) {
        return UserDAO.findBydId(id);
    }

    public static User findByMail(String mail, String password) {
        try {
            return UserDAO.findbyMail(mail, password);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
