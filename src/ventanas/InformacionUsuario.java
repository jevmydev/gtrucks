/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Color;
import javax.swing.WindowConstants;
import clases.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author jeremy
 */
public class InformacionUsuario extends javax.swing.JFrame {

    /**
     * Creates new form InformacionUsuario
     */
    String user_update = GestionarUsuarios.user_update;

    public InformacionUsuario() {
        initComponents();
        this.setTitle("Informacion del Usuario: " + user_update);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(550, 370);

        label_Titulo.setText("Informacion del Usuario " + user_update);

        try {

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select user, tipo_nivel from usuarios where user = '" + user_update + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txt_nombre.setText(rs.getString(1));
                cmb_niveles.setSelectedItem(rs.getString(2));

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al consultar datos, Informacion Usuario: \n " + e);
            JOptionPane.showMessageDialog(null, "Error al consultar datos, Contacte con el Administrador");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cmb_nivel = new javax.swing.JComboBox<>();
        label_Titulo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        cmb_niveles = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Permisos de:");

        cmb_nivel.setBackground(new java.awt.Color(255, 153, 0));
        cmb_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Trabajador", "Usuario" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Titulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label_Titulo.setForeground(new java.awt.Color(255, 153, 0));
        label_Titulo.setText("Informacion del Usuario");
        getContentPane().add(label_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 250, 30));

        cmb_niveles.setBackground(new java.awt.Color(255, 153, 0));
        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Trabajador", "Usuario" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Modificar Usuario");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 160, 35));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Restaurar Password");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 35));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Permisos de:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 10));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setHideActionText(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 160, 90));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("Imprimir Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = txt_nombre.getText();
        String tipo_nivel = cmb_niveles.getSelectedItem().toString();

        if (!nombre.equals("")) {

            try {

                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update usuarios set user = ?, tipo_nivel = ? where user = '" + user_update + "'");

                pst.setString(1, nombre);
                pst.setString(2, tipo_nivel);
                pst.executeUpdate();

                txt_nombre.setBackground(Color.green);
                cmb_niveles.setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "Usuario Modificado Correctamente");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("Error al Modificar Usuario(Informacion Usuario) : \n" + e);
                JOptionPane.showMessageDialog(null, "Error al Modificar Usuario, Contacte con el Administrador");
            }

        } else {
            txt_nombre.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new RestaurarPass().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/desktop/" + user_update + ".pdf"));

            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 14, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Informacion del Usuario " + user_update + " \n \n");

            documento.open();
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(3);

            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Tipo de Nivel");
            
            try {
                
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "select ID, user, tipo_nivel from usuarios where user = '" + user_update + "'");
                
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    
                    do {
                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        
                        
                    } while(rs.next());
                    
                    documento.add(tabla);
                }
                
                cn.close();
                
            } catch (DocumentException | SQLException e) {
                System.err.println("Error al generar PDF Cliente: \n " + e);
                JOptionPane.showMessageDialog(null, "Error al generar PDF Cliente, Contacte con el Administraodr");
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado con Exito, Visita tu Escritorio");
            
        } catch (DocumentException | FileNotFoundException e) {
            System.err.println("Error al generar PDF del Cliente: \n " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_nivel;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_Titulo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
