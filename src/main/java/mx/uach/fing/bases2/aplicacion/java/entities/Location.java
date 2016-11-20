/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.bases2.aplicacion.java.entities;

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

public class Location{

    Integer locationId;
    String nombre;
     
    Connection con = OracleConnection.getInstance().getCon();

    public java.util.List<String> getLocations(){
    try {
        ArrayList<String> userList = new ArrayList<>();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT location_id from all_locations_view");
        while (rs.next()) {
            userList.add(rs.getString(1));
        }
        return userList;
    } catch (SQLException ex) {
        System.out.println(ex);
        return null;
    }
}    
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
    }

    public void updateLocation(Integer locationId, String streetAddress, String postalCode, 
                            String city, String stateProvince, String countryId) throws SQLException{
        String sql = "{ call update_location(?,?,?,?,?,?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setInt(1, locationId);
        callstm.setString(2, streetAddress);
        callstm.setString(3, postalCode);
        callstm.setString(4, city);
        callstm.setString(5, stateProvince);
        callstm.setString(6, countryId);
        callstm.execute();
        callstm.close();
    }    
    
    public void deleteLocation(Integer locationId) throws SQLException{
        String sql = "{ call delete_location(?)}";
        CallableStatement callstm = con.prepareCall(sql);
        callstm.setInt(1, locationId);
        callstm.execute();
        callstm.close();
    }    
    
}
