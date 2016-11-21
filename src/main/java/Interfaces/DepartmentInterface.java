/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import mx.uach.fing.bases2.aplicacion.java.Conection.OracleConnection;

/**
 *
 * @author eopg9
 */
public class DepartmentInterface{
    Connection con = OracleConnection.getInstance().getCon();
        
    public void addDepartment(String departmentName, Integer managerId, 
                            Short locationId) throws SQLException{
        String sql = "{ call add_department(?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, departmentName);
        callstm.setInt(2, managerId);
        callstm.setInt(3, locationId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }

    public void updateDepartment(Short departmentId, String departmentName, 
                                 Integer managerId, Short locationId) throws SQLException{
        String sql = "{ call update_department(?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setShort(1, departmentId);        
        callstm.setString(2, departmentName);
        callstm.setInt(3, managerId);
        callstm.setInt(4, locationId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }    
    
    public void deleteDepartment(Short departmentId) throws SQLException{
        String sql = "{ call delete_department(?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setShort(1, departmentId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }
    
    public void updateDatabase() throws SQLException{
        String sqlUpdate = "{ call DBMS_MVIEW.REFRESH('view_all_departments')}";
        CallableStatement callstmUpdate = con.prepareCall(sqlUpdate);
        callstmUpdate.executeQuery();
        callstmUpdate.close();
    }    
}
