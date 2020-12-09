/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Usuario;
import com.example.excepciones.DaoExcepcion;

/**
 *
 * @author Gonzalo
 */
public interface UsuarioDao {
    boolean create(Usuario u)throws DaoExcepcion;
    boolean editUsuario(Usuario u)throws DaoExcepcion;
    Usuario validate(String n, String p) throws DaoExcepcion;
    boolean validarSiExiste(String n) throws DaoExcepcion;
    void editTUser(int idUsuario)throws DaoExcepcion;
}
