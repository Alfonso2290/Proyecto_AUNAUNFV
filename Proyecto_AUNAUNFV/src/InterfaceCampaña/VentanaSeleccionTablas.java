
package InterfaceCampaña;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.DefaultListModel;
import javax.swing.*;
import java.util.*;

public class VentanaSeleccionTablas extends javax.swing.JFrame {
    
    DefaultListModel modeloLista,modeloLista3,modeloLista4,modeloLista5;
    ArrayList<String> listaTablas,listaCampos;
    String nombreCampaña;
    
    
    public VentanaSeleccionTablas(String nombreCampaña) {
        this.nombreCampaña=nombreCampaña;
        initComponents();
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
        
        lista1.setSize(50,100);
        lista2.setSize(50,100);
        lista3.setSize(50,100);
        lista4.setSize(50,100);
        modeloLista=new DefaultListModel();
        
        listaCampos=new ArrayList<>();
        
        lista2.setModel(modeloLista);
        laminaCampos.setVisible(false);
        
        modeloLista3=new DefaultListModel();
        lista3.setModel(modeloLista3);
        
        modeloLista4=new DefaultListModel();
        lista4.setModel(modeloLista4);
        
        modeloLista5=new DefaultListModel();
        lista5.setModel(modeloLista5);
    }
    
    private void Inicio(){
        
        Color ColorFuente=new Color(232,44,8);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 10);
        Font fuenteMensaje=new Font("Decker",Font.PLAIN,12);
        
        tit1.setFont(fuenteTitulo);
        tit1.setForeground(ColorFuente);
        
        tit1.setFont(fuenteTitulo);
        tit1.setForeground(ColorFuente);
        
        tit2.setFont(fuenteTitulo);
        tit2.setForeground(ColorFuente);
        
        lamina1.setBackground(Color.LIGHT_GRAY.brighter());
        laminaCampos.setBackground(Color.LIGHT_GRAY.brighter());
        
