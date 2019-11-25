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
 * @author patrickchagas
 */
public class ManagerGlobal extends User  {
     private final Roles permission = Roles.GERENTE_GLOBAL; //permission user 

    public ManagerGlobal(String mail, String password) {
        super(mail, password);
    }

    public ManagerGlobal() {

    }

    @Override
    public Roles getPermission() {
        return permission;
    }

}
