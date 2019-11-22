/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Interfaces;

import javax.servlet.http.HttpSession;

/**
 *
 * @author patrickchagas
 */
public interface Authenticable {

    public HttpSession login();

    public HttpSession logout();
}
