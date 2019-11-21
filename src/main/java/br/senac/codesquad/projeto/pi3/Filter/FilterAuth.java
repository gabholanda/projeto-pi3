///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
////package br.senac.codesquad.projeto.pi3.Filter;
//
//import br.senac.codesquad.projeto.pi3.enums.Roles;
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
///*
// *
// * @author marcelo.smoraes2
// */
//@WebFilter(filterName = "FilterAuth", urlPatterns = {"/branch/", "/client/", "/product/", "/user/", "/sale/", "/report/",})
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
//
//            chain.doFilter(request, response);
//        } else {
//
//            httpResponse.sendRedirect(httpRequest.getContextPath()
//                    + "/erro-nao-autorizado.jsp");
//        }
//
//    }
//
//    private boolean checkAuth(User user, HttpServletRequest httpRequest) {
//
//        String urlAcessada = httpRequest.getRequestURI();
//
//        if (urlAcessada.contains("/Home")) {
//            return true;
//
//        } else if (urlAcessada.contains("/branch") && user.verificarPapel(Roles.DIRETORIA)) {
//            return true;
//
//        } else if (urlAcessada.contains("/report") && user.verificarPapel(Roles.DIRETORIA)) {
//            return true;
//
//        } else if (urlAcessada.contains("/branch") && user.verificarPapel(Roles.GERENTE)) {
//            return true;
//        } else if (urlAcessada.contains("/report") && user.verificarPapel(Roles.GERENTE)) {
//            return true;
//
//        } else if (urlAcessada.contains("/product") && user.verificarPapel(Roles.BACKOFFICE)) {
//            return true;
//
//        } else if (urlAcessada.contains("/user") && user.verificarPapel(Roles.RH)) {
//            return true;
//
//        } else if (urlAcessada.contains("/user") && user.verificarPapel(Roles.TI)) {
//            return true;
//
//        } else if (urlAcessada.contains("/sale") && user.verificarPapel(Roles.VENDAS)) {
//            return true;
//        } else if (urlAcessada.contains("/client") && user.verificarPapel(Roles.VENDAS)) {
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