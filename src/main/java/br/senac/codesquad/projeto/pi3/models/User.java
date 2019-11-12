/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public abstract class User {

    private int id;
    private String mail;
    private String password;
    private String name;
    private String permission; //permission user
    private ArrayList<Sale> saleList;

    public User() {
    }

    public User(String mail, String password, String name) {
        this.mail = mail;
        this.password = password;
        this.name = name;

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
    public String getPermission() {
        return permission;
    }
    
    /**
     * @param permission
     * @return 
     */
    public String setPermission(String permission){
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param id the id to set
     */
}
