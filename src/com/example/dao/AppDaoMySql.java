/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Aplicaciones;
import com.example.excepciones.DaoExcepcion;
import com.example.utils.Conector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class AppDaoMySql implements AplicacionesDao{

    @Override
    public void create(Aplicaciones a) throws DaoExcepcion {
        String query = "INSERT INTO appstore.aplicacion (nombre,detalle,precio,fechaAlta,idCategoria,idUsuario,imgapp,img) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
//            System.out.println("La imagen esta en: " + a.getImagen());
//            System.out.println(a.getIdCategoria());
            stmt.setString(1, a.getNombreApp());
            stmt.setString(2, a.getDetalleApp());
            stmt.setFloat(3, a.getPrecioApp());            
            stmt.setDate(4, new Date(a.getFechaAltaApp().getTime()));
            stmt.setInt(5, a.getIdCategoria());
            stmt.setInt(6, a.getIdUsuario());
            
            InputStream inputStream = new FileInputStream(new File(a.getImgApp()));
            stmt.setBlob(7, inputStream);

            stmt.executeUpdate();
            

        } catch (SQLException ex) {
            throw new DaoExcepcion("Error de acceso a datos!", ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppDaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Conector.cerrarConexion();
            } catch (SQLException ex) {
                throw new DaoExcepcion("No se cerro correctamente la conexión!", ex);
            }
        }
    }

    @Override
    public List<Aplicaciones> listoAplicaciones(int idUsuario) throws DaoExcepcion {
        List<Aplicaciones> aux= new ArrayList<>();
        String query = "SELECT * FROM aplicacion where idUsuario <> ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones apps = null;
            
            while (rs.next()) {
               // apps = new Aplicaciones(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9));
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
    public List<Aplicaciones> listoAppUsuario(int usuario) throws DaoExcepcion {
        List<Aplicaciones> aux= new ArrayList<>();
        String query = "SELECT * FROM aplicacion where idUsuario = ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones apps = null;
            
            while (rs.next()) {
                apps = new Aplicaciones(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));                
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
    public List<Aplicaciones> listoAppFiltro(int idUsuario, String buscar) throws DaoExcepcion {
        List<Aplicaciones> aux= new ArrayList<>();
        String query = "SELECT * FROM aplicacion where idUsuario <> ? AND nombre LIKE ?";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            
            stmt.setInt(1, idUsuario);
            stmt.setString(2, buscar);
            ResultSet rs = stmt.executeQuery();
            
            Aplicaciones apps = null;
            
            while (rs.next()) {
              //  apps = new Aplicaciones(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getDate(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9));
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
    
}
