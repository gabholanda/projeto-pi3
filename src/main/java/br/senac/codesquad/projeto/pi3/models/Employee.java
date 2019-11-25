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
 * @author gabriel.hsantos21
 */
public class Employee extends User {

    private final Roles permission = Roles.VENDAS; //permission user

    public Employee() {
    }

    public Employee(String mail, String password) {
        super(mail, password);
    }

    @Override
    public Roles getPermission() {
        return permission;
    }
}
