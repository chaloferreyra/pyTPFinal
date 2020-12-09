/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.utils;

import java.util.Arrays;

/**
 *
 * @author Gonzalo
 */
public class GestorClaves {
    private String clave;
    private String clave1;
    
    public static String comparoClave(char[] clave, char[] clave1){
        String pass="";
        String password = String.valueOf(clave);
        String password1 = String.valueOf(clave1);
        
        if(password.equals(password1)){
            pass = password;
        }
        return pass;
    }
    
    public static String convertirClave(char[] clave){
        return String.valueOf(clave);
    }
}
