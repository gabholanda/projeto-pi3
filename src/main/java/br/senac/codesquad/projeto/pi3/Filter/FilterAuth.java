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
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @author marcelo.smoraes2
@WebFilter(filterName = "FilterAuth", urlPatterns = {"/branch/*", "/client/*", "/product/*", "/user/*", "/sale/*", "/report/*",})

public class FilterAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute("user") == null) {
            session.invalidate();
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        User usuario = (User) session.getAttribute("FilterAuth");

        if (checkAuth(usuario, httpRequest)) {

            chain.doFilter(request, response);
        } else {

            httpResponse.sendRedirect(httpRequest.getContextPath()
                    + "/erro-nao-autorizado.jsp");
        }

    }

    private boolean checkAuth(User user, HttpServletRequest request) {
        String urlAcessada = request.getRequestURI();

        if (urlAcessada.endsWith("/auth/LoginJSP") || urlAcessada.endsWith("/infoScreens/about")) {
            return true;

        } else if (urlAcessada.contains("/branch") && user.verificarPapel(user, Roles.DIRETORIA) || user.verificarPapel(user, Roles.GERENTE)) {
            return true;

        } else if (urlAcessada.contains("/report") && user.verificarPapel(user, Roles.DIRETORIA) || user.verificarPapel(user, Roles.valueOf("GERENTE"))) {
            return true;

        } else if (urlAcessada.contains("/product") && user.verificarPapel(user, Roles.valueOf("BACKOFFICE"))) {
            return true;

        } else if (urlAcessada.contains("/user") && user.verificarPapel(user, Roles.valueOf("RH")) || user.verificarPapel(user, Roles.valueOf("TI"))) {
            return true;

        } else if (urlAcessada.contains("/sale") && user.verificarPapel(user, Roles.valueOf("VENDAS"))) {
            return true;

        } else if (urlAcessada.contains("/client") && user.verificarPapel(user, Roles.valueOf("VENDAS"))) {
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
