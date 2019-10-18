/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ProductController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcelo.moraes
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nameProduct = request.getParameter("nameProduct");
        String values = request.getParameter("values");
        String valuesSale = request.getParameter("valuesSale");
        String amount = request.getParameter("amount");
        String stock = request.getParameter("stock");
        String details = request.getParameter("details");
        String idBranchOffice = request.getParameter("idBranchOffice");

        request.setAttribute("idAttr", idStr);
        request.setAttribute("nameProductAttr", nameProduct);
        request.setAttribute("valuesAttr", values);
        request.setAttribute("valuesSaleAttr", valuesSale);
        request.setAttribute("amountAttr", amount);
        request.setAttribute("stockAttr", stock);
        request.setAttribute("detailsAttr", details);
        request.setAttribute("idBranchOfficeAttr", idBranchOffice);

        ProductController.save(
                Integer.parseInt(idStr),
                nameProduct,
                Double.parseDouble(values),
                Integer.parseInt(amount),
                Integer.parseInt(stock),
                details,
                Integer.parseInt(idBranchOffice));

    }
}
