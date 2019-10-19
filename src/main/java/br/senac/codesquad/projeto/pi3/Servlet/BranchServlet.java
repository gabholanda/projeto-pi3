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

        try {
            switch (action) {
                case "/branch":
                    read(request, response);
                    break;

                case "/new":
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
        doGet(request, response);
    }

    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./Branch/BranchCreate.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        String idAttr = request.getParameter("id");
        String name = request.getParameter("name");
        int id = Integer.parseInt(idAttr);
        BranchOffice Branch = new BranchOffice();
        Branch.setId(id);
        Branch.setName(request.getParameter("name"));
        Branch.setCnpj(request.getParameter("cnpj"));
        Branch.setAddress(request.getAttribute("address").toString());

        BranchOfficeController.UpdateBranch(Branch);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String cnpj = request.getParameter("cnpj");

        request.setAttribute("nameAttr", name);
        request.setAttribute("cnpjAttr", cnpj);
        request.setAttribute("addressAttr", address);

        BranchOfficeController.CreateBranch(name, address, cnpj);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getAttribute("id").toString();
        request.setAttribute("id", id);
        try {
            BranchOfficeController.DeleteBranch(Integer.parseInt(id));
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        try {
            ArrayList<BranchOffice> branchList = BranchOfficeController.ReadBranchs();
            request.setAttribute("branchList", branchList);
            String path = "./Branch/BranchList.jsp";
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
