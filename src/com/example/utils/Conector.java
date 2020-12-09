/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.utils;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class Conector {

    // Propiedades
    private static Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    // Constructor
    private Conector() {

        url = "jdbc:mysql://localhost:3333/appstore?serverTimezone=UTC";
        driver = "com.mysql.cj.jdbc.Driver"; // com.mysql.jdbc.Driver";
        usuario = "111mil";
        password = "111mil";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver no encontrado");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Fallo al recibir base de datos");
        } catch (Exception ex){
        JOptionPane.showMessageDialog(null, "No hay resultado");
    }
    } // Fin constructor

    // Métodos
    public static Connection getConnection() throws SQLException {

        if (conn == null || conn.isClosed()) {
            new Conector();
        }

        return conn;
    } // Fin getConnection

    public static void cerrarConexion() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
