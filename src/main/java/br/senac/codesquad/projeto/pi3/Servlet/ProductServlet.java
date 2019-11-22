
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ProductController;
import br.senac.codesquad.projeto.pi3.models.Category;
import br.senac.codesquad.projeto.pi3.models.Product;
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
        
        HttpSession session = request.getSession();
        
        String idAttr = request.getParameter("id");
        String nameProduct = request.getParameter("name");
        String values = request.getParameter("priceBuy");
        String valuesSale = request.getParameter("priceSale");
        String details = request.getParameter("description");
        String quantidade = request.getParameter("quantity");
        String category = request.getParameter("categoryName");
        
        //Validar Campos em branco
        if(session.getAttribute("name")==null || session.getAttribute("pricebuy")==null || 
           session.getAttribute("pricebuy")==null || session.getAttribute("priceSale")==null || 
           session.getAttribute("description")==null || session.getAttribute("quantity")==null)
        {
           session.setAttribute("errorCreateProduct", "Não é possível finalizar essa ação com campos vazios!");
           response.sendRedirect(request.getContextPath() + "/product/new");
        }
        Product product = (Product) session.getAttribute("product");
        //Validar Preco Compra deve ser menor que Preco Venda 
        if(product.getValues()>product.getValuesSale() ){
            session.setAttribute("errorValues","O Valor de Compra não pode ser maior que o valor de venda!");
            response.sendRedirect(request.getContextPath() + "/product/new");
        }
        //Validar limites de caracteres
        if(product.getNameProduct().charAt(0)>100){
            session.setAttribute("errorTamanhoName", "Limite de caracteres excedido!");
            response.sendRedirect(request.getContextPath() + "/product/new");
        }
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
        String category = request.getParameter("categoryName");
        String quantity = request.getParameter("quantity");
        //Validar Campos em branco
        if(session.getAttribute("name")==null || session.getAttribute("pricebuy")==null || 
           session.getAttribute("pricebuy")==null || session.getAttribute("priceSale")==null || 
           session.getAttribute("description")==null || session.getAttribute("quantity")==null)
        {
           session.setAttribute("errorCreateProduct", "Não é possível finalizar essa ação com campos vazios!");
           response.sendRedirect(request.getContextPath() + "/product/new");
        }
        Product product = (Product) session.getAttribute("product");
        //Validar Preco Compra deve ser menor que Preco Venda 
        if(product.getValues()>product.getValuesSale() ){
            session.setAttribute("errorValues","O Valor de Compra não pode ser maior que o valor de venda!");
            response.sendRedirect(request.getContextPath() + "/product/new");
        }
        //Validar limites de caracteres
        if(product.getNameProduct().charAt(0)>100){
            session.setAttribute("errorTamanhoName", "Limite de caracteres excedido!");
            response.sendRedirect(request.getContextPath() + "/product/new");
        }
        //Validar que texto escrito nos campos numéricos
        ProductController.create(nameProduct, Double.parseDouble(values), Double.parseDouble(valuesSale),
                details, 3, 5, Integer.parseInt(quantity));
        

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
        }
    }
}
