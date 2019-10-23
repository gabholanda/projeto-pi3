/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ProductController;
import br.senac.codesquad.projeto.pi3.models.Product;
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
                case "/SearchProduct":
                    read(request, response);
                    break;
                case "/new":
                    form(request, response);
                case "/FormEdit":
                    formEditProduct(request, response);
                    break;
                case "/menuProduct":
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
                    read(request, response);   
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            ArrayList<Product> productList = ProductController.read();
            String path = "./ProductJSP/SearchProduct.jsp";
            request.setAttribute("productList", productList);
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
    
    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./ProductJSP/FormProduct.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }
    
    private void formEditProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String idProductAttr = request.getParameter("idProduct");
        int id = Integer.parseInt(idProductAttr);

        Product product = ProductController.findById(id);

        request.setAttribute("idProductAttr", product.getId());
        request.setAttribute("nameProductAttr", product.getNameProduct());
        request.setAttribute("valuesAttr", product.getValues());
        request.setAttribute("valuesSaleAttr", product.getValuesSale());
        request.setAttribute("detailsAttr", product.getDetails());
        request.setAttribute("idBranchOfficeAttr", product.getIdBranchOffice());

        String path = "./ProductJSP/FormEdit.jsp";
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
            throws IOException ,SQLException{
        String nameProduct = request.getParameter("nameProduct");
        String values = request.getParameter("values");
        String valuesSale = request.getParameter("valuesSale");
        String details = request.getParameter("details");
    
        ProductController.create(
                nameProduct,
                Double.parseDouble(values),
                Double.parseDouble(valuesSale),
                details);
        response.sendRedirect("product");
        
    }
    /* String nameProduct = request.getParameter("nameProduct");
        String values = request.getParameter("values");
        String valuesSale = request.getParameter("valuesSale");
        String details = request.getParameter("details");
        String idBranchOffice = request.getParameter("idBranchOffice");
    
        ProductController.create(
                nameProduct,
                Double.parseDouble(values),
                Double.parseDouble(valuesSale),
                details, 1);
        response.sendRedirect("product");*/

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        try{
        String idStr = request.getParameter("id");
        request.setAttribute("idAttr", idStr);

        ProductController.delete(Integer.parseInt(idStr));
        response.sendRedirect("");
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        String idAttr = request.getParameter("id");
        
        String nameProduct = request.getParameter("nameProduct");
        String values = request.getParameter("values");
        String valuesSale = request.getParameter("valuesSale");
        String details = request.getParameter("details");
        
        int id= Integer.parseInt(idAttr);
        
        ProductController.update(id, 
                nameProduct,
                Double.parseDouble(values),
                Double.parseDouble(valuesSale),
                details);
        
        response.sendRedirect("product");

    }
}
