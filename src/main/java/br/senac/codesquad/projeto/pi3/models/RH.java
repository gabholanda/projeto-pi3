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
 * @author patrickchagas
 */
public class RH extends User implements Authenticable {

    private final Roles permission = Roles.BACKOFFICE; //permission user 

    public RH(String name, String mail, String password) {
        super(mail, password, name);
    }

    public RH() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//   
    /**
     * @return the permission
     */
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
