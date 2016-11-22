/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mx.uach.fing.bases2.aplicacion.java.Conection.OracleConnection;

/**
 *
 * @author eopg9
 */

public class LocationInterface{

    Integer locationId;
    String nombre;
     
    Connection con = OracleConnection.getInstance().getCon();

    public void addLocation(String streetAddress, String postalCode, 
                            String city, String stateProvince, String countryId) throws SQLException{
        String sql = "{ call add_location(?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, streetAddress);
        callstm.setString(2, postalCode);
        callstm.setString(3, city);
        callstm.setString(4, stateProvince);
        callstm.setString(5, countryId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }

    public void updateLocation(Short locationId, String streetAddress, String postalCode, 
                            String city, String stateProvince, String countryId) throws SQLException{
        String sql = "{ call update_location(?,?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setShort(1, locationId);
        callstm.setString(2, streetAddress);
        callstm.setString(3, postalCode);
        callstm.setString(4, city);
        callstm.setString(5, stateProvince);
        callstm.setString(6, countryId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }    
    
    public void deleteLocation(Short locationId) throws SQLException{
        String sql = "{ call delete_location(?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setShort(1, locationId);
        callstm.execute();
        callstm.close();
        updateDatabase();
    }    
    
        public void updateDatabase() throws SQLException{
        String sqlUpdate = "{ call DBMS_MVIEW.REFRESH('view_all_locations')}";
        CallableStatement callstmUpdate = con.prepareCall(sqlUpdate);
        callstmUpdate.executeQuery();
        callstmUpdate.close();
    }
}
