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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas.paiva
 */
public class BranchOfficeController {

    public static boolean create(String name, String address, String cnpj) throws SQLException {
        BranchOffice branch = new BranchOffice(name, address, cnpj);
        return BranchOfficeDAO.create(branch);

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
        try {
            return BranchOfficeDAO.findBydId(id);
        } catch (SQLException ex) {
            Logger.getLogger(BranchOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<BranchOffice> findBranchOffice() throws SQLException {
        return BranchOfficeDAO.findCategoryName();
    }

}
