/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificadores;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author eopg9
 */
public class VerificadorString extends InputVerifier{
    
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText().trim();
        if (text.isEmpty()){
            JOptionPane.showMessageDialog(input,"Ningun campo puede estar vacio");
            return false;
        }
        
        //if (text.matches(".*\\d.*")) return false;

        return true;
    }
    
}