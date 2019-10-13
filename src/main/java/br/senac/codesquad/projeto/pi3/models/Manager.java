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
public class Manager extends User {

    private int permission = 2; //permission user 

    public Manager(String mail, String senha, String nome) {
        super(mail, senha, nome);
    }

//   
    /**
     * @return the permission
     */
    public int getPermission() {
        return permission;
    }

}
