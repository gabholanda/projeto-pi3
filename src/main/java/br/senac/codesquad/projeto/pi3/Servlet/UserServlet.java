/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.UserController;
import br.senac.codesquad.projeto.pi3.models.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
public class UserServlet extends HttpServlet {

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
                case "/user":
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
            throws IOException, ServletException {
        String path = "./User/UserCreate.jsp";
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

        User user = UserController.findById(id);

        request.setAttribute("idAttr", user.getId());
        request.setAttribute("nameAttr", user.getName());
        request.setAttribute("mailAttr", user.getMail());
        request.setAttribute("passwordAttr", user.getPassword());

        String path = "./User/UserEdit.jsp";
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
        String mail = (request.getParameter("mail"));
        String password = (request.getParameter("password"));
        String permission = (request.getParameter("permission"));
        int id = Integer.parseInt(idAttr);

        UserController.update(id, name, mail, password, permission);
        response.sendRedirect("user");
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = (request.getParameter("name"));
        String mail = (request.getParameter("mail"));
        String password = (request.getParameter("password"));
        String permission = (request.getParameter("permission"));

        UserController.create(name, mail, password, permission);
        response.sendRedirect("user");

    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String id = request.getParameter("id");
        String permission = request.getParameter("permission");
        UserController.delete(Integer.parseInt(id),permission);
        response.sendRedirect("client");

    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        try {
            ArrayList<User> userList = UserController.read();
            String path = "./User/UserList.jsp";
            request.setAttribute("clientList", userList);
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
