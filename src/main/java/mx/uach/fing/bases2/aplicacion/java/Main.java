/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.fing.bases2.aplicacion.java;

import GUI.Ventana;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.uach.fing.bases2.aplicacion.java.entities.Employee;

/**
 *
 * @author kryst
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
