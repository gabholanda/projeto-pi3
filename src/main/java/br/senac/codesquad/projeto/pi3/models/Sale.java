/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gabriel.hsantos21
 */
public class Sale {

    private int id;
    private double totalValue;
    private int clientId;
    private ArrayList<Product> products;
    private Date date;

    public Sale() {
    }

    public Sale(int id, double totalValue, int clientId, Date date, ArrayList<Product> products) {
        this.id = id;
        this.totalValue = totalValue;
        this.clientId = clientId;
        this.date = date;
        this.products = products;
    }

    public Sale(double totalValue, int clientId, ArrayList<Product> products) {
        this.totalValue = totalValue;
        this.clientId = clientId;
        this.products = products;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

}
