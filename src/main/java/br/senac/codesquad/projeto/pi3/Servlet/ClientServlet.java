
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;
//

import br.senac.codesquad.projeto.pi3.controllers.ClientController;
import br.senac.codesquad.projeto.pi3.models.Client;
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
// Give url paths by servletPath or getPathInfo depending on situation
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
                    delete(request, response);
                    break;

                case "/edit":
                    formEdit(request, response);
                    break;

                case "/update":
                    update(request, response);
                    break;

                case "/searchClient":
                    searchClient(request, response);
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
        //Delegate all post responsabilities to doGet method
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);

    }

    private void form(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = "./Client/ClientCreate.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String idAttr = request.getParameter("id");

        if (idAttr == null) {
            response.sendRedirect(request.getContextPath() + "/client");
            return;
        }
        Client client = ClientController.findById(Integer.parseInt(idAttr));
        if (client == null) {
            response.sendRedirect(request.getContextPath() + "/client");
            return;
        }
        request.setAttribute("idAttr", client.getId());
        request.setAttribute("nameAttr", client.getName());
        request.setAttribute("cpfAttr", client.getCpf());
        request.setAttribute("addressAttr", client.getAddress());
        request.setAttribute("mailAttr", client.getMail());

        String path = "./Client/ClientEdit.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        String idAttr = request.getParameter("id");
        String name = (request.getParameter("name"));
        String cpf = (request.getParameter("cpf"));
        String address = (request.getParameter("address"));
        String mail = (request.getParameter("mail"));
        int id = Integer.parseInt(idAttr);
        if (name == null || cpf == null || address == null || mail == null) {
            request.setAttribute("errorCreateClient", "Não é possível finalizar essa ação com campos vazios!");
            response.sendRedirect(request.getContextPath() + "/client/edit");
        } else {
            if (ClientController.update(id, name, cpf, address, mail)) {
                searchClient(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/client/edit");
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String address = request.getParameter("address");
        String mail = request.getParameter("mail");

        if (name == null || cpf == null || address == null || mail == null) {
            request.setAttribute("errorCreateClient", "Não é possível finalizar essa ação com campos vazios!");
            response.sendRedirect(request.getContextPath() + "/client/new");
        } else {
            if (ClientController.create(name, cpf, address, mail)) {
                searchClient(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/client/new");
            }
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        try {
            String id = request.getParameter("id");
            request.setAttribute("id", id);

            ClientController.delete(Integer.parseInt(id));
            searchClient(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            String path = "./Client/ClientList.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(BranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

    private static void searchClient(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("clientList") == null) {
                session.setAttribute("clientList", new ArrayList<>());
            }
            String name = request.getParameter("name");
            List<Client> clientList = ClientController.findByName(name);
            session.setAttribute("clientList",
                    clientList);
            response.sendRedirect(request.getContextPath() + "/client");
        } catch (IOException ex) {
            Logger.getLogger(SaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
