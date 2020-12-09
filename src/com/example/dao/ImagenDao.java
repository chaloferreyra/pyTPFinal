/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;


import com.example.excepciones.DaoExcepcion;
import java.io.File;

/**
 *
 * @author Gonzalo
 */
public interface ImagenDao {
    int createImg(File img)throws DaoExcepcion;
    int editImg(File img)throws DaoExcepcion;
}
