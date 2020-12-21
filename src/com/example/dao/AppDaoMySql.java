/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Aplicaciones;
import com.example.excepciones.DaoExcepcion;
import com.example.utils.Conector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class AppDaoMySql implements AplicacionesDao{

    @Override
    public void create(Aplicaciones a) throws DaoExcepcion {
        
        int idApp = 0;
        String query = "INSERT INTO appstore.aplicacion (nombre,detalle,precio,fechaAlta,idCategoria,idUsuario,nomImg) VALUES (?,?,?,?,?,?,?)";
        
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, a.getNombreApp());
            stmt.setString(2, a.getDetalleApp());
            stmt.setFloat(3, a.getPrecioApp());            
            stmt.setDate(4, new Date(a.getFechaAltaApp().getTime()));
            stmt.setInt(5, a.getIdCategoria());
            stmt.setInt(6, a.getIdUsuario());
            stmt.setString(7, a.getImagen());
                        
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                     idApp = rs.getInt(1);
            }
   
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }
        
        query = "INSERT INTO appstore.appuser (idUsuario,idApp,propia) VALUES (?,?,?)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
        
            stmt.setInt(1,a.getIdUsuario());
            stmt.setInt(2,idApp);
            stmt.setBoolean(3,true);

            stmt.executeUpdate();
        
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }
        finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
    }

    @Override
    public List<Aplicaciones> listoAplicaciones(int idUsuario, boolean publicada, boolean propia) throws DaoExcepcion {
        List<Aplicaciones> aux= new ArrayList<>();
        String query;
        if (publicada)
            query = "SELECT * FROM appstore.aplicacion WHERE aplicacion_id in (select idApp from appuser where idUsuario <> ? and propia = ?)";  // not in( select idapp from appuser where propia = 1 <-- el valor por parametro que ya tengo
        else
            query = "SELECT * FROM appstore.aplicacion WHERE aplicacion_id in (select idApp from appuser where idUsuario = ? and propia = ?)";
            
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            
            stmt.setInt(1, idUsuario);
            stmt.setBoolean(2, propia);
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones apps = null;
            
             
            while (rs.next()) {
                
                apps = new Aplicaciones(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),rs.getString(9));
                aux.add(apps);
            }
            
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
        return aux;
    }

      
    @Override
    public Aplicaciones buscarById(int idApp) throws DaoExcepcion {
        
        String query = "SELECT * FROM aplicacion WHERE aplicacion_id = ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setInt(1, idApp);
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones app = null;
            System.out.println("En nombre es:" + rs.getString(2));
            
            return app = new Aplicaciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6),rs.getInt(7),rs.getString(9));                  
            
            
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
    public boolean comprarApp(int idApp, int usuario_id) throws DaoExcepcion {
        String query = "INSERT INTO appstore.appuser (idUsuario,idApp,propia) VALUES (?,?,?)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
        
            stmt.setInt(1,usuario_id);
            stmt.setInt(2,idApp);
            stmt.setBoolean(3,false);

            return stmt.executeUpdate()>0;
            
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }
        finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
    }

    @Override
    public List<Aplicaciones> listoAppCompradas(int usuario) throws DaoExcepcion {
        List<Aplicaciones> aux= new ArrayList<>();
        String query = "SELECT * FROM aplicacion where aplicacion_id in (select idApp from appuser where idUsuario = ? and propia = false)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setInt(1, usuario);
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones apps = null;
            
            while (rs.next()) {
                apps = new Aplicaciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6),rs.getInt(7),rs.getString(9));                
                aux.add(apps);
            }
            
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
        return aux;
        
    }

    @Override
    public List<Aplicaciones> buscarByParam(int idUsuario, String cadena) throws DaoExcepcion {
        List<Aplicaciones> aux= new ArrayList<>();
        String query = "SELECT * FROM aplicacion WHERE nombre LIKE ? AND aplicacion_id IN (SELECT idApp FROM appuser WHERE idUsuario <> ? AND propia = true)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setString(1,cadena);
            stmt.setInt(2, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones apps = null;
            
            while (rs.next()) {
                apps = new Aplicaciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6),rs.getInt(7),rs.getString(9));                
                aux.add(apps);
            }
            
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
        return aux;
    }

    @Override
    public void editApp(Aplicaciones a) throws DaoExcepcion {
       
        String query = "UPDATE appstore.aplicacion SET nombre = ?, detalle = ?, precio = ?, fechaAlta = ?, idCategoria = ?, nomImg  = ? WHERE aplicacion_id = ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {

            stmt.setString(1, a.getNombreApp());
            stmt.setString(2, a.getDetalleApp());
            stmt.setFloat(3, a.getPrecioApp());            
            stmt.setDate(4, new Date(a.getFechaAltaApp().getTime()));
            stmt.setInt(5, a.getIdCategoria());
            stmt.setString(6, a.getImagen());
            stmt.setInt(7, a.getApp_id());
                        
            stmt.executeUpdate();
          
   
        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        }
        
        finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
        
    }
    
}
