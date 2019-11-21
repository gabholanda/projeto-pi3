/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import java.util.Objects;

/**
 *
 * @author gabriel.santos
 */
// Implemento a interface Comparable
public class ItemOrdered implements Comparable<ItemOrdered> {

    private Integer id, quantityItem;
    private double value;
    private String name;

    public ItemOrdered() {
    }

    public ItemOrdered(int id, int quantityItem, double value) {
        this.id = id;
        this.quantityItem = quantityItem;
        this.value = value;
    }

    // Defino a forma de comparação entre dois ItemOrdered
    @Override
    public int compareTo(ItemOrdered t) {
        return name.compareTo(t.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(int quantityItem) {
        this.quantityItem = quantityItem;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

// Verifica se ja existe atraves do hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

}
