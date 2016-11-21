/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.ViewEmployee;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.uach.fing.bases2.aplicacion.java.Conection.OracleConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        
            Connection con = OracleConnection.getInstance().getCon();
//            Location l = new Location();
//        
//        l.addLocation("1325 Campos del sembradio","33125","Chihuhaua","Chihuahuahuahua","MX");
//        
//        l.updateLocation(3000,"5423 Av. Juarez","56213","Guadalajara","Jalisco","MX");

//        l.deleteLocation(3000, "MX");
        
            //  Creacion del EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction();
        
        //Refrescar Tabla
//        String sql = "{ call DBMS_MVIEW.REFRESH('view_all_employees')}";
//        CallableStatement callstm = con.prepareCall(sql);
//        callstm.executeQuery();
        
//        Query query = em.createNamedQuery("ViewEmployee.findAll");
//        
//        List<ViewEmployee> employees = query.getResultList();        
//        for (ViewEmployee employee : employees) {
//            System.out.println(employee.toString());
//        }
        
          ViewEmployee employee = new ViewEmployee();
          Query queryEmp = em.createNamedQuery("ViewEmployee.findByFirstName").setParameter("firstName", "Jean");
          employee = (ViewEmployee) queryEmp.getSingleResult();
          System.out.println(employee.getLastName());

    }
}
