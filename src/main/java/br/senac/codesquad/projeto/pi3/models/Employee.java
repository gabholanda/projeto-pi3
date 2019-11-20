/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

import br.senac.codesquad.projeto.pi3.Interfaces.Authenticable;
import br.senac.codesquad.projeto.pi3.enums.Roles;
import javax.websocket.Session;

/**
 *
 * @author gabriel.hsantos21
 */
public class Employee extends User implements Authenticable {

    private final Roles permission = Roles.VENDAS ; //permission user

    public Employee() {
    }

    public Employee(String mail, String password, String name) {
        super(mail, password, name);
    }

    
    public Roles getPermission() {
        return permission;
    }
    
    @Override
    public Session login() {
        return null;
    }

    @Override
    public Session Logout() {
        return null;
    }

}
