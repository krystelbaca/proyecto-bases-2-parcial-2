/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import mx.uach.fing.bases2.aplicacion.java.entities.Department;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author eopg9
 */
public class TestDepartment {
    
    public TestDepartment() {
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
        Department d = new Department();
        
        d.addDepartment("Graphic Design",122,1400);
//        
//        l.updateDepartment(,"Graphic Design",122,1400);

//        l.deleteLocation(3000, "MX");
    }
}
