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
    List<Aplicaciones> listoAplicaciones(int usuario) throws DaoExcepcion;
    List<Aplicaciones> listoAppFiltro(int usuario, String buscar) throws DaoExcepcion;
    List<Aplicaciones> listoAppUsuario(int usuario) throws DaoExcepcion;
}
