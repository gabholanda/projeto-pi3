/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class Client {

    private int id;
    private String name;
    private String cpf;
    private String address;
    private String mail;
    private ArrayList<Sale> saleList;

    /**
     * @return the name
     */
    public Client(String name, String cpf, String address, String mail) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.mail = mail;
    }

    public Client(int id, String name, String cpf, String address, String mail) {
        this.id = id;  
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.mail = mail;
    }

    public Client() {
        
    }

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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param saleList the saleList to set
     */
}
