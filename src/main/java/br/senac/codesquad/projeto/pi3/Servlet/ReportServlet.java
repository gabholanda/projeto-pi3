/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ReportController;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import br.senac.codesquad.projeto.pi3.models.Report;
import br.senac.codesquad.projeto.pi3.models.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabriel.santos
 */
@WebServlet(name = "ReportServlet", urlPatterns = {"/report/*"})
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action;
        if (request.getPathInfo() == null) {
            action = request.getServletPath();
        } else {
            action = request.getPathInfo();
        }
// Give url paths by servletPath or getPathInfo depending on situation
        try {
            switch (action) {
                case "/report":
                    form(request, response);
                    break;
                case "/generate":
                    generate(request, response);
                    break;
                default:
                    form(request, response);
                    break;
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delegate all post responsabilities to doGet method
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.checkRole(user, Roles.GERENTE)) {
            String path = "./Report/ReportManagerJSP.jsp";
            request.setAttribute("path", path);
            //else if == "DIRETORIA" path do Management e  dispatcher padrao
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } else if (user.checkRole(user, Roles.GERENTE_GLOBAL) || user.checkRole(user, Roles.DIRETORIA)) {
            String path = "./Report/ReportManagementJSP.jsp";
            request.setAttribute("path", path);
            //else if == "DIRETORIA" path do Management e  dispatcher padrao
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void generate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("report") == null) {
                session.setAttribute("report", new Report());
            }
            User user = (User) session.getAttribute("user");
            if (user.checkRole(user, Roles.GERENTE)) {
                Report report = ReportController.generateRegionalReport(user.getIdBranch(), user);
                session.setAttribute("report", report);
                session.setAttribute("reportItems", report.getItemList());
            } else if (user.checkRole(user, Roles.GERENTE_GLOBAL) || user.checkRole(user, Roles.DIRETORIA)) {
                Report report = ReportController.generateAllReports(user);
                session.setAttribute("reportAll", report);
                session.setAttribute("allBranches", report.getBranchList());
            }
            response.sendRedirect(request.getContextPath() + "/report");
        } catch (SQLException ex) {
            Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
