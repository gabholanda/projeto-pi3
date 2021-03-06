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
public class BranchOffice {

    private int id;
    private String name;
    private String cnpj;
    private String address;
    private ArrayList<Product> productList;
    private ArrayList<Employee> employeeList;
    private double totalValue;

    public BranchOffice(String name, String address, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }

    public BranchOffice(int id, String name, String cnpj, String address) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.address = address;
    }

    public BranchOffice() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

}
