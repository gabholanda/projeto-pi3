/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.DAOs.ReportDAO;
import br.senac.codesquad.projeto.pi3.Interfaces.Emitable;
import br.senac.codesquad.projeto.pi3.controllers.ReportController;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcelo.moraes
 */
public class Management extends User {

    private final Roles permission = Roles.DIRETORIA;

    public Management(String mail, String password) {
        super(mail, password);
    }

    public Management() {

    }

    @Override
    public Roles getPermission() {
        return permission;
    }

    @Override
    public void login(User user, HttpServletRequest request, HttpSession session) {
        session.setAttribute("user", user);
    }

    @Override
    public Report generateReport() {
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
    

    @Override
    public Report generateReport(int id) {
        return null;
    }
}
