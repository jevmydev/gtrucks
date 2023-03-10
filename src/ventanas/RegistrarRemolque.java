/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Color;
import javax.swing.WindowConstants;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author jeremy
 */
public class RegistrarRemolque extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarRemolque
     */
    String user = Login.user;
    
    public RegistrarRemolque() {
        initComponents();

        this.setTitle("Registro de Remolques - Sesion de " + user);
        this.setSize(300, 410);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        cmb_tipoRemolque = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_productos = new javax.swing.JTextField();
        boton_registrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Tipo Remolque:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cmb_tipoRemolque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Remolque de enganche", "Remolque con eje central", "Semirremolque" }));
        getContentPane().add(cmb_tipoRemolque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 28));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Productos:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        txt_productos.setBackground(new java.awt.Color(255, 153, 0));
        txt_productos.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        txt_productos.setForeground(new java.awt.Color(255, 255, 255));
        txt_productos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_productos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 30));

        boton_registrar.setBackground(new java.awt.Color(255, 153, 0));
        boton_registrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        boton_registrar.setText("Registrar");
        boton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 230, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Registrar Remolque");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registrarActionPerformed


        String productos = txt_productos.getText();
        String tipo_remolque = cmb_tipoRemolque.getSelectedItem().toString();

        if (!productos.equals("")) {

            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into camiones values(?,?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setString(2, "No Asignado");
                pst.setString(3, "No Asignado");
                pst.setString(4, "No Asignado");
                pst.setString(5, "No Asignado");
                pst.setString(6, productos);
                pst.setString(7, tipo_remolque);
                pst.setString(8, "Disponible");
                pst.executeUpdate();

                txt_productos.setBackground(Color.green);
                cmb_tipoRemolque.setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "Remolque Registrado con Exito");

                this.dispose();
            } catch (SQLException e) {
                System.err.println("Error al registrar viaje con camion: \n" + e);
                JOptionPane.showMessageDialog(null, "Error al registrar viaje, Contacte con el Administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_boton_registrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarRemolque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarRemolque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarRemolque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarRemolque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarRemolque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_registrar;
    private javax.swing.JComboBox<String> cmb_tipoRemolque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_productos;
    // End of variables declaration//GEN-END:variables
}
