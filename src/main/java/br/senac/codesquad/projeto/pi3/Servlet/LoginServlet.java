///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.senac.codesquad.projeto.pi3.Servlet;
//
//import br.senac.codesquad.projeto.pi3.DAOs.UserDAO;
//import br.senac.codesquad.projeto.pi3.models.User;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author lucas.mnpaiva
// */
//@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        HttpSession session = request.getSession();
//
//        if (session.getAttribute("usuarioLogado") != null) {
//
//            response.sendRedirect(request.getContextPath() + "/Home");
//            return;
//        }
//
//        request.getRequestDispatcher("/WEB-INF/Auth/LoginJSP.jsp")
//                .forward(request, response);
//
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher(
//                        "/WEB-INF/IndexJSP.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            request.setCharacterEncoding("UTF-8");
//            String mail = request.getParameter("mail");
//            String password = request.getParameter("password");
//            
//            User usuario = UserDAO.findbyMail(mail);
//            
//            if (usuario != null && usuario.checkPassword(password)) {
//                HttpSession session = request.getSession();
//                session.setAttribute("usuario", usuario);
//                response.sendRedirect(request.getContextPath() + "/Home");
//            } else {
//                request.setAttribute("msgErro", "Usuário ou senha incorreta");
//                request.getRequestDispatcher("/WEB-INF/Auth/loginJSP.jsp")
//                        .forward(request, response);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}