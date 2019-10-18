/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ClientController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 *
 * @author marcelo.moraes
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/client"})
public class ClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = "./Client/ClientJSP.jsp";
        request.setAttribute("path", path);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String address = request.getParameter("address");
        String mail = request.getParameter("mail");

        request.setAttribute("idAttr", idStr);
        request.setAttribute("nameAttr", name);
        request.setAttribute("cpfAttr", cpf);
        request.setAttribute("addressAttr", address);
        request.setAttribute("mailAttr", mail);

        ClientController.save(Integer.parseInt(idStr), name, cpf, address, mail);

    }
}
