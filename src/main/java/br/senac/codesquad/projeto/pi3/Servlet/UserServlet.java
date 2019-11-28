/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.BranchOfficeController;
import br.senac.codesquad.projeto.pi3.controllers.UserController;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
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
            throws IOException, ServletException, SQLException {
        List<BranchOffice> branchOfficeList = BranchOfficeController.findBranchOffice();
        request.setAttribute("branchOfficeListAttr", branchOfficeList);

        String path = "./User/UserCreate.jsp";
        request.setAttribute("path", path);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/IndexJSP.jsp");
        dispatcher.forward(request, response);
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("user");
        if (loggedUser.checkRole(loggedUser, Roles.RH)) {
            response.sendRedirect(request.getContextPath() + "/user");
            return;
        }
        String idAttr = request.getParameter("id");
        if (idAttr == null) {
            response.sendRedirect(request.getContextPath() + "/user");
            return;
        }

        User user = UserController.findById(Integer.parseInt(idAttr));
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/user");
            return;
        }
        request.setAttribute("idAttr", user.getId());
        request.setAttribute("nameAttr", user.getName());
        request.setAttribute("mailAttr", user.getMail());

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
        String idAttr = request.getParameter("id");
        String name = (request.getParameter("name"));
        String password = (request.getParameter("password"));
        if (name == null || password == null || idAttr == null) {
            String path = "./User/UserEdit.jsp";
            request.setAttribute("path", path);
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            request.setAttribute("errorForm", "É necessário preencher todos os campos");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        } else {
            User user = (User) session.getAttribute("user");
            if (UserController.update(Integer.parseInt(idAttr), name, password, user.getPermission().getPermission())) {
                response.sendRedirect(request.getContextPath() + "/user");
            } else {
                String path = "./User/UserEdit.jsp";
                request.setAttribute("path", path);
                request.setAttribute("name", name);
                request.setAttribute("password", password);
                request.setAttribute("errorForm", "Erro ao tentar editar");
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(
                                "/WEB-INF/IndexJSP.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();

        String name = (request.getParameter("name"));
        String mail = (request.getParameter("email"));
        String password = (request.getParameter("password"));
        String permission = (request.getParameter("permission"));
        String IdEmpresas = (request.getParameter("branchOfficeId"));

        if (session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            if (name == null || mail == null || password == null || permission == null || IdEmpresas == null) {
                List<BranchOffice> branchOfficeList = BranchOfficeController.findBranchOffice();
                String path = "./User/UserCreate.jsp";
                request.setAttribute("branchOfficeListAttr", branchOfficeList);
                request.setAttribute("path", path);
                request.setAttribute("name", name);
                request.setAttribute("mail", mail);
                request.setAttribute("password", password);
                request.setAttribute("permission", permission);
                request.setAttribute("IdEmpresas", IdEmpresas);
                request.setAttribute("errorForm", "É necessário preencher todos os campos");
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(
                                "/WEB-INF/IndexJSP.jsp");
                dispatcher.forward(request, response);
            }
            User user = (User) session.getAttribute("user");
            if (UserController.create(mail, password, name, permission, Integer.parseInt(IdEmpresas), user.getPermission().getPermission())) {
                response.sendRedirect(request.getContextPath() + "/user");
            } else {
                List<BranchOffice> branchOfficeList = BranchOfficeController.findBranchOffice();
                String path = "./User/UserCreate.jsp";
                request.setAttribute("branchOfficeListAttr", branchOfficeList);
                request.setAttribute("path", path);
                request.setAttribute("name", name);
                request.setAttribute("mail", mail);
                request.setAttribute("password", password);
                request.setAttribute("permission", permission);
                request.setAttribute("IdEmpresas", IdEmpresas);
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher(
                                "/WEB-INF/IndexJSP.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (id == null || id.equals("")) {
                session.setAttribute("errorUser", "User não encontrado");
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

    private void read(HttpServletRequest request, HttpServletResponse response)
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
        }
    }
}
