/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.BranchOfficeController;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
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
@WebServlet(name = "BranchServlet", urlPatterns = {"/branch"}) //SEGUE ESSA URL PATTERN <<<<<<<
public class BranchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action;
        if (request.getPathInfo() == null) {
            action = request.getServletPath();
        } else {
            action = request.getPathInfo();
        }

        try {
            switch (action) {
                case "/branch":
                    form(request, response);
                    break;
                case "/create":
                    create(request, response);
                    break;
                case "/delete":

                    break;
                case "/update":
                    update(request, response);
                    break;
                default:

                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Branch.jsp");
        dispatcher.forward(request, response);
    }

    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./Branch/Branch.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        String idAttr = request.getAttribute("id").toString();
        String name = request.getAttribute("name").toString();
        int id = Integer.parseInt(idAttr);
        BranchOffice Branch = new BranchOffice();
        Branch.setId(id);
        Branch.setName(request.getAttribute("name").toString());
        Branch.setCnpj(request.getAttribute("cnpj").toString());
        Branch.setAddress(request.getAttribute("address").toString());

        BranchOfficeController.UpdateBranch(Branch);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getAttribute("name").toString();
        String address = request.getAttribute("address").toString();
        String cnpj = request.getAttribute("cnpj").toString();

        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("cnpj", cnpj);

        try {
            BranchOfficeController.CreateBranch(name, address, cnpj);
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
