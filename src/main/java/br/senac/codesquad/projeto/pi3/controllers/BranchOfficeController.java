/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.BranchOfficeDAO;
import br.senac.codesquad.projeto.pi3.models.BranchOffice;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucas.paiva
 */
public class BranchOfficeController {

    public static boolean CreateBranch(String name, String address, String cnpj) throws SQLException {
        return (BranchOfficeDAO.create(name, address, cnpj));

    }

    public static boolean DeleteBranch(int id) throws SQLException {
        return BranchOfficeDAO.delete(id);

    }

    public static boolean UpdateBranch(BranchOffice Branch) throws Exception {
        return BranchOfficeDAO.update(Branch);

    }

    public ArrayList<BranchOffice> ReadBranchs() throws Exception {
        return BranchOfficeDAO.read();
    }

}
