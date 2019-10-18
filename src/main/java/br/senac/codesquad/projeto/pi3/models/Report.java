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
public class Report {
   
    //valor total de todas as filiais solicitado pela diretoria. 
    private String valorTotal; 
    //10 produtos mais vendidos solicitado pela diretoria. 
    private String produtosVendidos;
    //valor total por filial solicitado pela diretoria. 
    private String valorFilial; 
    //data inicial do relatorio
    private String dataInicialReport; 
    //data final do relatorio
    private String dataFinalReport; 
    
    
    //
    public Report () { 
        
    }
    
    public Report (String valorTotal, String produtosVendidos, String valorFilial, String dataInicialReport, String dataFinalReport){
        this.valorTotal = valorTotal; 
        this.produtosVendidos = produtosVendidos; 
        this.valorFilial = valorFilial; 
        this.dataInicialReport = dataInicialReport; 
        this.dataFinalReport = dataFinalReport; 
    }
    

    /**
     * @return the valorTotal
     */
    public String getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the produtosVendidos
     */
    public String getProdutosVendidos() {
        return produtosVendidos;
    }

    /**
     * @param produtosVendidos the produtosVendidos to set
     */
    public void setProdutosVendidos(String produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    /**
     * @return the valorFilial
     */
    public String getValorFilial() {
        return valorFilial;
    }

    /**
     * @param valorFilial the valorFilial to set
     */
    public void setValorFilial(String valorFilial) {
        this.valorFilial = valorFilial;
    }

    /**
     * @return the dataInicialReport
     */
    public String getDataInicialReport() {
        return dataInicialReport;
    }

    /**
     * @param dataInicialReport the dataInicialReport to set
     */
    public void setDataInicialReport(String dataInicialReport) {
        this.dataInicialReport = dataInicialReport;
    }

    /**
     * @return the dataFinalReport
     */
    public String getDataFinalReport() {
        return dataFinalReport;
    }

    /**
     * @param dataFinalReport the dataFinalReport to set
     */
    public void setDataFinalReport(String dataFinalReport) {
        this.dataFinalReport = dataFinalReport;
    }
    
    
    
    
    
}
