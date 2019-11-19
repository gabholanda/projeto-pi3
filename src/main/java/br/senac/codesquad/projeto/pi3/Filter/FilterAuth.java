/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br.senac.codesquad.projeto.pi3.Filter;
//
//import br.senac.codesquad.projeto.pi3.models.User;
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author marcelo.smoraes2
// */
//@WebFilter(filterName = "FilterAuth",
//        urlPatterns = {"/branch/*",
//            "/client/*",
//            "/product/*",
//            "/user/*",
//            "/sale/*",
//            "/report/*",})
//
//public class FilterAuth implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = httpRequest.getSession();
//
//        if (session.getAttribute("usuario") == null) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
//            return;
//        }
//
//        User usuario = (User) session.getAttribute("usuario");
//
//        if (checkAuth(usuario, httpRequest)) {
//            // Usuario pode acessar a URL
//            chain.doFilter(request, response);
//        } else {
//            // Usuario não tem permissao necessaria -> Mostra msg de erro.
//            httpResponse.sendRedirect(httpRequest.getContextPath()
//                    + "/NoAuth.jsp");
//        }
//
//    }
//
//    private boolean checkAuth(User usuario, HttpServletRequest httpRequest) {
//
//        String urlAcessada = httpRequest.getRequestURI();
//
//        if (urlAcessada.endsWith("/home")) {
//            return true;
//
//        } else if (urlAcessada.endsWith("/branch") && usuario.verificarPapel("PEAO")) {
//            return true;
//
//        } else if (urlAcessada.endsWith("/client") && usuario.verificarPapel("FODON")) {
//            return true;
//
//        } else if (urlAcessada.endsWith("/product") && usuario.verificarPapel("GOD")) {
//            return true;
//
//        } else if (urlAcessada.endsWith("/user") && usuario.verificarPapel("GOD")) {
//            return true;
//
//        } else if (urlAcessada.endsWith("/sale") && usuario.verificarPapel("GOD")) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//}
