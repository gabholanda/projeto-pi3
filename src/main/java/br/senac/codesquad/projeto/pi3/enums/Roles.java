/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.enums;

/**
 *
 * @author gabriel.hsantos21
 */
public enum Roles {
    
    VENDAS("VENDAS"),
    TI("TI"),
    RH("RH"),
    GERENTE("GERENTE"),
    DIRETORIA("DIRETORIA"),
    BACKOFFICE("BACKOFFICE");
    
    private String permission;
 
    Roles(String permission) {
        this.permission = permission;
    }
 
    public String getPermission() {
        return permission;
    }
    
}
