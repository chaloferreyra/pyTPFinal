/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Categoria;
import com.example.excepciones.DaoExcepcion;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public interface CategoriasDao {
    void create(Categoria a)throws DaoExcepcion;
    List<Categoria> listoCategoria() throws DaoExcepcion;
}
