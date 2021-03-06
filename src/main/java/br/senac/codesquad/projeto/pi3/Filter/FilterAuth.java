/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Filter;

import br.senac.codesquad.projeto.pi3.enums.Roles;
import br.senac.codesquad.projeto.pi3.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @author marcelo.smoraes2
@WebFilter(filterName = "FilterAuth", urlPatterns = {"/branch/*", "/client/*", "/product/*", "/user/*", "/sale/*",
    "/report/*", "/home/*"})

public class FilterAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute("user") == null) {
            session.invalidate();
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        User user = (User) session.getAttribute("user");

        if (checkAuth(user, httpRequest)) {
            chain.doFilter(request, response);
        } else {
            String path = "./Auth/NoAuth.jsp";
            request.setAttribute("path", path);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/IndexJSP.jsp");
            dispatcher.forward(request, response);
        }

    }

    private boolean checkAuth(User user, HttpServletRequest request) {
        String urlAcessada = request.getRequestURI();

        if (urlAcessada.endsWith("/login") || urlAcessada.endsWith("/about") || urlAcessada.endsWith("/home")) {
            return true;

        } else if (urlAcessada.contains("/branch")
                && (user.checkRole(user, Roles.DIRETORIA) || user.checkRole(user, Roles.GERENTE) || user.checkRole(user, Roles.GERENTE_GLOBAL))) {
            return true;

        } else if (urlAcessada.contains("/report")
                && (user.checkRole(user, Roles.DIRETORIA) || user.checkRole(user, Roles.GERENTE) || user.checkRole(user, Roles.GERENTE_GLOBAL))) {
            return true;

        } else if (urlAcessada.contains("/product") && user.checkRole(user, Roles.BACKOFFICE)) {
            return true;

        } else if (urlAcessada.contains("/user") && (user.checkRole(user, Roles.RH) || user.checkRole(user, Roles.TI))) {
            return true;

        } else if (urlAcessada.contains("/sale") && user.checkRole(user, Roles.VENDAS)) {
            return true;

        } else if (urlAcessada.contains("/client") && user.checkRole(user, Roles.VENDAS)) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }
}
