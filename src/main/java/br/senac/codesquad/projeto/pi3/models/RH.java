/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.enums.Roles;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author patrickchagas
 */
public class RH extends User {

    private final Roles permission = Roles.RH; //permission user 

    public RH(String mail, String password) {
        super(mail, password);
    }

    public RH() {

    }

//   
    /**
     * @return the permission
     */
    @Override
    public Roles getPermission() {
        return permission;
    }

    @Override
    public void login(User user, HttpServletRequest request, HttpSession session) {
        session.setAttribute("user", user);
    }
}
