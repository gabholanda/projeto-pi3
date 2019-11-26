/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Servlet;

import br.senac.codesquad.projeto.pi3.controllers.UserController;
import br.senac.codesquad.projeto.pi3.models.BackOffice;
import br.senac.codesquad.projeto.pi3.models.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lucas.mnpaiva
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "/WEB-INF/Auth/LoginJSP.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        User user = UserController.findByMail(mail, password);
      if (user != null && user.checkPassword(password)) {
            HttpSession session = request.getSession();
            user.login(user, request, session);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("msgErro", "Usuário ou senha incorreta");
            request.getRequestDispatcher("/WEB-INF/Auth/LoginJSP.jsp")
                    .forward(request, response);
        }
    }

}
