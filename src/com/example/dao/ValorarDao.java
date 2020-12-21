/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Valoracion;
import com.example.excepciones.DaoExcepcion;

/**
 *
 * @author Gonzalo
 */
public interface ValorarDao {
    void nuevaValoracion(Valoracion v)throws DaoExcepcion;
    float obtenerValoracion(int a) throws DaoExcepcion;
    String obtenerOpinion(int a) throws DaoExcepcion;
}
