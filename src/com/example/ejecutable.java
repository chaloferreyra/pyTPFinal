/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.gui.JFlogin;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

/**
 *
 * @author Gonzalo
 */
public class ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
                UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        new JFlogin().setVisible(true);
        
    }
    
}
