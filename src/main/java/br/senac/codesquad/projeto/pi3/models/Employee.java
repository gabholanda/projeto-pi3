/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.models;

/**
 *
 * @author gabriel.hsantos21
 */
public class Employee extends User {

    private static int permission = 1; //permission user

    public Employee(String mail, String password, String name) {
        super(mail, password, name);
    }

    @Override
    public int getPermission() {
        return permission;
    }

}
