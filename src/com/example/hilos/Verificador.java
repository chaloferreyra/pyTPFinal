/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.hilos;

import com.example.servicios.GestorUsuario;
import javax.swing.JLabel;

/**
 *
 * @author Gonzalo
 */
public class Verificador extends Thread{
    
    private final String nick;
    private final JLabel validador;
    
    public Verificador(String nick, JLabel validador) {
        this.nick = nick;
        this.validador = validador;
    }
    
    /**
     * 
     */
    @Override
    public void run() {
        GestorUsuario gestor= new GestorUsuario();
        
        if(gestor.validarNickUsuario(nick))
            validador.setText("El nick YA está usuado");
        else
            validador.setText("El nick NO está utilizado");
    }
}
