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
    
    private static int permission = 3; 
    
    public Management(String name, String mail, String password ) {
        super(mail, password, name);
    }
    
    @Override
    public int getPermission() {
        return permission;
    }
    
    
}
