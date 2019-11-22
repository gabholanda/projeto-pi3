/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.UserController;
import br.senac.codesquad.projeto.pi3.models.User;
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
import javax.servlet.http.HttpSession;

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
//        request.setAttribute("passwordAttr", user.getPassword());

        String path = "./User/UserEdit.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String idAttr = request.getParameter("id");
        String name = (request.getParameter("name"));
        String password = (request.getParameter("password"));
        int id = Integer.parseInt(idAttr);
        UserController.update(id, name, password, user.getPermission().getPermission());
        response.sendRedirect(request.getContextPath() + "/user");
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession session = request.getSession();

        String name = (request.getParameter("name"));
        String mail = (request.getParameter("email"));
        String password = (request.getParameter("password"));
        String permission = (request.getParameter("permission"));

        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            User user = (User) session.getAttribute("user");
            if (UserController.create(mail, password, name, permission, user.getPermission().getPermission())) {
                response.sendRedirect(request.getContextPath() + "/user");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (id == null || id.equals("")) {
                //ADICIONAR O SETATTRIBUTE DE ERROR AQUI
                response.sendRedirect(request.getContextPath() + "/user");
            } else if ((UserController.delete(Integer.parseInt(id), user.getPermission().getPermission()))) {
                response.sendRedirect(request.getContextPath() + "/user");
            } else {
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");

        }
    }

    public void read(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            ArrayList<User> userList = UserController.read(user.getPermission().getPermission());
            String path = "./User/UserList.jsp";
            request.setAttribute("userList", userList);
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

}
