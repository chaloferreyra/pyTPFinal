/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servicios;

import com.example.dao.CategoriasDao;
import com.example.dao.DaoFactory;
import com.example.dominio.Categoria;
import com.example.excepciones.DaoExcepcion;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class GestorCategorias {
    CategoriasDao dao;
    
    public  GestorCategorias(){
        this.dao = DaoFactory.getCategoriaDao();
    }
    
    public boolean crearAplicacion(Categoria cat){
        boolean in=false;
        try {
            dao.create(cat);
            in=true;
        } catch (DaoExcepcion ex) {
            throw new RuntimeException(ex);
        }
        return in;
    }
    
    public List<Categoria> listaCat(){
        List<Categoria> aux = null;
        try{
        aux = dao.listoCategoria();
        } catch (DaoExcepcion e) {
            System.out.println("ERROR: " + e.toString());
        }
        return aux;
    }
}

