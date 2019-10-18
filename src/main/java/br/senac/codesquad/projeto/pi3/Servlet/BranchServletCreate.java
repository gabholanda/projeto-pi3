/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.BranchOfficeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas.mnpaiva
 */
@WebServlet(name = "CreateBranchServlet", urlPatterns = {"/branch/create"})
public class BranchServletCreate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/Branch/Branch.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Filial.jsp");
        dispatcher.forward(request, response);

        String name = request.getAttribute("name").toString();
        String address = request.getAttribute("address").toString();
        String cnpj = request.getAttribute("cnpj").toString();

        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("cnpj", cnpj);

        try {
            BranchOfficeController.CreateBranch(name, address, cnpj);
        } catch (SQLException ex) {
            Logger.getLogger(BranchServletCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
