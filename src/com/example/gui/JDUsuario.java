/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gui;

import com.example.dominio.Usuario;
import com.example.excepciones.CorreoInvalidoException;
import com.example.excepciones.DaoExcepcion;
import com.example.servicios.GestorUsuario;
import com.example.utils.GestorClaves;
import com.example.utils.GestorDirectorioActual;
import com.example.hilos.Verificador;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gonzalo
 */
public class JDUsuario extends javax.swing.JDialog {

    private GestorUsuario gestor = null;
    private final Usuario user;
    private boolean edit = false;

    /**
     * Creates new form JDUsuario
     *
     * @param parent
     * @param modal
     * @param u
     */

    public JDUsuario(java.awt.Frame parent, boolean modal, Usuario u) {

        super(parent, modal);
        this.user = u;
        initComponents();
        
        if(user!=null){
            setTitle("Edición de Usuario");
            cargarInfoUsuario(user);
            edit = true;
        }else{
            setTitle("Registro de Usuario");
            jBImagen.setEnabled(false);
        }
        this.setLocationRelativeTo(null);
        gestor = new GestorUsuario();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTDni = new javax.swing.JTextField();
        jBAceptar = new javax.swing.JButton();
        jBImagen = new javax.swing.JButton();
        jlImagen = new javax.swing.JLabel();
        jTNick = new javax.swing.JTextField();
        jPClave = new javax.swing.JPasswordField();
        jPClave2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLValidador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTCorreoUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Nombre");

        jLabel5.setText("Apellido");

        jLabel6.setText("DNI");

        jTDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTDniKeyTyped(evt);
            }
        });

        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        jBImagen.setText("Cargar Imagen");
        jBImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImagenActionPerformed(evt);
            }
        });

        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/images/silueta1.jpg"))); // NOI18N

        jTNick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNickFocusLost(evt);
            }
        });

        jLabel1.setText("Contraseña:");

        jLabel9.setText("E-Mail:");

        jLValidador.setText("El nick del usuario no puede repetirse");

        jLabel2.setText("Repita Contraseña:");

        jLabel3.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTNick, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLValidador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPClave2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTCorreoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLValidador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPClave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBImagen))
                .addGap(18, 18, 18)
                .addComponent(jBAceptar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        int valorDni = 0;
        String clave = GestorClaves.comparoClave(jPClave.getPassword(), jPClave2.getPassword());

        if (jTNick.getText().equals("") || clave.equals("")) {
            JOptionPane.showMessageDialog(this, "Usuario o Contraseña Invalida", "Validación", JOptionPane.ERROR_MESSAGE);
        } else {
            if (jTDni.getText().equals("")) {
                valorDni = 0;
            } else {
                try {
                    valorDni = Integer.parseInt(jTDni.getText());
                } catch (NumberFormatException e) {
                    System.err.println("No se puede convertir a numero");
                }
            }
            
            Usuario u = null;
                       
            try {
                if (edit) 
                    u = new Usuario(user.getUsuario_id(),jTNick.getText(), clave, jTNombre.getText(), jTApellido.getText(), valorDni, jTCorreoUsuario.getText(), jlImagen.getText(), 1);
                else
                    u = new Usuario(jTNick.getText(), clave, jTNombre.getText(), jTApellido.getText(), valorDni, jTCorreoUsuario.getText(), jlImagen.getText(), 1);
            
            } catch (CorreoInvalidoException ex) {
                JOptionPane.showMessageDialog(this, "El correo No es valido!", "Validación", JOptionPane.ERROR_MESSAGE);
                jTCorreoUsuario.requestFocus();
            }
            try {
                                
                if (edit) {
                    boolean ok = gestor.editarUsuario(u);
                    if (ok){
                        JOptionPane.showMessageDialog(this, "Se ha Modificado usuario!", "Editar Usuario", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al Modificar un usuario!", "Editar Usuario", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    boolean ok = gestor.crearUsuario(u);
                    if(ok)
                        JOptionPane.showMessageDialog(this, "Se ha creado un usuario!", "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);
                    else{
                        JOptionPane.showMessageDialog(this, "Error al Crear un usuario!", "Nuevo Usuario", JOptionPane.ERROR_MESSAGE);
                    }
                }    
                
                this.dispose();
            } catch (DaoExcepcion ex) {
                JOptionPane.showMessageDialog(this, "El nombre del usuario ya existe", "Validación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBAceptarActionPerformed

    private void jBImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImagenActionPerformed
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("Solo Imagenes","jpg","png", "jpeg");
        file.addChoosableFileFilter(extension);
        int result = file.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
                     
            File archivo = file.getSelectedFile();
            if ((archivo != null) || (archivo.getName().equals(""))) {
//            }else{
                GestorDirectorioActual.checkDirectorioActual(jTNick.getText(), archivo);
                ImageIcon icono = new ImageIcon(archivo.getAbsolutePath());
                //Crear una imagen a escala respecto del JLabel jlImagen:
                Image imagenScala = icono.getImage().getScaledInstance(jlImagen.getWidth(), jlImagen.getHeight(), Image.SCALE_SMOOTH);
                //Asignar imagen ajustada al JLabel
                jlImagen.setIcon(new ImageIcon(imagenScala));

                jlImagen.setText(archivo.getName());
                jlImagen.repaint();
            }
            System.out.println("El archivo seleccionado esta en: " + archivo.getPath() + " y se llama " + archivo.getName());
        }
        
    }//GEN-LAST:event_jBImagenActionPerformed

    private void jTNickFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNickFocusLost
        Verificador v = new Verificador(jTNick.getText(), jLValidador);
        
        if (user == null){
            v.start();
        }else{
            if(!jTNick.getText().equals(user.getNick_usuario()))
                v.start();
        }
        if(!jTNick.getText().equals(""))
            jBImagen.setEnabled(true);
    }//GEN-LAST:event_jTNickFocusLost

    private void jTDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDniKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_jTDniKeyTyped

    private void cargarInfoUsuario(Usuario u) {
    
        jTNick.setText(u.getNick_usuario());
        
        jTCorreoUsuario.setText(u.getCorreo_usuario());
        
        jTNombre.setText(u.getN_usuario());
        jTApellido.setText(u.getA_usuario());
        jTDni.setText(String.valueOf(u.getDni_usuario()));
        
        
        Path pathImg = Paths.get(u.getNick_usuario() + "/" + u.getImg_usuario());

        if (Files.exists(pathImg)) {
            ImageIcon imagen = new ImageIcon(pathImg.toAbsolutePath().toString());
            Image imagenScala = imagen.getImage().getScaledInstance(jlImagen.getWidth(), jlImagen.getHeight(), Image.SCALE_SMOOTH);
            jlImagen.setIcon(new ImageIcon(imagenScala));
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBImagen;
    private javax.swing.JLabel jLValidador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPasswordField jPClave;
    private javax.swing.JPasswordField jPClave2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTCorreoUsuario;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTNick;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JLabel jlImagen;
    // End of variables declaration//GEN-END:variables
}
