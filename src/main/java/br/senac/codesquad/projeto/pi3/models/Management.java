/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

/**
 *
 * @author marcelo.moraes
 */
public class Management extends User {
    
    private int permission = 3; 
    
    public Management(String mail, String password, String name) {
        super(mail, password, name);
    }

    public int getPermission() {
        return permission;
    }
    
    
}
