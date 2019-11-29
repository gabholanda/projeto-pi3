/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ReportDAO;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
import br.senac.codesquad.projeto.pi3.models.ItemOrdered;
import br.senac.codesquad.projeto.pi3.models.Report;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel.hsantos21
 */
public class ReportController {

    //revisar depois muito sono
    public static Report generateRegionalReport(int idBranch) throws SQLException {
        Report report = ReportDAO.generateReport(idBranch);
        if (report != null) {
            double soma = 0;
            for (ItemOrdered item : report.getItemList()) {
                soma += item.getValue() * item.getQuantityItem();
            }
            report.setTotalBranchValue(soma);
            return report;
        }
        return null;
    }

    public static Report generateAllReports() {
        try {
            Report report = ReportDAO.generateReportTotalBranch();
            if (report != null) {
                double soma = 0;
                for (BranchOffice total : report.getBranchList()) {
                    soma += total.getTotalValue();
                }
                report.setTotalBranchValue(soma);
            }
            return report;
        } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
