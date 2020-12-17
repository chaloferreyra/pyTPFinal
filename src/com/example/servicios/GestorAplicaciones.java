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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class GestorAplicaciones {

    AplicacionesDao dao;

    public GestorAplicaciones() {
        this.dao = DaoFactory.getAppDao();
    }

    public boolean crearAplicacion(Aplicaciones app) {
        boolean in = false;
        try {
            dao.create(app);
            in = true;
        } catch (DaoExcepcion ex) {
            throw new RuntimeException(ex);
        }
        return in;
    }

    public List<Aplicaciones> listApps(int idUsuario, boolean publicada, boolean comprada) {
        List<Aplicaciones> aux = null;
        try {
            aux = dao.listoAplicaciones(idUsuario, publicada, comprada);
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
        }
        return aux;
    }
    
    public List<Aplicaciones> listAppsC(int idUsuario) {
        List<Aplicaciones> aux = null;
        try {
            aux = dao.listoAppCompradas(idUsuario);
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
        }
        return aux;
    }

    public Aplicaciones appById(int idApp) {
        
        try {
            return dao.buscarById(idApp);
        } catch (DaoExcepcion ex) {
            Logger.getLogger(GestorAplicaciones.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public boolean comprarApps(int idApp, int usuario_id){
        try {
            return dao.comprarApp(idApp, usuario_id);
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
            return false;
        }
    }
    
    public List<Aplicaciones> listAppsByparam(int idUsuario, String cadena) {
        try {
            cadena = cadena + "%";
            return dao.buscarByParam(idUsuario, cadena);
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
        }
        return null;
    }
    
    
    public boolean editAplicacion(Aplicaciones app) {
        boolean in = false;
        try {
            dao.editApp(app);
            in = true;
        } catch (DaoExcepcion ex) {
            throw new RuntimeException(ex);
        }
        return in;
    }
    
}
