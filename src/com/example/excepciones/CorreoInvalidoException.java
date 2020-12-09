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
public class CorreoInvalidoException extends Exception{
    public CorreoInvalidoException(String n_usuario) {
        super("Parametro incorrecto <" + n_usuario + "> no es válido!");
    }
}
