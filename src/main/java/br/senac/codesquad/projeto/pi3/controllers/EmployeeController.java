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

    public static boolean save(int id, String name, String mail, String password) {
        Employee employee = new Employee(name, mail, password);
        return EmployeeDAO.save(employee);

    }

    public static boolean update(int id, String name, String mail, String password) {
        Employee employee = new Employee(name, mail, password);
        return EmployeeDAO.update(employee);

    }

    public static boolean delete(int id) {
        return EmployeeDAO.delete(id);
    }

    public static ArrayList<String[]> getEmployee() {
        ArrayList<Employee> employee = EmployeeDAO.getEmployee();
        ArrayList<String[]> Listemployees = new ArrayList<>();

        for (int i = 0; i < employee.size(); i++) {
            Listemployees.add(new String[]{String.valueOf(employee.get(i).getId()),
                employee.get(i).getName(),
                employee.get(i).getMail(),
                employee.get(i).getPassword(),});

        }
        
        return Listemployees; 

    }
}
