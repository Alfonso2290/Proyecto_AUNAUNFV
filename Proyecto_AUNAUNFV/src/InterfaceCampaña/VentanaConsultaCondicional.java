
package InterfaceCampaña;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class VentanaConsultaCondicional  extends JFrame{
    
    private JLabel titulo,campo,operador,valor;
    private JTextField txtOtro,txtValor;
    private JComboBox cbCampo,cbOperador,cbAnexo;
    private JButton btnAceptar,btnCancelar,btnAtras;
    private JSeparator h1,h2,h3;
    private ArrayList<String> listaCampos,listaTablas;
    private VentaConsultaCampaña ventana;
    private JPanel lamina;
    
    public VentanaConsultaCondicional(VentaConsultaCampaña ventana,ArrayList<String> listaTablas,ArrayList<String> listaCampos)
    {
        this.ventana=ventana;
        this.listaTablas=listaTablas;
        this.listaCampos=listaCampos;
        setTitle("Filtro Condicional");
        setSize(350,350);
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
        
        titulo=new JLabel("FILTRO CONDICIONAL");
        titulo.setBounds(80,10,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        cbAnexo=new JComboBox();
        cbAnexo.addItem("AND");
        cbAnexo.addItem("OR");
        cbAnexo.setBounds(50,50,80,20);
        cbAnexo.setFont(fuenteCampos);
        cbAnexo.setBorder(null);
        
        if(ventana.getCondicionConcatenada()==null)
            cbAnexo.setVisible(false);
        else
            cbAnexo.setVisible(true);
        
        campo=new JLabel("Campo");
        campo.setBounds(50,70,120,20);
        campo.setFont(fuenteCamposLabel);
        campo.setForeground(ColorFuente);
        
        llenarComboBox();
        
        cbCampo.setBounds(50,95,250,20);
        cbCampo.setFont(fuenteCampos);
        cbCampo.setBorder(null);
        cbCampo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cambio();
            }
        });
        
        
        txtOtro=new JTextField();
        txtOtro.setBounds(50,95,250,20);
        txtOtro.setFont(fuenteCampos);
        txtOtro.setBorder(null);
        txtOtro.setVisible(false);
        
        h1=new JSeparator();
        h1.setBounds(50,115,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        
        operador=new JLabel("Operador");
        operador.setBounds(50,130,150,20);
        operador.setFont(fuenteCamposLabel);
        operador.setForeground(ColorFuente);
        
        cbOperador=new JComboBox();
        cbOperador.addItem("--Seleccionar operador--");
        cbOperador.addItem("=");
        cbOperador.addItem("<>");
        cbOperador.addItem("<");
        cbOperador.addItem("<=");
        cbOperador.addItem(">");
        cbOperador.addItem(">=");
        cbOperador.setBounds(50,155,250,20);
        cbOperador.setFont(fuenteCampos);
        cbOperador.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,175,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        valor=new JLabel("Valor");
        valor.setBounds(50,190,200,20);
        valor.setFont(fuenteCamposLabel);
        valor.setForeground(ColorFuente);
        
        txtValor=new JTextField();
        txtValor.setBounds(50,215,250,20);
        txtValor.setFont(fuenteCampos);
        txtValor.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,235,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);
        
        btnAceptar=new JButton("Aceptar");
        btnAceptar.setBounds(50,270,110,30);
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
        btnCancelar.setBounds(175,270,120,30);
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
        btnAtras.setBounds(10,270,30,30);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                VentaConsultaCampaña ventana=new VentaConsultaCampaña(listaTablas,listaCampos);
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        lamina.add(btnAtras);
        lamina.add(titulo);
        lamina.add(campo);
        lamina.add(cbCampo);
        lamina.add(txtOtro);
        lamina.add(valor);
        lamina.add(txtValor);
        lamina.add(operador);
        lamina.add(cbOperador);
        lamina.add(btnAceptar);
        lamina.add(btnCancelar);
        lamina.add(h1);
        lamina.add(h2);
        lamina.add(h3);
        lamina.add(cbAnexo);
        
        add(lamina);
    }

    public void llenarComboBox(){
        
        cbCampo=new JComboBox();
        
        cbCampo.addItem("--Seleccionar campo--");
        
        for(String campo:listaCampos){
            
            cbCampo.addItem(campo);
            
        }
        
        cbCampo.addItem("Otro");
    }
    
    public void cambio(){
        
        String campoSelec;
        campoSelec=cbCampo.getSelectedItem().toString();
        
        if(campoSelec.equals("Otro")){
            
            txtOtro.setVisible(true);
            cbCampo.setVisible(false);
            
        }else {
            txtOtro.setVisible(false);
            cbCampo.setVisible(true);
        }
    }
    
    public void aceptar(){
        
        String campoSelec,operadorSelec,valorSelec,campoLlenado;
        campoSelec=cbCampo.getSelectedItem().toString();
        operadorSelec=cbOperador.getSelectedItem().toString();
        valorSelec=txtValor.getText();
        campoLlenado=txtOtro.getText();
        
        String condicion="";
        
        if(campoSelec.equals("--Seleccionar campo--") && cbCampo.isVisible()){
            
            JOptionPane.showMessageDialog(null, "Ud. debe seleccionar un Campo");
            cbCampo.requestFocus();
        }else if(operadorSelec.equals("--Seleccionar operador--")){
            
            JOptionPane.showMessageDialog(null, "Ud. debe seleccionar un Operador");
            cbOperador.requestFocus();
        }else if(valorSelec.length()==0){
            
            JOptionPane.showMessageDialog(null, "Ud. debe llenar el campo Valor");
            txtValor.requestFocus();
        }else if(campoLlenado.length()==0 && txtOtro.isVisible()){
            
            JOptionPane.showMessageDialog(null, "Ud. debe llenar el campo Campo");
            txtOtro.requestFocus();
        }else{
            
            if(ventana.getCondicionConcatenada()==null){
                
                if(cbCampo.isVisible()){
                    condicion="WHERE " + campoSelec + " " + operadorSelec + " '" +valorSelec + "' "; 
                }else if(txtOtro.isVisible()){
                    condicion="WHERE " + campoLlenado + " " + operadorSelec + " '" +valorSelec + "' "; 
                }
                
                ventana.setCondicionConcatenada(condicion);
            }else{
                
                String anexo=cbAnexo.getSelectedItem().toString();
                
                if(cbCampo.isVisible()){
                    condicion=" " + anexo + " " + campoSelec + " " + operadorSelec + " '" +valorSelec + "' "; 
                }else if(txtOtro.isVisible()){
                    condicion=" " + anexo + " " + campoLlenado + " " + operadorSelec + " '" +valorSelec + "' "; 
                }
                
                ventana.concatenarCondicionConcatenada(condicion);
                
            }
            
            String condicional=ventana.getCondicionConcatenada();
            JOptionPane.showMessageDialog(null, "Filtro Realizado exitosamente");
            ventana.llenarTablaFiltro(condicional);
            dispose();
        }
        
    }
    
    public void limpiarCampos()
    {
        txtOtro.setText("");
        txtValor.setText("");
        cbCampo.setSelectedIndex(0);
        cbOperador.setSelectedIndex(0);
        cbCampo.requestFocus();
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
