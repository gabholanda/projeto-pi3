/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.codesquad.projeto.pi3.DAOs;

import br.senac.codesquad.projeto.pi3.models.Employee;
import java.util.ArrayList;

/**
 *
 * @author gabriel.hsantos21
 */
public class EmployeeDAO {

   
    public static ArrayList<Employee> getEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean save(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean update(Employee employee) {
        
        boolean returnn = false; 
        
        /*     try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comand = connection.prepareStatement("UPDATE USER SET "
                    + "NAME=?, EMAIL=?, PASSWORD=?, PERMISSIONS=?"
                    + "WHERE ID_USER=?");

            comand.setString(1, client.getName());
            comand.setString(2, client.getEmail());
            comand.setString(3, client.getPassword());
            comand.setString(4, client.getPermissions());

            int lineserror = comand.executeUpdate();

            if (lineserror > 0) {
                returnn = true;
            } else {
                returnn = false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            returnn = false;

        } finally { 
            try { 
                connection.close();
            } catch (SQLException ex){ 
                returnn = false; 
            }
        }
        
        return returnn; */
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean delete(int id) {
        
        boolean returnn = false; 
        
        /*   try { 
            
            Class.forName(DRIVER); 
            connection = DriverManager.getConnection(URL, LOGIN, SENHA); 
            
            PreparedStatement comand = connection.prepareStatement("DELETE FROM CLIENT WHERE ID_EMPLOYEE=?"); 
            
            comand.setInt(1, id);
            
            int lineserror = comand.executeUpdate(); 
            
            if(lineserror > 0){ 
                returnn = true; 
            } else { 
                returnn = false; 
            }                        
            
        }catch (ClassNotFoundException | SQLException ex) { 
            returnn = false; 
        }finally { 
            try { 
                connection.close();
            }catch (SQLException ex) { 
                returnn = false; 
            }
        }
        
       return returnn; */
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
