/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import mx.uach.fing.bases2.aplicacion.java.entities.Location;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eopg9
 */
public class TestLocation {
    
    public TestLocation() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() throws SQLException {
            Location l = new Location();
        
        l.addLocation("1325 Campos del sembradio","33125","Chihuhaua","Chihuahuahuahua","MX");
//        
//        l.updateLocation(3000,"5423 Av. Juarez","56213","Guadalajara","Jalisco","MX");

//        l.deleteLocation(3000, "MX");
    }
}
