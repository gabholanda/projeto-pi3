/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

/**
 *
 * @author gabriel.hsantos21
 */
public class Product {

    private int id;
    private String nameProduct;
    private double values;
    private double valuesSale;
    private int amount;
    private int stock;
    private String details;
    private int idBranchOffice;

    public Product(int id, String nameProduct, double values, double valuesSale, int amount, int stock, String details, int idBranchOffice) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.values = values;
        this.amount = amount;
        this.stock = stock;
        this.details = details;
        this.idBranchOffice = idBranchOffice;
        this.valuesSale = valuesSale;
    }

    public Product(String nameProduct, double values, double valueSale, int amount, int stock, String details, int idBranchOffice) {
        this.nameProduct = nameProduct;
        this.values = values;
        this.valuesSale = valueSale;
        this.amount = amount;
        this.stock = stock;
        this.details = details;
        this.idBranchOffice = idBranchOffice;
    }

    public Product() {
    
    }

    public Product(String nameProduct, double values, double valueSale, int amount, String details, int idBranchOffice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Product(int id, String nameProduct, int amount, double values, double valueSale, String details) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public double getValuesSale() {
        return valuesSale;
    }

    public void setValuesSale(double valuesSale) {
        this.valuesSale = valuesSale;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nameProduct
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * @param nameProduct the nameProduct to set
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * @return the values
     */
    public double getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(double values) {
        this.values = values;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return the idBranchOffice
     */
    public int getIdBranchOffice() {
        return idBranchOffice;
    }

}
