
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
 * @author henrique.csousa
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product/*"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delegate all post responsabilities to doGet method
        request.setCharacterEncoding("UTF-8");
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
// Give url paths by servletPath or getPathInfo depending on situation
        try {
            switch (action) {
                case "/product":
                    read(request, response);
                    break;
                case "/new":
                    form(request, response);
                    break;
                case "/create":
                    create(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
                case "/edit":
                    formEdit(request, response);
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
            String path = "./Product/ProductList.jsp";
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
        String path = "./Product/ProductCreate.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String idAttr = request.getParameter("id");
        int id = Integer.parseInt(idAttr);

        Product product = ProductController.findById(id);

        request.setAttribute("idAttr", product.getId());
        request.setAttribute("nameProductAttr", product.getNameProduct());
        request.setAttribute("valuesAttr", product.getValues());
        request.setAttribute("valuesSaleAttr", product.getValuesSale());
        request.setAttribute("detailsAttr", product.getDetails());
        request.setAttribute("quantidadeAttr", product.getQuantidade());

        String path = "./Product/ProductEdit.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }
    
     private void update(HttpServletRequest request, HttpServletResponse response) 
             throws IOException, Exception {

        String idAttr = request.getParameter("id");
        String nameProduct = request.getParameter("name");
        String values = request.getParameter("buyValue");
        String valuesSale = request.getParameter("saleValue");
        String details = request.getParameter("details");
        String quantidade = request.getParameter("quantidade"); 

        int id = Integer.parseInt(idAttr);

        ProductController.update(id, nameProduct, Double.parseDouble(values),Double.parseDouble(valuesSale),details, Integer.parseInt(quantidade));

        response.sendRedirect("product");

    }
    

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String nameProduct = request.getParameter("name");
        String values = request.getParameter("purchasePrice");
        String valuesSale = request.getParameter("priceSale");
        String details = request.getParameter("description");
        String quantidade = request.getParameter("quantidade"); 

        ProductController.create( nameProduct, Double.parseDouble(values),Double.parseDouble(valuesSale),details, Integer.parseInt(quantidade));
        response.sendRedirect("product");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException, SQLException {
        try {
            String id = request.getParameter("id");
            request.setAttribute("idAttr", id);

            ProductController.delete(Integer.parseInt(id));
            response.sendRedirect("product");
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
