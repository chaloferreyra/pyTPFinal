/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gui;

import com.example.dominio.Aplicaciones;
import com.example.servicios.GestorAplicaciones;
import com.example.utils.Imagen;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gonzalo
 */
public class appTableModel extends AbstractTableModel {

    private GestorAplicaciones gestor = null;  // usar una generalizacion para todos los gestores.
    private static final int COLS = 3;
    private static final String COL_NAMES[] = {"Imagen", "Detalle", "Precio"};
    private final int idUsuario;
    private String buscar;

    public appTableModel(GestorAplicaciones gestor, int idUsuario) {
        this.gestor = gestor;
        this.idUsuario = idUsuario;
        this.buscar = "";
    }
    
    public appTableModel(GestorAplicaciones gestor, int idUsuario, String buscar) {
        this.gestor = gestor;
        this.idUsuario = idUsuario;
        this.buscar = buscar;
    }
    

    @Override
    public int getRowCount() {
        
        if (buscar.equals(""))
            return gestor.listApps(idUsuario).size();
        else
            return gestor.listAppsFiltro(idUsuario,buscar+"%").size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int i) {
        return COL_NAMES[i];
    }

    @Override
    public Object getValueAt(int row, int col) {
        List<Aplicaciones> data = gestor.listApps(idUsuario);
        StringBuilder detalleApp = new StringBuilder(); 
        
        Object aux = null;
        if (data != null) {
            if (row < data.size()) {
                Aplicaciones apps = data.get(row);

                switch (col) {
                    case 0:
                        aux = "";
                        break;
                    case 1:
                        detalleApp.append(apps.getNombreApp());
                        detalleApp.append("\n");
                        detalleApp.append(apps.getDetalleApp());
                        detalleApp.append("\n");
                        detalleApp.append(apps.getFechaAltaApp());
                        aux = detalleApp;
                        break;
                    case 2:
                        aux = apps.getPrecioApp();
                        break;

                    default:
                        aux = null;
                }

            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
}
