/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Interfaces;

import javax.websocket.Session;

/**
 *
 * @author patrickchagas
 */
public interface Authenticable {
    public abstract Session login();
    
    public abstract Session Logout();
}
