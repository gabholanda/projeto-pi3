/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author gabriel.hsantos21
 */
public class Sale {

    private int id;
    private double totalValue;
    private double discount;
    private Set<ItemOrdered> items;
    private Client client;
    private User user;
    private Date date;

    public Sale() {
        this.totalValue = 0;
    }

    public Sale(int id, double totalValue, double discount, Date date) {
        this.id = id;
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

    public Set<ItemOrdered> getItems() {
        return items;
    }

    public void setItems(Set<ItemOrdered> items) {
        this.items = items;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount <= 0 || discount > 1) {
            return;
        }
        this.discount = discount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
