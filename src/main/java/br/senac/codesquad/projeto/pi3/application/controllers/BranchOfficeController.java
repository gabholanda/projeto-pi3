/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.application.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.BranchOfficeDAO;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class BranchOfficeController {
    public boolean CreateBranch(){
        return true;
    }
    public boolean DeleteBranch(){
     return true;   
    }
    public boolean UpdateBranch(){
        return  true;
    }
    public ArrayList<BranchOffice> ReadBranchs() throws Exception{
        return BranchOfficeDAO.read();
    }
    
}
