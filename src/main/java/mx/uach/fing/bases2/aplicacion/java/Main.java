/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.bases2.aplicacion.java;

import java.sql.SQLException;
import mx.uach.fing.bases2.aplicacion.java.entities.Location;

/**
 *
 * @author kryst
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Location l = new Location();
        
        l.addLocation("edgars","d","ds","f","US");
//        
//        l.updateLocation(3000,"as","d","ds","f","US");

//        l.deleteLocation(3000, "US");
    }
}
