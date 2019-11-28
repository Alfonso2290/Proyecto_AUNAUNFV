
package InterfaceCampaña;

import BEAN.CampañaBEAN;
import DAO.CampañaDAO;
import Principal.VentanaProcesos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaCampaña extends javax.swing.JFrame {

    public VentanaCampaña() {
        initComponents();
        setLocationRelativeTo(null);
        
        Inicio();
    }
    
    public void Inicio(){
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 18);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteMensaje=new Font("Decker",Font.PLAIN,12);
        
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        lamina.setBackground(Color.LIGHT_GRAY.brighter());
        
        lbl1.setFont(fuenteMensaje);
        lbl1.setForeground(ColorFuente);
        lbl2.setFont(fuenteMensaje);
        lbl2.setForeground(ColorFuente);
        
        txt1.setFont(fuenteCampos);
        txt2.setFont(fuenteCampos);
        
        btnGuardar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnGuardar));
        btnGuardar.setFont(fuenteCamposLabel);
        btnGuardar.setBackground(null);
        btnGuardar.setForeground(ColorFuente);
        
        btnAtras.setIcon(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        
    }
    
    private class ColorBotones extends MouseAdapter
    {
        private Color colorFondo,colorLetra;
        private JButton boton;
        
        public ColorBotones(Color colorFondo,Color colorLetra,JButton boton)
        {
            this.colorFondo=colorFondo;
            this.colorLetra=colorLetra;
            this.boton=boton;
        }
        
        @Override
        public void mouseEntered(MouseEvent e)
        {
            this.boton.setBackground(colorFondo);
            this.boton.setForeground(colorLetra);
        }
        
        @Override
        public void mouseExited(MouseEvent e)
        {
            this.boton.setBackground(null);
            this.boton.setForeground(colorFondo);
            
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lamina = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt2 = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setText("CREAR CAMPAÑA");

        lbl1.setText("Nombre Campaña");

        lbl2.setText("Descripcón Campaña");

        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        txt2.setColumns(20);
        txt2.setRows(5);
        jScrollPane1.setViewportView(txt2);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout laminaLayout = new javax.swing.GroupLayout(lamina);
        lamina.setLayout(laminaLayout);
        laminaLayout.setHorizontalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laminaLayout.createSequentialGroup()
                .addGroup(laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laminaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl1)
                            .addComponent(lbl2)
                            .addComponent(txt1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                    .addGroup(laminaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laminaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(laminaLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(titulo)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        laminaLayout.setVerticalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laminaLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(31, 31, 31)
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lamina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lamina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txt1.getText().length()==0)
        {
            
            JOptionPane.showMessageDialog(null, "Ud. debe llenar el campo Nombre de Campaña");
            txt1.requestFocus();
            
        }else if(txt2.getText().length()==0){
            
            JOptionPane.showMessageDialog(null, "Ud. debe llenar el campo Descripción de Campaña");
            txt2.requestFocus();
            
        }else{
            
            CampañaDAO dao=new CampañaDAO();
            CampañaBEAN obj=new CampañaBEAN();
            obj.setNombre(txt1.getText());
            obj.setDescripcion(txt2.getText());
            dao.insertarCampaña(obj);
            
            dispose();
            VentanaSeleccionTablas v=new VentanaSeleccionTablas(obj.getNombre());
            v.setVisible(true);
            v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
        VentanaProcesos ventana=new VentanaProcesos();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCampaña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCampaña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCampaña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCampaña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCampaña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lamina;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextArea txt2;
    // End of variables declaration//GEN-END:variables
}
