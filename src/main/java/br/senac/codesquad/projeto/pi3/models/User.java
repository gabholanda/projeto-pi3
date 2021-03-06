/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.Interfaces.Authenticable;
import br.senac.codesquad.projeto.pi3.Interfaces.Emitable;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author marcelo.moraes and Patrick
 */
public abstract class User implements Authenticable, Emitable {

    private int id;
    private int idBranch;
    private String mail;
    private String password;
    private String name;
    private Roles permission; // permission user
    private ArrayList<Sale> saleList;
    private ArrayList<User> userList;

    public User() {
    }

    public User(String mail, String password) {
        this.mail = mail;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(11));
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
        this.password = password;
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

    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, password);
    }

    public boolean checkRole(User user, Roles roles) {
        return user.getPermission() == roles;
    }
}
