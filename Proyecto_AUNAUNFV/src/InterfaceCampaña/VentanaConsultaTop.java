
package InterfaceCampaña;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class VentanaConsultaTop  extends JFrame{
    
    private JLabel titulo,orden,top,agrupacion;
    private JComboBox cbOrden,cbTop,cbAgrupacion,cbFuncionAgregada,cbCampoOrden,cbFuncionOrdenar;
    private JButton btnAceptar,btnCancelar,btnAtras;
    private JSeparator h1,h2,h3,h4,h5,h6;
    private ArrayList<String> listaCampos,listaTablas;
    private VentaConsultaCampaña ventana;
    private JPanel lamina;
    
    public VentanaConsultaTop(VentaConsultaCampaña ventana,ArrayList<String> listaTablas,ArrayList<String> listaCampos)
    {
        this.ventana=ventana;
        this.listaTablas=listaTablas;
        this.listaCampos=listaCampos;
        setTitle("Filtro Top");
        setSize(350,450);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        lamina=new JPanel();
        lamina.setLayout(null);
        lamina.setBackground(Color.LIGHT_GRAY.brighter());
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteMensaje=new Font("Decker",Font.PLAIN,12);
        
        titulo=new JLabel("FILTRO TOP");
        titulo.setBounds(120,10,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        top=new JLabel("Top");
        top.setBounds(50,70,120,20);
        top.setFont(fuenteCamposLabel);
        top.setForeground(ColorFuente);
        
        
        cbTop=new JComboBox();
        cbTop.addItem("--Seleccionar Top--");
        for(int i=1;i<=100;i++)
            cbTop.addItem(i);
        cbTop.setBounds(50,95,250,20);
        cbTop.setFont(fuenteCamposLabel);
        cbTop.setForeground(ColorFuente);
        
        h1=new JSeparator();
        h1.setBounds(50,115,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        
        orden=new JLabel("Orden");
        orden.setBounds(50,130,150,20);
        orden.setFont(fuenteCamposLabel);
        orden.setForeground(ColorFuente);
        
        cbOrden=new JComboBox();
        cbOrden.addItem("--Seleccionar orden--");
        cbOrden.addItem("ASCENDENTE");
        cbOrden.addItem("DESCENDENTE");
        cbOrden.setBounds(50,155,250,20);
        cbOrden.setFont(fuenteCampos);
        cbOrden.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,175,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        cbFuncionOrdenar=new JComboBox();
        cbFuncionOrdenar.addItem("Ninguna");
        cbFuncionOrdenar.addItem("SUM");
        cbFuncionOrdenar.addItem("COUNT");
        cbFuncionOrdenar.setBounds(50,155+35,250,20);
        cbFuncionOrdenar.setFont(fuenteCampos);
        cbFuncionOrdenar.setBorder(null);
        
        h6=new JSeparator();
        h6.setBounds(50,175+35,250,20);
        h6.setOpaque(false);
        h6.setBackground(Color.gray);
        
        cbCampoOrden=new JComboBox();
        llenarComboBox(cbCampoOrden);
        cbCampoOrden.setBounds(50,190+35,250,20);
        cbCampoOrden.setFont(fuenteCampos);
        cbCampoOrden.setBorder(null);
        
        h5=new JSeparator();
        h5.setBounds(50,210+35,250,20);
        h5.setOpaque(false);
        h5.setBackground(Color.gray);
        
        agrupacion=new JLabel("Agrupación");
        agrupacion.setBounds(50,190+35+35,200,20);
        agrupacion.setFont(fuenteCamposLabel);
        agrupacion.setForeground(ColorFuente);
        
        cbFuncionAgregada=new JComboBox();
        cbFuncionAgregada.addItem("Ninguna");
        cbFuncionAgregada.addItem("SUM");
        cbFuncionAgregada.addItem("COUNT");
        cbFuncionAgregada.setBounds(50,215+35+35,250,20);
        cbFuncionAgregada.setFont(fuenteCampos);
        cbFuncionAgregada.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,235+35+35,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);
        
        cbAgrupacion=new JComboBox();
        llenarComboBox(cbAgrupacion);
        cbAgrupacion.setBounds(50,250+35+35,250,20);
        cbAgrupacion.setFont(fuenteCampos);
        cbAgrupacion.setBorder(null);
        
        h4=new JSeparator();
        h4.setBounds(50,270 +35+35,250,20);
        h4.setOpaque(false);
        h4.setBackground(Color.gray);
        
        btnAceptar=new JButton("Aceptar");
        btnAceptar.setBounds(50,305+35+35,110,30);
        btnAceptar.setFont(fuenteCamposLabel);
        btnAceptar.setBackground(null);
        btnAceptar.setForeground(ColorFuente);
        btnAceptar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAceptar));
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aceptar();
            }
        });
        
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(175,305 +35+35,120,30);
        btnCancelar.setFont(fuenteCamposLabel);
        btnCancelar.setBackground(null);
        btnCancelar.setForeground(ColorFuente);
        btnCancelar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnCancelar));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarCampos();
            }
        });
        
        btnAtras=new JButton(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.setBounds(10,305 +35+35,30,30);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        
        lamina.add(btnAtras);
        lamina.add(titulo);
        lamina.add(orden);
        lamina.add(agrupacion);
        lamina.add(top);
        lamina.add(cbAgrupacion);
        lamina.add(cbFuncionAgregada);
        lamina.add(cbOrden);
        lamina.add(cbTop);
        lamina.add(cbFuncionOrdenar);
        lamina.add(cbCampoOrden);
        lamina.add(btnAceptar);
        lamina.add(btnCancelar);
        lamina.add(h1);
        lamina.add(h2);
        lamina.add(h3);
        lamina.add(h4);
        lamina.add(h5);
        
        add(lamina);
    }

    public void llenarComboBox(JComboBox cb){
        
        
        cb.addItem("--Seleccionar campo--");
        
        for(String campo:listaCampos){
            
            cb.addItem(campo);
            
        }
        
    }
      
    public void aceptar(){
        
        //FALTA
        String topSelec,agrupacionSelec,funcionSelec,ordenSelec,ordenCampoSelec,funcionOrdenarSelec;
        
        topSelec=cbTop.getSelectedItem().toString();
        ordenSelec=cbOrden.getSelectedItem().toString();
        funcionSelec=cbFuncionAgregada.getSelectedItem().toString();
        agrupacionSelec=cbAgrupacion.getSelectedItem().toString();
        ordenCampoSelec=cbCampoOrden.getSelectedItem().toString();
        funcionOrdenarSelec=cbFuncionOrdenar.getSelectedItem().toString();
        
        String condicionTop="";
        String condicionBot="";
        
        if(topSelec.equals("--Seleccionar Top--")){
            
            JOptionPane.showMessageDialog(null, "Ud. debe seleccionar un Top");
            cbTop.requestFocus();
        }else if(ordenSelec.equals("--Seleccionar orden--")){
            
            JOptionPane.showMessageDialog(null, "Ud. debe seleccionar un Orden");
            cbOrden.requestFocus();
        }else if(ordenCampoSelec.equals("--Seleccionar campo--")){
            
            JOptionPane.showMessageDialog(null, "Ud. debe seleccionar un Campo a ordenar");
            cbCampoOrden.requestFocus();
        }else{
            
           condicionTop="SELECT TOP " + topSelec + " ";
           condicionBot="GROUP BY ";
           
           if(agrupacionSelec.equals("--Seleccionar campo--"))
                agrupacionSelec=" ";
           
           if(funcionSelec.equals("Ninguna"))
               condicionBot+=" " + agrupacionSelec + " ";
           else
               condicionBot+=" " + funcionSelec  + " (" + agrupacionSelec + ") ";
           
           for(int i=0;i<listaCampos.size();i++){
               
               if(agrupacionSelec.equals(" ")){
                   
                   if(i==0)
                        condicionBot+=" " + listaCampos.get(i) + " ";
                   else
                       condicionBot+=" ," + listaCampos.get(i) + " ";
               }else{
                   condicionBot+=" ," + listaCampos.get(i) + " ";
               }
           }
               
           
           if(ordenSelec.equals("ASCENDENTE"))
               ordenSelec="ASC";
            else if(ordenSelec.equals("DESCENDENTE"))
                ordenSelec="DESC";
           
            condicionBot+=" ORDER BY ";
            
            
            if(funcionOrdenarSelec.equals("Ninguna"))
                condicionBot+=" " + ordenCampoSelec + " " + ordenSelec;
            else
                condicionBot+=" " + funcionOrdenarSelec + " ( " + ordenCampoSelec + ") " + ordenSelec  + " ";
                
            ventana.setCondicionTop(condicionTop);
            ventana.setCondicionBot(condicionBot);
            
            String condicionalTop=ventana.getCondicionTop();
            String condicionalBot=ventana.getCondicionBot();
            JOptionPane.showMessageDialog(null, "Filtro Realizado exitosamente");
            ventana.llenarTablaFiltroTop(condicionalTop,condicionalBot);
            dispose();
        }
        
    }
    
    public void limpiarCampos()
    {
        
        cbAgrupacion.setSelectedIndex(0);
        cbFuncionAgregada.setSelectedIndex(0);
        cbOrden.setSelectedIndex(0);
        cbTop.setSelectedIndex(0);
        cbTop.requestFocus();
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
}

