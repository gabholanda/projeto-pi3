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

    public static boolean create(String name, String address, String cnpj) throws SQLException {
        return BranchOfficeDAO.create(name, address, cnpj);

    }

    public static boolean delete(int id) throws SQLException {
        return BranchOfficeDAO.delete(id);

    }

    public static boolean update(int id, String name, String cnpj, String address) throws Exception {
        BranchOffice branch = new BranchOffice(id, name, cnpj, address);
        return BranchOfficeDAO.update(branch);

    }

    public static ArrayList<BranchOffice> read() throws Exception {
        return BranchOfficeDAO.read();
    }

    public static BranchOffice findById(int id) {
        return BranchOfficeDAO.findBydId(id);
    }

}
