/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.excepciones;

/**
 *
 * @author Gonzalo
 */
public class DaoExcepcion extends Exception{
    public DaoExcepcion(String mensaje, Exception e){
        super(mensaje, e);
    } 
}
