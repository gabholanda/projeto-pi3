/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.BranchOfficeController;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "BranchServlet", urlPatterns = {"/branch/*"})
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
// Give url paths by servletPath or getPathInfo depending on situation
        try {
            switch (action) {
                case "/branch":
                    read(request, response);
                    break;

                case "/new":
                    form(request, response);
                    break;

                case "/edit":
                    formEdit(request, response);
                    break;

                case "/create":
                    create(request, response);
                    break;

                case "/delete":
                    delete(request, response);
                    break;

                case "/update":
                    update(request, response);
                    break;
                default:
                    read(request, response);
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
        // Delegate all post responsabilities to doGet method
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);

    }

//Pages
    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./Branch/BranchCreate.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String idAttr = request.getParameter("id");
        if (idAttr == null) {
            response.sendRedirect(request.getContextPath() + "/branch");
            return;
        }
        BranchOffice branch = BranchOfficeController.findById(Integer.parseInt(idAttr));
        if (branch == null) {
            response.sendRedirect(request.getContextPath() + "/branch");
            return;
        }
        request.setAttribute("idAttr", branch.getId());
        request.setAttribute("nameAttr", branch.getName());
        request.setAttribute("cnpjAttr", branch.getCnpj());
        request.setAttribute("addressAttr", branch.getAddress());

        String path = "./Branch/BranchEdit.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }
//CRUD

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String cnpj = request.getParameter("cnpj");
            if (name == null || address == null || cnpj == null) {
                request.setAttribute("name", name);
                request.setAttribute("address", address);
                request.setAttribute("cnpj", cnpj);
                String path = "./Branch/BranchCreate.jsp";
                request.setAttribute("path", path);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(
                                "/WEB-INF/IndexJSP.jsp");
                dispatcher.forward(request, response);
                return;
            }
            if (BranchOfficeController.create(name, address, cnpj)) {
                response.sendRedirect(request.getContextPath() + "/branch");
                return;
            }
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("cnpj", cnpj);
            String path = "./Branch/BranchCreate.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException, Exception {
        String idAttr = request.getParameter("id");
        String name = request.getParameter("name");
        String cnpj = request.getParameter("cnpj");
        String address = request.getParameter("address");
        if (idAttr == null || name == null || address == null || cnpj == null) {
            request.setAttribute("id", idAttr);
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("cnpj", cnpj);
            String path = "./Branch/BranchEdit.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (BranchOfficeController.update(Integer.parseInt(idAttr), name, cnpj, address)) {
            response.sendRedirect(request.getContextPath() + "/branch");
            return;
        }
        request.setAttribute("id", idAttr);
        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("cnpj", cnpj);
        String path = "./Branch/BranchEdit.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            String id = request.getParameter("id");
            if (id == null) {
                return;
            }
            BranchOfficeController.delete(Integer.parseInt(id));
            response.sendRedirect(request.getContextPath() + "/branch");
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            ArrayList<BranchOffice> branchList = BranchOfficeController.read();
            String path = "./Branch/BranchList.jsp";
            request.setAttribute("branchList", branchList);
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

}
