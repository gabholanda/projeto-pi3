/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.enums.Roles;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author marcelo.moraes and Patrick
 */


public abstract class User {

    private int id;
    private String mail;
    private String password;
    private String name;
    Roles permission; // permission user
    private ArrayList<Sale> saleList;
    private ArrayList<User> userList;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
//        BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());

    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the permission
     */
    public Roles getPermission() {
        return permission;
    }

    /**
     * @param permission
     * @return
     */
    public Roles setPermission(Roles permission) {
        return permission;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the saleList
     */
    public ArrayList<Sale> getSaleList() {
        return saleList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean verificarPapel(Roles roles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
