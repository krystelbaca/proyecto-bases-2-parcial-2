/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import mx.uach.fing.bases2.aplicacion.java.Conection.OracleConnection;

/**
 *
 * @author eopg9
 */

public class EmployeeInterface {
   
    Connection con = OracleConnection.getInstance().getCon(); 
    
    public void addEmployee(String firstName, String lastName, 
                            String email, String phoneNumber, 
                            java.sql.Date hireDate, String jobId,
                            Float salary, Float commissionPct,
                            Integer managerId, Short departmentId) throws SQLException{
        String sql = "{ call add_employee(?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, firstName);
        callstm.setString(2, lastName);
        callstm.setString(3, email);
        callstm.setString(4, phoneNumber);
        callstm.setDate(5, hireDate);
        callstm.setString(6, jobId);
        callstm.setFloat(7, salary);
        callstm.setFloat(8, commissionPct);
        callstm.setInt(9, managerId);
        callstm.setShort(10, departmentId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }

    public void updateEmployee(Integer employeeId, String firstName, 
                            String lastName, String email, 
                            String phoneNumber, java.sql.Date hireDate, 
                            String jobId, Float salary, 
                            Float commissionPct, Integer managerId, 
                            Short departmentId) throws SQLException{
        String sql = "{ call update_employee(?,?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setInt(1, employeeId);
        callstm.setString(2, firstName);
        callstm.setString(3, lastName);
        callstm.setString(4, email);
        callstm.setString(5, phoneNumber);
        callstm.setDate(6, hireDate);
        callstm.setString(7, jobId);
        callstm.setFloat(8, salary);
        callstm.setFloat(9, commissionPct);
        callstm.setInt(10, managerId);
        callstm.setShort(11, departmentId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }    
    
    public void deleteEmployee(Integer employeeId) throws SQLException{
        String sql = "{ call delete_employee(?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setInt(1, employeeId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }
    
    public void updateDatabase() throws SQLException{
        String sqlUpdate = "{ call DBMS_MVIEW.REFRESH('view_all_employees')}";
        CallableStatement callstmUpdate = con.prepareCall(sqlUpdate);
        callstmUpdate.executeQuery();
        callstmUpdate.close();
    }
}
