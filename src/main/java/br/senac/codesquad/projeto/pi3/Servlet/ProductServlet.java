/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ProductController;
import br.senac.codesquad.projeto.pi3.models.Category;
import br.senac.codesquad.projeto.pi3.models.Product;
import br.senac.codesquad.projeto.pi3.models.User;
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
 * @author henrique.csousa
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product/*"})
public class ProductServlet extends HttpServlet {

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

                case "/searchProduct":
                    searchProduct(request, response);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delegate all post responsabilities to doGet method
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        List<Category> categoryList = ProductController.findCategory();
        request.setAttribute("categoryList", categoryList);
        String path = "./Product/ProductCreate.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        String idAttr = request.getParameter("id");
        int id = Integer.parseInt(idAttr);
        List<Category> categoryList = ProductController.findCategory();

        Product product = ProductController.findById(id);

        request.setAttribute("idAttr", product.getId());
        request.setAttribute("nameProductAttr", product.getNameProduct());
        request.setAttribute("descriptionAttr", product.getDetails());
        request.setAttribute("priceSaleAttr", product.getValuesSale());
        request.setAttribute("priceBuyAttr", product.getValues());
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("categoryAttr", product.getCategoryId());

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
        String values = request.getParameter("priceBuy");
        String valuesSale = request.getParameter("priceSale");
        String details = request.getParameter("description");
        String quantidade = request.getParameter("quantity");
        String category = request.getParameter("categoryName");

        int id = Integer.parseInt(idAttr);

        ProductController.update(id, nameProduct, Double.parseDouble(values), Double.parseDouble(valuesSale), details, Integer.parseInt(category), Integer.parseInt(quantidade));

        response.sendRedirect(request.getContextPath() + "/product");

    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        HttpSession session = request.getSession();
        String nameProduct = request.getParameter("name");
        String values = request.getParameter("priceBuy");
        String valuesSale = request.getParameter("priceSale");
        String details = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");
        String quantity = request.getParameter("quantity");

        User user = (User) session.getAttribute("user");

        ProductController.create(nameProduct, Double.parseDouble(values), Double.parseDouble(valuesSale),
                details, user.getIdBranch(), Integer.parseInt(categoryId), Integer.parseInt(quantity));
        // details,Integer.parseInt(category));

        response.sendRedirect(request.getContextPath() + "/product");

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        try {
            String id = request.getParameter("id");
            request.setAttribute("id", id);

            ProductController.delete(Integer.parseInt(id));
            response.sendRedirect(request.getContextPath() + "/product");
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            String path = "./Product/ProductList.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("productList") == null) {
                session.setAttribute("productList", new ArrayList<>());
            }
            String name = request.getParameter("productName");
            List<Product> productList = ProductController.findByName(name);
            session.setAttribute("productList",
                    productList);
            response.sendRedirect(request.getContextPath() + "/product");
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
