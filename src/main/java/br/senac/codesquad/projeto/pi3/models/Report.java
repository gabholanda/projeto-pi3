/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import java.util.Set;

/**
 *
 * @author gabriel.hsantos21
 */
public class Report {

    private String BranchName; 
    //valor total de todas as filiais solicitado pela diretoria. 
    private double totalValue;
    //10 produtos mais vendidos solicitado pela diretoria. 
    private Set<Sale> salesList;
    //valor total por filial solicitado pela diretoria. 
    private double totalBranchValue;
    //data inicial do relatorio
    private String dataInicialReport;
    //data final do relatorio
    private String dataFinalReport;
  
    
  
    public Report() {

    }
    
    //revisar esse report total muito sono
    public Report (String BranchName, double totalBranchValue){ 
        this.BranchName = BranchName; 
        this.totalBranchValue = totalBranchValue;  
    }

    public Report(double totalValue, double totalBranchValue, String dataInicialReport, String dataFinalReport) {
        this.totalValue = totalValue;
        this.totalBranchValue = totalBranchValue;
        this.dataInicialReport = dataInicialReport;
        this.dataFinalReport = dataFinalReport;
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

    public String getDataInicialReport() {
        return dataInicialReport;
    }

    public void setDataInicialReport(String dataInicialReport) {
        this.dataInicialReport = dataInicialReport;
    }

    public String getDataFinalReport() {
        return dataFinalReport;
    }

    public void setDataFinalReport(String dataFinalReport) {
        this.dataFinalReport = dataFinalReport;
    }

    public Set<Sale> getSalesList() {
        return salesList;
    }

    public void setSalesList(Set<Sale> salesList) {
        this.salesList = salesList;
    }

}
