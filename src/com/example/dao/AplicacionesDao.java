/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Aplicaciones;
import com.example.excepciones.DaoExcepcion;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public interface AplicacionesDao {
    void create(Aplicaciones a)throws DaoExcepcion;
    List<Aplicaciones> listoAplicaciones(int usuario, boolean publicada, boolean propia) throws DaoExcepcion;
    List<Aplicaciones> listoAppCompradas(int usuario) throws DaoExcepcion;
    Aplicaciones buscarById(int idApp)throws DaoExcepcion;
    boolean comprarApp(int idApp, int usuario_id)throws DaoExcepcion;
    List<Aplicaciones> buscarByParam(int idUsuario, String cadena) throws DaoExcepcion;
    void editApp(Aplicaciones a)throws DaoExcepcion;
}
