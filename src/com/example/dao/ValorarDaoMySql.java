/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Aplicaciones;
import com.example.dominio.Valoracion;
import com.example.excepciones.DaoExcepcion;
import com.example.utils.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gonzalo
 */
public class ValorarDaoMySql implements ValorarDao{

    @Override
    public void nuevaValoracion(Valoracion v) throws DaoExcepcion {
        String query = "INSERT INTO appstore.calificacion (puntaje,opinion,idAplicacion,idUsuario) VALUES (?,?,?,?)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
        
            stmt.setInt(1,v.getPuntaje());
            stmt.setString(2,v.getOpinion());
            stmt.setInt(3,v.getAppId());
            stmt.setInt(4,v.getUserId());

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
    public float obtenerValoracion(int a) throws DaoExcepcion {
        String query = "SELECT sum(puntaje), count(calificacion_id) FROM calificacion WHERE idAplicacion = ?";
        float calif = 0.0f;
        
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setInt(1, a);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                int suma = rs.getInt(1);
                int cant = rs.getInt(2);
                System.out.println("suma: " + suma);
                System.out.println("cant: " + cant);
                if (suma>0)
                    calif = suma/cant;

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
       return calif;
    }

    @Override
    public String obtenerOpinion(int a) throws DaoExcepcion {
        String query = "SELECT opinion FROM calificacion WHERE idAplicacion = ? order by opinion desc limit 1";
        String op="";
        
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setInt(1, a);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                op = rs.getString(1);
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
       return op;
    }
    
    
}
