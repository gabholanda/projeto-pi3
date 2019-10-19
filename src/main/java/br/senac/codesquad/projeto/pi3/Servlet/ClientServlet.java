/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.ClientController;
import br.senac.codesquad.projeto.pi3.models.Client;
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
 *
 *
 * @author marcelo.moraes
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/client/*"})
public class ClientServlet extends HttpServlet {

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
                case "/client":
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
        
        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String address = request.getParameter("address");
        String mail = request.getParameter("mail");

        
        request.setAttribute("nameAttr", name);
        request.setAttribute("cpfAttr", cpf);
        request.setAttribute("addressAttr", address);
        request.setAttribute("mailAttr", mail);

        ClientController.save(name, cpf, address, mail);

    }
    
    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./Client/ClientJSP.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        String idAttr = request.getParameter("id");
        
        int id = Integer.parseInt(idAttr);
        Client client = new Client();
        client.setId(id);
        client.setName(request.getParameter("name"));
        client.setCpf(request.getParameter("cnpj"));
        client.setAddress(request.getParameter("address"));
        client.setMail(request.getParameter("address"));

        ClientController.update(id, idAttr, idAttr, idAttr, idAttr);
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        
        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String address = request.getParameter("address");
        String mail = request.getParameter("mail");

        
        request.setAttribute("nameAttr", name);
        request.setAttribute("cpfAttr", cpf);
        request.setAttribute("addressAttr", address);
        request.setAttribute("mailAttr", mail);

        ClientController.save(name, cpf, address, mail);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getAttribute("id").toString();
        request.setAttribute("id", id);
        ClientController.delete(Integer.parseInt(id));
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        try {
            ArrayList<String[]> clientList = ClientController.getClient(); 
            request.setAttribute("ClientJSP", clientList);
            String path = "./Client/ClientList.jsp";
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