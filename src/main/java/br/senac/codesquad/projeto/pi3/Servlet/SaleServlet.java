/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

/**
 *
 * @author gabriel.hsantos21
 */
import br.senac.codesquad.projeto.pi3.controllers.ClientController;
import br.senac.codesquad.projeto.pi3.controllers.ProductController;
import br.senac.codesquad.projeto.pi3.models.Client;
import br.senac.codesquad.projeto.pi3.models.Product;
import br.senac.codesquad.projeto.pi3.models.Sale;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
 * @author gabriel.hsantos21
 */
@WebServlet(name = "SaleServlet", urlPatterns = {"/sale/*"})
public class SaleServlet extends HttpServlet {

    private Sale sale;
    private Client client;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
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
                case "/new":
                    form(request, response);
                    break;
                case "/client":
                    client(request, response);
                    break;
                case "/product":
                    product(request, response);
                default:
                    form(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public static void form(HttpServletRequest request, HttpServletResponse response) {
        try {
            String path = "./Sale/SaleJSP.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void client(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("clientList") == null) {
                session.setAttribute("clientList",
                        new ArrayList<Client>());
            }
            String name = request.getParameter("name");
            List<Client> clientList = ClientController.findByName(name);
            session.setAttribute("clientList",
                    clientList);
            response.sendRedirect(request.getContextPath() + "/sale");
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void product(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("productList") == null) {
                session.setAttribute("productList",
                        new ArrayList<Product>());
            }
            String name = request.getParameter("productName");
            List<Product> productList = ProductController.findByName(name);
            session.setAttribute("productList",
                    productList);
            response.sendRedirect(request.getContextPath() + "/sale");
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
