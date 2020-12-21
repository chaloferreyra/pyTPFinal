/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.dao.DaoFactory;
import com.example.dao.ValorarDao;
import com.example.dominio.Valoracion;
import com.example.excepciones.DaoExcepcion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class GestorValorar {
    ValorarDao dao;
    
    public GestorValorar() {
        this.dao = DaoFactory.getValoracion();
    }
    
    public void crearValoracion(Valoracion v){
        try{
            dao.nuevaValoracion(v);
        }catch (DaoExcepcion ex){
            throw new RuntimeException(ex);
        }
    }
    
    public float getValoracion(int a){
        float valor = 0.0f;
        try {
            valor = dao.obtenerValoracion(a);
            System.out.println("Valor de promedio: " + valor);
        } catch (DaoExcepcion ex) {
            Logger.getLogger(GestorValorar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
    public String getOpinion(int a){
        String valor = "";
        try {
            valor = dao.obtenerOpinion(a);
            System.out.println("Valor de promedio: " + valor);
        } catch (DaoExcepcion ex) {
            Logger.getLogger(GestorValorar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
    
}
