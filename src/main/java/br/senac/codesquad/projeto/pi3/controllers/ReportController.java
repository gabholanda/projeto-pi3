/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.ReportDAO;
import br.senac.codesquad.projeto.pi3.models.Report;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class ReportController {

    //revisar depois muito sono
    public static Report generateRegionalReport() throws SQLException {

        Report report = ReportDAO.generateReport();
        return report;
    }
}
