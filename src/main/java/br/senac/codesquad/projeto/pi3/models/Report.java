/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.Interfaces.Emitable;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class Report implements Emitable {

    private String BranchName;
    //valor total de todas as filiais solicitado pela diretoria. 
    private double totalValue;
    //10 produtos mais vendidos solicitado pela diretoria.
    private ArrayList<ItemOrdered> itemList = new ArrayList<>();
    private ArrayList<BranchOffice> branchList = new ArrayList<>();
    //valor total por filial solicitado pela diretoria. 
    private double totalBranchValue;
    //data inicial do relatorio
    private String initialDateReport;
    //data final do relatorio

    public Report() {

    }

    //revisar esse report total muito sono
    public Report(String BranchName, double totalBranchValue) {
        this.BranchName = BranchName;
        this.totalBranchValue = totalBranchValue;
    }

    public Report(double totalValue, double totalBranchValue, String initialDateReport) {
        this.totalValue = totalValue;
        this.totalBranchValue = totalBranchValue;
        this.initialDateReport = initialDateReport;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTotalBranchValue() {
        return totalBranchValue;
    }

    public void setTotalBranchValue(double totalBranchValue) {
        this.totalBranchValue = totalBranchValue;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String BranchName) {
        this.BranchName = BranchName;
    }

    public String getInitialDateReport() {
        return initialDateReport;
    }

    public void setInitialDateReport(String initialDateReport) {
        this.initialDateReport = initialDateReport;
    }

    public ArrayList<BranchOffice> getBranchList() {
        return branchList;
    }

    public void setBranchList(ArrayList<BranchOffice> branchList) {
        this.branchList = branchList;
    }

    public ArrayList<ItemOrdered> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<ItemOrdered> itemList) {
        this.itemList = itemList;
    }

    @Override
    public Report generateReport() {
        return null;
    }

    @Override
    public Report generateOverallReport() {
        return null;
    }

}
