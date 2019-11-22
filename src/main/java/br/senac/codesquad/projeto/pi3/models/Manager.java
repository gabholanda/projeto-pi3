/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.enums.Roles;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcelo.moraes
 */
public class Manager extends User {

    private final Roles permission = Roles.GERENTE; //permission user 

    public Manager(String mail, String password) {
        super(mail, password);
    }

    public Manager() {

    }

    @Override
    public Roles getPermission() {
        return permission;
    }

    @Override
    public HttpSession login() {
        return null;
    }

    @Override
    public HttpSession logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
