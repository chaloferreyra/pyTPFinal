/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.hilos;
import com.example.servicios.GestorUsuario;

/**
 *
 * @author Gonzalo
 */
public class EditTipoUser extends Thread{
    private final int idUsuario;
    
    public EditTipoUser(int id){
        this.idUsuario=id;
    }
    
    @Override
    public void run() {
        GestorUsuario gestor= new GestorUsuario();
        
        gestor.editTUser(idUsuario);
            
    }
}