        btnAgregar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAgregar));
        btnAgregar.setFont(fuenteCamposLabel);
        btnAgregar.setBackground(null);
        btnAgregar.setForeground(ColorFuente);
        
        btnAgregar1.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAgregar1));
        btnAgregar1.setFont(fuenteCamposLabel);
        btnAgregar1.setBackground(null);
        btnAgregar1.setForeground(ColorFuente);
        
        btnQuitar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnQuitar));
        btnQuitar.setFont(fuenteCamposLabel);
        btnQuitar.setBackground(null);
        btnQuitar.setForeground(ColorFuente);
        
        btnQuitar1.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnQuitar1));
        btnQuitar1.setFont(fuenteCamposLabel);
        btnQuitar1.setBackground(null);
        btnQuitar1.setForeground(ColorFuente);
        
        btnConfirmar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnConfirmar));
        btnConfirmar.setFont(fuenteCamposLabel);
        btnConfirmar.setBackground(null);
        btnConfirmar.setForeground(ColorFuente);
        
        btnConfirmar1.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnConfirmar1));
        btnConfirmar1.setFont(fuenteCamposLabel);
        btnConfirmar1.setBackground(null);
        btnConfirmar1.setForeground(ColorFuente);
        
        btnAtras.setIcon(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        
        
        lbl1.setFont(fuenteMensaje);
        lbl1.setForeground(ColorFuente);
        lbl2.setFont(fuenteMensaje);
        lbl2.setForeground(ColorFuente);
        lbl3.setFont(fuenteMensaje);
        lbl3.setForeground(ColorFuente);
        lbl4.setFont(fuenteMensaje);
        lbl4.setForeground(ColorFuente);
        lbl5.setFont(fuenteMensaje);
        lbl5.setForeground(ColorFuente);
        
        
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

        lamina1 = new javax.swing.JPanel();
        tit1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista1 = new javax.swing.JList<>();
        lbl1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista2 = new javax.swing.JList<>();
        lbl2 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        laminaCampos = new javax.swing.JPanel();
        tit2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lista3 = new javax.swing.JList<>();
        btnAgregar1 = new javax.swing.JButton();
        btnQuitar1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lista5 = new javax.swing.JList<>();
        btnConfirmar1 = new javax.swing.JButton();
        lbl4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lista4 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tit1.setText("SELECCIÓN DE TABLAS");

        lista1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "CLIENTE", "VENTA", "DETALLE_VENTA", "PRODUCTO" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lista1);

        lbl1.setText("TABLAS");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(lista2);

        lbl2.setText("TABLAS SELECCIONADAS");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lamina1Layout = new javax.swing.GroupLayout(lamina1);
        lamina1.setLayout(lamina1Layout);
        lamina1Layout.setHorizontalGroup(
            lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lamina1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(lamina1Layout.createSequentialGroup()
                        .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lamina1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(lbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(lamina1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl2))))
                .addGap(193, 193, 193))
            .addGroup(lamina1Layout.createSequentialGroup()
                .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lamina1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(tit1))
                    .addGroup(lamina1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lamina1Layout.setVerticalGroup(
            lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lamina1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tit1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl1))
                .addGap(18, 18, 18)
                .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lamina1Layout.createSequentialGroup()
                        .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lamina1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar)
                        .addGap(110, 110, 110)))
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tit2.setText("SELECCIÓN DE CAMPOS");

        lbl3.setText("TABLAS");

        lbl5.setText("CAMPOS SELECCIONADOS");

        lista3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista3ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lista3);

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnQuitar1.setText("Quitar");
        btnQuitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar1ActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(lista5);

        btnConfirmar1.setText("Confirmar");
        btnConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar1ActionPerformed(evt);
            }
        });

        lbl4.setText("CAMPOS");

        jScrollPane6.setViewportView(lista4);

        javax.swing.GroupLayout laminaCamposLayout = new javax.swing.GroupLayout(laminaCampos);
        laminaCampos.setLayout(laminaCamposLayout);
        laminaCamposLayout.setHorizontalGroup(
            laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laminaCamposLayout.createSequentialGroup()
                .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laminaCamposLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lbl3)
                        .addGap(99, 99, 99)
                        .addComponent(lbl4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(laminaCamposLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(laminaCamposLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(laminaCamposLayout.createSequentialGroup()
                                        .addComponent(tit2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(laminaCamposLayout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 27, Short.MAX_VALUE)
                                        .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnQuitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl5)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(21, 21, 21))
        );
        laminaCamposLayout.setVerticalGroup(
            laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laminaCamposLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tit2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl4)
                        .addComponent(lbl3)))
                .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(laminaCamposLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(laminaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(laminaCamposLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar1)
                        .addGap(119, 119, 119)))
                .addComponent(btnConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lamina1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laminaCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lamina1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(laminaCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String op=lista1.getSelectedValue();
        if(lista1.getSelectedIndex()>=0){
            if(!verificarRepeticion(op))
            {
                if(verificarOrdenTablas(op, modeloLista))
                    modeloLista.addElement(op);
                else
                    JOptionPane.showMessageDialog(null, "El Orden para Agregar Tablas y unirlas es: \n" + 
                                                        "'CLIENTE-VENTA-DETALLE_VENTA-PRODUCTO'\n" +
                                                        "Puede agregar de 1 a 4 tablas siguiendo esa secuencia");
            }
                
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    public boolean verificarRepeticion(String op){
        boolean b=false;
        for(int i=0;i<modeloLista.getSize();i++){
            
            if(modeloLista.getElementAt(i).equals(op))
                b=true;
        }
        
        return b;
        
    }
    
    public boolean verificarOrdenTablas(String op,DefaultListModel modelo){
        boolean b=false;
        
        if(op.equals("CLIENTE")){
            b=true;
        }
        
        for(int i=0;i<modelo.getSize();i++){
            
            if((modelo.getElementAt(i).equals("CLIENTE")) && op.equals("VENTA")){
                b=true;
            }
            if((modelo.getElementAt(i).equals("VENTA")) && op.equals("DETALLE_VENTA")){
                b=true;
            }
            
            if((modelo.getElementAt(i).equals("DETALLE_VENTA")) && op.equals("PRODUCTO")){
                b=true;
            }
            
        }
        
        return b;
        
    }
    
    public boolean verificarOrdenTablasQuitar(String op,DefaultListModel modelo){
        boolean b=false;
        
        
        for(int i=0;i<modelo.getSize();i++){
            
            if((modelo.getElementAt(i).equals("PRODUCTO") && op.equals("DETALLE_VENTA") )){
                b=true;
            }
            if(((modelo.getElementAt(i).equals("PRODUCTO")) || (modelo.getElementAt(i).equals("DETALLE_VENTA"))) && op.equals("VENTA")){
                b=true;
            }
            
            if(((modelo.getElementAt(i).equals("PRODUCTO")) || (modelo.getElementAt(i).equals("DETALLE_VENTA")) || (modelo.getElementAt(i).equals("VENTA")) ) && op.equals("CLIENTE")){
                b=true;
            }
            
        }
        
        return b;
        
    }
    
    
    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        
        if(lista2.getSelectedIndex()>=0){
            int pos=lista2.getSelectedIndex();
            String op=modeloLista.getElementAt(pos).toString();
            if(!verificarOrdenTablasQuitar(op, modeloLista))            
                modeloLista.remove(pos);
            else
                JOptionPane.showMessageDialog(null, "El Orden para Quitar Tablas y unirlas es: \n" + 
                                                    "'PRODUCTO-DETALLE_VENTA-VENTA-CLIENTE'\n" +
                                                    "Puede quitar de 1 a 4 tablas siguiendo esa secuencia");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    public void llenarListaTablas(){
        
        listaTablas=new ArrayList<>();
        for(int i=0;i<modeloLista.getSize();i++){
            
            modeloLista3.addElement(modeloLista.getElementAt(i));
            listaTablas.add(modeloLista.getElementAt(i).toString());
        }
        
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
       int conf=JOptionPane.showConfirmDialog(null, "Al confirmar se deshabilitará la opción de Selección de tablas","Question",JOptionPane.YES_NO_OPTION);
       if(conf==0){
           btnAgregar.setEnabled(false);
           btnQuitar.setEnabled(false);
           btnConfirmar.setEnabled(false);
           laminaCampos.setVisible(true);
           lista1.setEnabled(false);
           lista2.setEnabled(false);
           
           llenarListaTablas();
           setSize(980,400);
           setLocationRelativeTo(null);
           
       }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    public void llenarListaCampos(){
        
        
        for(int i=0;i<modeloLista4.getSize();i++){
            
            modeloLista3.addElement(modeloLista.getElementAt(i));
            
        }
        
    }
    
    public boolean verificarRepeticionLista5(String op){
        boolean b=false;
        for(int i=0;i<modeloLista5.getSize();i++){
            
            if(modeloLista5.getElementAt(i).equals(op))
                b=true;
        }
        
        return b;
        
    }
    
    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        
        String tabla=lista3.getSelectedValue();
        String campo=lista4.getSelectedValue();
        
        String tablaOpcional=lista3.getSelectedValue();
        if(tablaOpcional.equals("CLIENTE"))
            tablaOpcional="PERSONA";
        
        String op=tabla + "." + campo;
        String op2=tablaOpcional + "." + campo;
        
        if(lista4.getSelectedIndex()>=0){
            if(!verificarRepeticionLista5(op))
            {
                
                modeloLista5.addElement(op);
                setListaCampos(op2);
            }
                
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void setListaCampos(String elemento){
        listaCampos.add(elemento);
    }
    
    private void btnQuitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar1ActionPerformed
        
        if(lista5.getSelectedIndex()>=0){
            
            int pos=lista5.getSelectedIndex();
            modeloLista5.remove(pos);
            listaCampos.remove(pos);
        }
    }//GEN-LAST:event_btnQuitar1ActionPerformed

    /*public void llenarListCampos(){
        
        for(int i=0;i<modeloLista5.getSize();i++){
            
            listaCampos.add(modeloLista5.getElementAt(i).toString());
        }
    }*/
    
    private void btnConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar1ActionPerformed
        //llenarListCampos();
        //System.out.println(listaCampos);
        dispose();
        VentaConsultaCampaña ventana=new VentaConsultaCampaña(listaTablas,listaCampos,nombreCampaña);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btnConfirmar1ActionPerformed

    private void lista3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista3ValueChanged
       if(lista3.getSelectedValue().equals("CLIENTE")){
           modeloLista4.removeAllElements();
           modeloLista4.addElement("DNI");
           modeloLista4.addElement("NOMBRE");
           modeloLista4.addElement("FECHA_NACIMIENTO");
           modeloLista4.addElement("CELULAR");
           modeloLista4.addElement("EMAIL");
       }else if(lista3.getSelectedValue().equals("VENTA")){
           modeloLista4.removeAllElements();
           modeloLista4.addElement("NUM_TICKET");
           modeloLista4.addElement("DNI");
           modeloLista4.addElement("FECHA");
           modeloLista4.addElement("MONTO_TOTAL");
           modeloLista4.addElement("IGV");
           modeloLista4.addElement("MONTO_NETO");
           modeloLista4.addElement("ESTADO");
       }else if(lista3.getSelectedValue().equals("DETALLE_VENTA")){
           modeloLista4.removeAllElements();
           modeloLista4.addElement("NUM_TICKET");
           modeloLista4.addElement("COD_PRODUCTO");
           modeloLista4.addElement("CANTIDAD");
           modeloLista4.addElement("MONTO_SUBTOTAL");
       }else if(lista3.getSelectedValue().equals("PRODUCTO")){
           modeloLista4.removeAllElements();
           modeloLista4.addElement("COD_PRODUCTO");
           modeloLista4.addElement("NOMBRE");
           modeloLista4.addElement("DES_PRODUCTO");
           modeloLista4.addElement("PRECIO_VENTA");
           modeloLista4.addElement("CANTIDAD_STOCK");
       }
       
       
    }//GEN-LAST:event_lista3ValueChanged

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
        VentanaCampaña ventana=new VentanaCampaña();
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
            java.util.logging.Logger.getLogger(VentanaSeleccionTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSeleccionTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSeleccionTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSeleccionTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSeleccionTablas("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConfirmar1;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel lamina1;
    private javax.swing.JPanel laminaCampos;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JList<String> lista1;
    private javax.swing.JList<String> lista2;
    private javax.swing.JList<String> lista3;
    private javax.swing.JList<String> lista4;
    private javax.swing.JList<String> lista5;
    private javax.swing.JLabel tit1;
    private javax.swing.JLabel tit2;
    // End of variables declaration//GEN-END:variables
}
