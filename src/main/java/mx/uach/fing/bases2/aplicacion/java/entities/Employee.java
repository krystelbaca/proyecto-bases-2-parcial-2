/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.bases2.aplicacion.java.entities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mx.uach.fing.bases2.aplicacion.java.Conection.OracleConnection;

/**
 *
 * @author eopg9
 */

public class Employee {
   
    Connection con = OracleConnection.getInstance().getCon();
    
    public ResultSet getEmployees() throws SQLException{
        Statement st = OracleConnection.getInstance().getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * from all_employees_view");
        return rs;
    }
    
    public void addEmployee(String firstName, String lastName, 
                            String email, String phoneNumber, 
                            Date hireDate, String jobId,
                            Integer salary, Float commissionPct,
                            Integer managerId, Integer departmentId) throws SQLException{
        String sql = "{ call add_employee(?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, firstName);
        callstm.setString(2, lastName);
        callstm.setString(3, email);
        callstm.setString(4, phoneNumber);
        callstm.setDate(5, hireDate);
        callstm.setString(6, jobId);
        callstm.setInt(7, salary);
        callstm.setFloat(8, commissionPct);
        callstm.setFloat(9, managerId);
        callstm.setFloat(10, departmentId);
        callstm.execute();
        callstm.close();
    }

    public void updateLocation(String firstName, String lastName, 
                            String email, String phoneNumber, 
                            Date hireDate, String jobId,
                            Integer salary, Float commissionPct,
                            Integer managerId, Integer departmentId) throws SQLException{
        String sql = "{ call update_employee(?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, firstName);
        callstm.setString(2, lastName);
        callstm.setString(3, email);
        callstm.setString(4, phoneNumber);
        callstm.setDate(5, hireDate);
        callstm.setString(6, jobId);
        callstm.setInt(7, salary);
        callstm.setFloat(8, commissionPct);
        callstm.setFloat(9, managerId);
        callstm.setFloat(10, departmentId);
        callstm.execute();
        callstm.close();
    }    
    
    public void deleteLocation(Integer employeeId) throws SQLException{
        String sql = "{ call delete_employee(?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setInt(1, employeeId);
        callstm.execute();
        callstm.close();
    }    
}
