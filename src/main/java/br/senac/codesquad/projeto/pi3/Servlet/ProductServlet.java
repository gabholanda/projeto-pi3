/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ProductController;
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

/**
 *
 * @author marcelo.moraes
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product/*"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

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
                case "/product":
                    form(request, response);
                    break;
                case "/SearchProduct":
                    search(request, response);
                    break;
                case "/MenuProduct":
                    menu(request, response);
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

                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./ProductJSP/FormProduct.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./ProductJSP/SearchProduct.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void menu(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./ProductJSP/MenuProduct.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String nameProduct = request.getParameter("nameProduct");
        String values = request.getParameter("values");
        String valuesSale = request.getParameter("valuesSale");
        String details = request.getParameter("details");
//        String idBranchOffice = request.getParameter("idBranchOffice");

        request.setAttribute("nameProductAttr", nameProduct);
        request.setAttribute("valuesAttr", values);
        request.setAttribute("valuesSaleAttr", valuesSale);
        request.setAttribute("detailsAttr", details);
//        request.setAttribute("idBranchOfficeAttr", idBranchOffice);

        ProductController.save(
                nameProduct,
                Double.parseDouble(values),
                Double.parseDouble(valuesSale),
                details, 1);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String idStr = request.getParameter("id");
        request.setAttribute("idAttr", idStr);

        ProductController.delete(Integer.parseInt(idStr));

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        String idStr = request.getParameter("id");
        String nameProduct = request.getParameter("nameProduct");
        String values = request.getParameter("values");
        String valuesSale = request.getParameter("valuesSale");
        String details = request.getParameter("details");
        String idBranchOffice = request.getParameter("idBranchOffice");

        request.setAttribute("idAttr", idStr);
        request.setAttribute("nameProductAttr", nameProduct);
        request.setAttribute("valuesAttr", values);
        request.setAttribute("valuesSaleAttr", valuesSale);
        request.setAttribute("detailsAttr", details);
        request.setAttribute("idBranchOfficeAttr", idBranchOffice);

        ProductController.update(Integer.parseInt(idStr),
                nameProduct,
                Double.parseDouble(values),
                Double.parseDouble(valuesSale),
                details);
        response.sendRedirect("list");
        String path = "./ProductJSP/ProductScreen.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
        response.sendRedirect("list");

    }
}
