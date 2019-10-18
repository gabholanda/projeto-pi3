/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.controllers;

import br.senac.codesquad.projeto.pi3.DAOs.EmployeeDAO;
import br.senac.codesquad.projeto.pi3.models.Employee;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class EmployeeController {

    public static boolean save(int id, String senha, String name, String mail) {
        Employee employee = new Employee(senha, name, mail);
        return EmployeeDAO.save(employee);

    }

    public static boolean update(int id, String senha, String name, String mail) {
        Employee employee = new Employee(senha, name, mail);
        return EmployeeDAO.update(employee);

    }

    public static boolean delete(int id) {
        return EmployeeDAO.delete(id);
    }

    public static ArrayList<String[]> getEmployee() {
        ArrayList<Employee> employee = EmployeeDAO.getEmployee();
        ArrayList<String[]> employees = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            // employee.add(new String[]
        }

        return employees;

    }

}
