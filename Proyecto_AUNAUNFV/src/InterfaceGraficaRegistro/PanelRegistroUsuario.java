
package InterfaceGraficaRegistro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelRegistroUsuario extends JPanel  
{
    private JLabel mensaje,mensaje2,titulo,usu,dni,cla1,cla2,tipo;
    private JTextField txtDni,txtUsu;
    private JPasswordField txtCla1,txtCla2;
    private JComboBox cbTipo;
    private JButton btnGuardar,btnCancelar,btnAtras;
    private JSeparator h1,h2,h3,h4,h5;
    
    public PanelRegistroUsuario()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        Color ColorFuente=new Color(232,44,12);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteMensaje=new Font("Decker",Font.PLAIN,12);
        
        titulo=new JLabel("REGISTRAR USUARIO");
        titulo.setBounds(80,10,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        dni=new JLabel("DNI");
        dni.setBounds(50,70,120,20);
        dni.setFont(fuenteCamposLabel);
        dni.setForeground(ColorFuente);
        
        txtDni=new JTextField();
        txtDni.setBounds(50,95,250,20);
        txtDni.addKeyListener(new validarCampos());
        txtDni.setFont(fuenteCampos);
        txtDni.setBorder(null);
        
        h1=new JSeparator();
        h1.setBounds(50,115,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        mensaje=new JLabel();
        mensaje.setBounds(190,70,120,20);
        mensaje.setForeground(ColorFuente);
        mensaje.setFont(fuenteMensaje);
        
        tipo=new JLabel("Tipo Usuario");
        tipo.setBounds(50,130,150,20);
        tipo.setFont(fuenteCamposLabel);
        tipo.setForeground(ColorFuente);
        
        cbTipo=new JComboBox();
        cbTipo.addItem("--Seleccionar Tipo--");
        cbTipo.addItem("Administrador");
        cbTipo.addItem("Cliente");
        cbTipo.setBounds(50,155,250,20);
        cbTipo.setFont(fuenteCampos);
        
        h2=new JSeparator();
        h2.setBounds(50,175,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        usu=new JLabel("Usuario");
        usu.setBounds(50,190,200,20);
        usu.setFont(fuenteCamposLabel);
        usu.setForeground(ColorFuente);
        
        txtUsu=new JTextField();
        txtUsu.setBounds(50,215,250,20);
        txtUsu.setFont(fuenteCampos);
        txtUsu.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,235,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);
        
        mensaje2=new JLabel();
        mensaje2.setBounds(190,190,200,20);
        mensaje2.setForeground(ColorFuente);
        mensaje2.setFont(fuenteMensaje);
        
        cla1=new JLabel("Contraseña");
        cla1.setBounds(50,250,200,20);
        cla1.setFont(fuenteCamposLabel);
        cla1.setForeground(ColorFuente);
        
        txtCla1=new JPasswordField();
        txtCla1.setBounds(50,275,250,20);
        txtCla1.setFont(fuenteCampos);
        txtCla1.setBorder(null);
        
        h4=new JSeparator();
        h4.setBounds(50,295,250,20);
        h4.setOpaque(false);
        h4.setBackground(Color.gray);

        cla2=new JLabel("Repetir Contraseña");
        cla2.setBounds(50,310,250,20);
        cla2.setFont(fuenteCamposLabel);
        cla2.setForeground(ColorFuente);
        
        txtCla2=new JPasswordField();
        txtCla2.setBounds(50,335,250,20);
        txtCla2.setFont(fuenteCampos);
        txtCla2.setBorder(null);
        
        h5=new JSeparator();
        h5.setBounds(50,355,250,20);
        h5.setOpaque(false);
        h5.setBackground(Color.gray);
        
        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(50,390,110,30);
        btnGuardar.setFont(fuenteCamposLabel);
        btnGuardar.setBackground(null);
        btnGuardar.setForeground(ColorFuente);
        btnGuardar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnGuardar));
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(175,390,120,30);
        btnCancelar.setFont(fuenteCamposLabel);
        btnCancelar.setBackground(null);
        btnCancelar.setForeground(ColorFuente);
        btnCancelar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnCancelar));
        
        btnAtras=new JButton(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.setBounds(10,390,30,30);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        
        add(btnAtras);
        add(titulo);
        add(dni);
        add(tipo);
        add(cla1);
        add(cla2);
        add(usu);
        add(txtDni);
        add(txtUsu);
        add(txtCla1);
        add(txtCla2);
        add(cbTipo);
        add(btnGuardar);
        add(btnCancelar);
        add(mensaje);
        add(mensaje2);
        add(h1);
        add(h2);
        add(h3);
        add(h4);
        add(h5);
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public JTextField getTxtUsu() {
        return txtUsu;
    }

    public JPasswordField getTxtCla1() {
        return txtCla1;
    }

    public JPasswordField getTxtCla2() {
        return txtCla2;
    }

    public JComboBox getCbTipo() {
        return cbTipo;
    }

    public JLabel getMensaje() {
        return mensaje;
    }

    public JLabel getMensaje2() {
        return mensaje2;
    }
    
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    public JButton getBtnAtras() {
        return btnAtras;
    }
    
    public void limpiarCampos()
    {
        txtUsu.setText("");
        txtDni.setText("");
        txtCla1.setText("");
        txtCla2.setText("");
        cbTipo.setSelectedIndex(0);
        txtDni.requestFocus();
    }
    
    private class validarCampos extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            char teclaPresionada=e.getKeyChar();
            if(e.getSource()==txtDni)
            {
                if(teclaPresionada<'0' || teclaPresionada>'9')
                    e.consume();
            }
            
            if(e.getSource()==txtDni){
                if(txtDni.getText().length()==8)
                    e.consume();
            }
            
        }
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


