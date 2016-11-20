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

public class Country{
    
    Connection con = OracleConnection.getInstance().getCon();
    
        public void addLocation(String countryId, String countryName, 
                                String regionId) throws SQLException{
        String sql = "{ call add_location(?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, countryId);
        callstm.setString(2, countryName);
        callstm.setString(3, regionId);
        callstm.execute();
        callstm.close();
    }

    public void updateLocation(String countryId, String countryName, 
                                String regionId) throws SQLException{
        String sql = "{ call update_location(?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setString(1, countryId);
        callstm.setString(2, countryName);
        callstm.setString(3, regionId);
        callstm.execute();
        callstm.close();
    }    
    
    public void deleteLocation(Integer locationId, String countryId) throws SQLException{
        String sql = "{ call delete_location(?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setInt(1, locationId);
        callstm.setString(2, countryId);
        callstm.execute();
        callstm.close();
    }    
    
}
