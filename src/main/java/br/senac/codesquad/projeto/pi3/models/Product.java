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
    private String details;
    private double values;
    private double valuesSale;
    private int idBranchOffice;
    private int idCategory;

    public Product(String nameProduct, double values, double valueSale, String details, int idBranchOffice) {
        this.nameProduct = nameProduct;
        this.values = values;
        this.valuesSale = valueSale;
        this.details = details;
        this.idBranchOffice = idBranchOffice;
        this.idCategory = idCategory;
    }

    public Product(int id, String nameProduct, double values, double valuesSale, String details, int idBranchOffice) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.values = values;
        this.details = details;
        this.idBranchOffice = idBranchOffice;
        this.valuesSale = valuesSale;
    }

    public Product() {

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
     * @param id the nameProduct to set
     */
    public void setId(int id) {
        this.id = id;
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

    public void setIdBranchOffice(int idBranchOffice) {
        this.idBranchOffice = idBranchOffice;
    }

    public int getCategory() {
        return idCategory;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
