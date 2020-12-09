/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.dao.AplicacionesDao;
import com.example.dao.DaoFactory;
import com.example.dominio.Aplicaciones;
import com.example.excepciones.DaoExcepcion;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class GestorAplicaciones {
    AplicacionesDao dao;
    
    public  GestorAplicaciones(){
        this.dao = DaoFactory.getAppDao();
    }
    
    public boolean crearAplicacion(Aplicaciones app){
        boolean in=false;
        try {
            dao.create(app);
            in=true;
        } catch (DaoExcepcion ex) {
            throw new RuntimeException(ex);
        }
        return in;
    }
    
    public List<Aplicaciones> listApps(int idUsuario){
        List<Aplicaciones> aux = null;
        try{
        aux = dao.listoAplicaciones(idUsuario);
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
        }
        return aux;
    }
    
    public List<Aplicaciones> listAppsFiltro(int idUsuario, String buscar){
        List<Aplicaciones> aux = null;
        try{
        aux = dao.listoAppFiltro(idUsuario,buscar);
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
        }
        return aux;
    }
}
