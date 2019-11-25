/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.Interfaces.Emitable;
import java.util.Set;

/**
 *
 * @author gabriel.hsantos21
 */
public class Report implements Emitable {

    private String BranchName;
    //valor total de todas as filiais solicitado pela diretoria. 
    private double totalValue;
    //10 produtos mais vendidos solicitado pela diretoria. 
    private Set<Sale> salesList;
    //valor total por filial solicitado pela diretoria. 
    private double totalBranchValue;
    //data inicial do relatorio
    private String initialDateReport;
    //data final do relatorio
    private String finalDateReport;

    public Report() {

    }

    //revisar esse report total muito sono
    public Report(String BranchName, double totalBranchValue) {
        this.BranchName = BranchName;
        this.totalBranchValue = totalBranchValue;
    }

    public Report(double totalValue, double totalBranchValue, String initialDateReport, String finalDateReport) {
        this.totalValue = totalValue;
        this.totalBranchValue = totalBranchValue;
        this.initialDateReport = initialDateReport;
        this.finalDateReport = finalDateReport;
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

    public String getFinalDateReport() {
        return finalDateReport;
    }

    public void setFinalDateReport(String finalDateReport) {
        this.finalDateReport = finalDateReport;
    }

    public Set<Sale> getSalesList() {
        return salesList;
    }

    public void setSalesList(Set<Sale> salesList) {
        this.salesList = salesList;
    }

    @Override
    public Report generateReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Report generateOverallReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
