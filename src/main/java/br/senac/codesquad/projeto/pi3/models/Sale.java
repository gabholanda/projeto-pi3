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
    private int clientId;
    private double totalValue;
    private double discount;
    private ArrayList<ItemOrdered> items;

    private Date date;

    public Sale() {
    }

    public Sale(int id, int clientId, double totalValue, double discount, Date date) {
        this.id = id;
        this.clientId = clientId;
        this.totalValue = totalValue;
        this.discount = discount;
        this.date = date;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public ArrayList<ItemOrdered> getItems() {
        return items;
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
