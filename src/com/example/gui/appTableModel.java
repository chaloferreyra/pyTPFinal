/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gui;

import com.example.dominio.Aplicaciones;
import com.example.servicios.GestorAplicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gonzalo
 */
public class appTableModel extends AbstractTableModel {

    private GestorAplicaciones gestor = null;  // usar una generalizacion para todos los gestores.
    private static final int COLS = 4;
    private static final String COL_NAMES[] = {"ID", "NOMBRE", "DETALLE", "PRECIO"};
    private final int idUsuario;
    private final boolean propias;
    

    public appTableModel(GestorAplicaciones gestor, int idUsuario, boolean propias) {
        this.gestor = gestor;
        this.idUsuario = idUsuario;
        this.propias = propias;
    }

    @Override
    public int getRowCount() {
            return gestor.listApps(idUsuario,propias,false).size();
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
        List<Aplicaciones> data = gestor.listApps(idUsuario,propias,false);

        Object aux = null;

        if (data != null) {
            if (row < data.size()) {
                Aplicaciones apps = data.get(row);

                switch (col) {
                    case 0:
                        aux = apps.getApp_id();
                        break;
                    case 1:
                        aux = apps.getNombreApp();
                        break;
                    case 2:
                        aux = apps.getDetalleApp();
                        break;
                    case 3:
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

    class EscuchaApp implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
        }
    }
    
    
}
