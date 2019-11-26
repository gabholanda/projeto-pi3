/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.Interfaces.Authenticable;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author patrickchagas
 */
public class BackOffice extends User {

    private final Roles permission = Roles.BACKOFFICE; //permission user 

    public BackOffice(String mail, String password) {
        super(mail, password);
    }

    public BackOffice() {

    }

    @Override
    public Roles getPermission() {
        return permission;
    }

    @Override
    public void login(User user, HttpServletRequest request, HttpSession session) {
        session.setAttribute("user", user);
    }
}
