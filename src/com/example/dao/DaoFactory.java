/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

/**
 *
 * @author Gonzalo
 */
public class DaoFactory {
    public static UsuarioDao getUsuarioDao() {
        return new UsuarioDaoMySql();
    }
    public static AplicacionesDao getAppDao(){
        return new AppDaoMySql();
    }
    public static CategoriasDao getCategoriaDao(){
        return new CategoriaDaoMySql();
    }  
    public static ImagenDao getImagenDao(){
        return new ImagenDaoMySql();
    }
}
