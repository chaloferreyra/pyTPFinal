/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.dominio.Categoria;
import com.example.excepciones.DaoExcepcion;
import com.example.utils.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gonzalo
 */
public class CategoriaDaoMySql implements CategoriasDao{

    @Override
    public void create(Categoria a) throws DaoExcepcion {
        String query = "INSERT INTO appstore.Categoria (n_categoria,descripcion) VALUES (?,?)";
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            stmt.setString(1, a.getN_categoria());
            stmt.setString(2, a.getDescripcion());

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
    public List<Categoria> listoCategoria() throws DaoExcepcion {
        List<Categoria> aux= new ArrayList<>();
        String query = "SELECT * FROM categoria";
        
        
        try (Connection cnn = Conector.getConnection(); PreparedStatement stmt = cnn.prepareStatement(query)) {
            
            ResultSet rs = stmt.executeQuery();

            Categoria cat = null;
            
            while (rs.next()) {
                cat = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
                aux.add(cat);
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
