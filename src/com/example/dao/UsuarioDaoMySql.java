/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Usuario;
import com.example.excepciones.CorreoInvalidoException;
import com.example.excepciones.DaoExcepcion;
import com.example.utils.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class UsuarioDaoMySql implements UsuarioDao {

    @Override
    public boolean create(Usuario u) throws DaoExcepcion {
        String query = "INSERT INTO appstore.usuarios "
                + "(nick_usuario,"
                + " pass_usuario,"
                + " n_usuario, a_usuario,dni_usuario,correo_usuario,img_usuario,id_tipo)"
                + " VALUES (?,?,?,?,?,?,?,1)";
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
                stmt.setString(1, u.getNick_usuario());
                stmt.setString(2, u.getPass_usuario());
                stmt.setString(3, u.getN_usuario());
                stmt.setString(4, u.getA_usuario());
                stmt.setInt(5, u.getDni_usuario());
                stmt.setString(6,u.getCorreo_usuario());
                stmt.setString(7,u.getImg_usuario());
                

                stmt.executeUpdate();
                return true;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getMessage());
            return false;
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
       
    }

    @Override
    public Usuario validate(String n, String p) throws DaoExcepcion {
        Usuario us=null;
        String query = "SELECT * FROM usuarios WHERE nick_usuario= ? AND pass_usuario= ? ";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setString(1, n);
            stmt.setString(2, p);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                us = new Usuario(rs.getInt("usuario_id"), rs.getString("nick_usuario"), rs.getString("pass_usuario"), rs.getString("n_usuario"), rs.getString("a_usuario"), rs.getInt("dni_usuario"), rs.getString("correo_usuario"), rs.getString("img_usuario"), rs.getInt("id_tipo"));
            }
            
            
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        } catch (CorreoInvalidoException ex) {
            Logger.getLogger(UsuarioDaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
        
        return us;
    }

    @Override
    public boolean editUsuario(Usuario u) throws DaoExcepcion {
        String query = "UPDATE usuarios Set nick_usuario = ?, pass_usuario = ?, n_usuario = ?, a_usuario = ?, dni_usuario = ?, correo_usuario = ?, img_usuario = ? WHERE usuario_id= ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
                stmt.setString(1, u.getNick_usuario());
                stmt.setString(2, u.getPass_usuario());
                stmt.setString(3, u.getN_usuario());
                stmt.setString(4, u.getA_usuario());
                stmt.setInt(5, u.getDni_usuario());
                stmt.setString(6,u.getCorreo_usuario());
                stmt.setString(7,u.getImg_usuario());
                stmt.setInt(8, u.getUsuario_id());

                stmt.executeUpdate();
                return true;
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getMessage());
            return false;
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
    }

    @Override
    public boolean validarSiExiste(String n) throws DaoExcepcion {
        
        String query = "SELECT * FROM usuarios WHERE nick_usuario= ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setString(1, n);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next();
            
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
        
    }

    @Override
    public void editTUser(int idUsuario) throws DaoExcepcion {
        String query = "UPDATE usuarios Set id_tipo = 2 where usuario_id = ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
                stmt.setInt(1, idUsuario);
                
                stmt.executeUpdate();
                
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getMessage());
            
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
    }
    
    

}
