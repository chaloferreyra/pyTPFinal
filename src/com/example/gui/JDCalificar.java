/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gui;

import com.example.dominio.Aplicaciones;
import com.example.dominio.Valoracion;
import com.example.servicios.GestorValorar;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo
 */
public class JDCalificar extends javax.swing.JDialog {
    private Aplicaciones app;
    private int user;
    private int estrella;
    private GestorValorar gestor;
    
    /**
     * Creates new form JDCalificar
     * @param parent
     * @param modal
     * @param a
     * @param user
     */
    public JDCalificar(java.awt.Frame parent, boolean modal, Aplicaciones a, int user) {
        super(parent, modal);
        app = a;
        this.user = user;
        initComponents();
        jTAOpinion.setLineWrap(true);
        jTAOpinion.setWrapStyleWord(true);
        jLNomApp.setText(app.getNombreApp());
        gestor = new GestorValorar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTOpinion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jRB2 = new javax.swing.JRadioButton();
        jRB1 = new javax.swing.JRadioButton();
        jRB3 = new javax.swing.JRadioButton();
        jRB4 = new javax.swing.JRadioButton();
        jRB5 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLNomApp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAOpinion = new javax.swing.JTextArea();

        jTOpinion.setEditable(false);
        jTOpinion.setColumns(20);
        jTOpinion.setRows(5);
        jScrollPane2.setViewportView(jTOpinion);

        jLabel5.setText("Opinión");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad de Estrellas"));

        jLabel3.setText("Valora");

        jRB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRB2MouseReleased(evt);
            }
        });

        jRB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRB1MouseReleased(evt);
            }
        });

        jRB3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRB3MouseReleased(evt);
            }
        });

        jRB4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRB4MouseReleased(evt);
            }
        });

        jRB5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRB5MouseReleased(evt);
            }
        });

        jLabel4.setText("1      2      3      4      5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jRB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRB4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel1.setText("Nombre Aplicación: ");

        jLNomApp.setText("NomApp");

        jLabel6.setText("Opinión");

        jButton1.setText("Calificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTAOpinion.setColumns(20);
        jTAOpinion.setRows(5);
        jScrollPane1.setViewportView(jTAOpinion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLNomApp))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLNomApp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRB2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRB2MouseReleased
        jRB5.setSelected(false);
        jRB4.setSelected(false);
        jRB3.setSelected(false);
        jRB2.setSelected(true);
        jRB1.setSelected(true);
        estrella = 1;
    }//GEN-LAST:event_jRB2MouseReleased

    private void jRB1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRB1MouseReleased
        jRB5.setSelected(false);
        jRB4.setSelected(false);
        jRB3.setSelected(false);
        jRB2.setSelected(false);
        jRB1.setSelected(true);
        estrella = 2;
    }//GEN-LAST:event_jRB1MouseReleased

    private void jRB3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRB3MouseReleased
        jRB5.setSelected(false);
        jRB4.setSelected(false);
        jRB3.setSelected(true);
        jRB2.setSelected(true);
        jRB1.setSelected(true);
        estrella = 3;
    }//GEN-LAST:event_jRB3MouseReleased

    private void jRB4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRB4MouseReleased
        jRB5.setSelected(false);
        jRB4.setSelected(true);
        jRB3.setSelected(true);
        jRB2.setSelected(true);
        jRB1.setSelected(true);
        estrella = 4;
    }//GEN-LAST:event_jRB4MouseReleased

    private void jRB5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRB5MouseReleased
        jRB5.setSelected(true);
        jRB4.setSelected(true);
        jRB3.setSelected(true);
        jRB2.setSelected(true);
        jRB1.setSelected(true);
        estrella = 5;
    }//GEN-LAST:event_jRB5MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Valoracion v = new Valoracion(estrella,jTAOpinion.getText(),app.getApp_id(),this.user);
        gestor.crearValoracion(v);
        JOptionPane.showMessageDialog(this, "Gracias por Calificar la App", "Calificacion", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLNomApp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRB1;
    private javax.swing.JRadioButton jRB2;
    private javax.swing.JRadioButton jRB3;
    private javax.swing.JRadioButton jRB4;
    private javax.swing.JRadioButton jRB5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAOpinion;
    private javax.swing.JTextArea jTOpinion;
    // End of variables declaration//GEN-END:variables
}
