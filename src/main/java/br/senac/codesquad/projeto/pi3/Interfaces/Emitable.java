/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.Interfaces;

import br.senac.codesquad.projeto.pi3.models.Report;

/**
 *
 * @author patrickchagas
 */
public interface Emitable {

    public Report generateReport();

    public Report generateOverallReport();
}
