
package InterfaceCampaña;

import BEAN.CampañaBEAN;
import DAO.CampañaDAO;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class VentanaEnvioEmail extends JFrame{
    
    private JLabel titulo,asunto,mensaje;
    private JTextField txtAsunto;
    private JTextArea txtMensaje;
    private JButton btnEnviar,btnCancelar,btnAtras;
    private JSeparator h1;
    private ArrayList<String> listaEmails;
    private JPanel lamina;
    private String nombreCampaña;
    
    public VentanaEnvioEmail(ArrayList<String> listaEmails,String nombreCampaña)
    {
        this.nombreCampaña=nombreCampaña;
        this.listaEmails=listaEmails;
        setTitle("Redacción Email");
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
        
        titulo=new JLabel("REDACCIÓN EMAIL");
        titulo.setBounds(80,10,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        asunto=new JLabel("Asunto");
        asunto.setBounds(50,70,120,20);
        asunto.setFont(fuenteCamposLabel);
        asunto.setForeground(ColorFuente);
        
        txtAsunto=new JTextField();
        txtAsunto.setBounds(50,95,250,20);
        txtAsunto.setFont(fuenteCampos);
        txtAsunto.setBorder(null);
       
        h1=new JSeparator();
        h1.setBounds(50,115,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        mensaje=new JLabel("Mensaje");
        mensaje.setBounds(50,130,150,20);
        mensaje.setFont(fuenteCamposLabel);
        mensaje.setForeground(ColorFuente);
        
        txtMensaje=new JTextArea();
        JScrollPane scroll=new JScrollPane(txtMensaje);
        scroll.setBounds(50,155,250,100);
        txtMensaje.setFont(fuenteCampos);
        
//        h2=new JSeparator();
//        h2.setBounds(50,175,250,20);
//        h2.setOpaque(false);
//        h2.setBackground(Color.gray);
        
        
        btnEnviar=new JButton("Enviar");
        btnEnviar.setBounds(50,270,110,30);
        btnEnviar.setFont(fuenteCamposLabel);
        btnEnviar.setBackground(null);
        btnEnviar.setForeground(ColorFuente);
        btnEnviar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnEnviar));
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                enviar();
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
            }
        });
        
        lamina.add(btnAtras);
        lamina.add(titulo);
        lamina.add(asunto);
        lamina.add(mensaje);
        lamina.add(txtAsunto);
        lamina.add(scroll);
        lamina.add(btnEnviar);
        lamina.add(btnCancelar);
        lamina.add(h1);
//        lamina.add(h2);
        
        add(lamina);
    }

    public void enviar(){
        
        String asuntoSel=txtAsunto.getText();
        String mensajeSel=txtMensaje.getText();
        
        if(asuntoSel.length()==0){
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Asunto");
            txtAsunto.requestFocus();
        }else if(mensajeSel.length()==0){
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Mensaje");
            txtMensaje.requestFocus();
        }else{
            String emailsConcatenados="";
            CampañaDAO dao=new CampañaDAO();
            for(int i=0;i<listaEmails.size();i++){
                
                if(i==listaEmails.size()-1){
                    emailsConcatenados+=listaEmails.get(i);
                }else{
                   emailsConcatenados+=listaEmails.get(i) + ";"; 
                }
                
            }
            dao.procEnvioEmail(emailsConcatenados, asuntoSel, mensajeSel);
            
            CampañaBEAN obj=new CampañaBEAN();
            obj.setNombre(nombreCampaña);
            obj.setCadenaEmails(emailsConcatenados);
            obj.setAsunto(asuntoSel);
            obj.setMensaje(mensajeSel);
            
            CampañaDAO camdao=new CampañaDAO();
            camdao.actualizarCampaña(obj);
            
            limpiarCampos();
        }
    }
    
    public void limpiarCampos()
    {
        txtAsunto.setText("");
        txtMensaje.setText("");
        txtAsunto.requestFocus();
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

