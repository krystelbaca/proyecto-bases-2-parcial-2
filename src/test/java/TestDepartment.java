/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import Interfaces.DepartmentInterface;
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
        DepartmentInterface d = new DepartmentInterface();
        
        d.addDepartment("Graphic Design",1,1);
//        
//        d.updateDepartment(,"Graphic Design",122,1400);

//        d.deleteLocation(3000, "MX");
    }
}
