
package InterfaceGraficaRegistro;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelRegistroUsuarioInicio extends JPanel{
    
    private JLabel mensaje,mensaje2,titulo,nom,dni,fecha,cel,email,cargo,usuario,clave1,clave2;
    private JTextField txtNom,txtDni,txtFecha,txtCel,txtEmail,txtCargo,txtUsuario;
    private JPasswordField txtClave1,txtClave2;
    private JButton btnGuardar,btnCancelar,btnAtras;
    private JSeparator h1,h2,h3,h4,h5,h6,h7,h8,h9;
    private String codigoEmpleado;
    
    public PanelRegistroUsuarioInicio()
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
        
        nom=new JLabel("Nombre");
        nom.setBounds(50,130,150,20);
        nom.setFont(fuenteCamposLabel);
        nom.setForeground(ColorFuente);
        
        txtNom=new JTextField();
        txtNom.setBounds(50,155,250,20);
        txtNom.addKeyListener(new validarCampos());
        txtNom.setFont(fuenteCampos);
        txtNom.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,175,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        usuario=new JLabel("Usuario");
        usuario.setBounds(50,190,200,20);
        usuario.setFont(fuenteCamposLabel);
        usuario.setForeground(ColorFuente);
        
        txtUsuario=new JTextField();
        txtUsuario.setBounds(50,215,250,20);
        txtUsuario.setFont(fuenteCampos);
        txtUsuario.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,235,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);
        
        mensaje2=new JLabel();
        mensaje2.setBounds(190,190,200,20);
        mensaje2.setForeground(ColorFuente);
        mensaje2.setFont(fuenteMensaje);
        
        clave1=new JLabel("Contraseña");
        clave1.setBounds(50,250,150,20);
        clave1.setFont(fuenteCamposLabel);
        clave1.setForeground(ColorFuente);
        
        txtClave1=new JPasswordField();
        txtClave1.setBounds(50,275,250,20);
        txtClave1.addKeyListener(new validarCampos());
        txtClave1.setFont(fuenteCampos);
        txtClave1.setBorder(null);
        
        h4=new JSeparator();
        h4.setBounds(50,295,250,20);
        h4.setOpaque(false);
        h4.setBackground(Color.gray);
        
        clave2=new JLabel("Repetir Contraseña");
        clave2.setBounds(50,310,180,20);
        clave2.setFont(fuenteCamposLabel);
        clave2.setForeground(ColorFuente);
        
        txtClave2=new JPasswordField();
        txtClave2.setBounds(50,335,250,20);
        txtClave2.setFont(fuenteCampos);
        txtClave2.setBorder(null);
        
        h5=new JSeparator();
        h5.setBounds(50,355,250,20);
        h5.setOpaque(false);
        h5.setBackground(Color.gray);
        
        cargo=new JLabel("Cargo");
        cargo.setBounds(50,370,280,20);
        cargo.setFont(fuenteCamposLabel);
        cargo.setForeground(ColorFuente);
        
        txtCargo=new JTextField();
        txtCargo.setBounds(50,395,250,20);
        txtCargo.setFont(fuenteCampos);
        txtCargo.setBorder(null);
        
        h6=new JSeparator();
        h6.setBounds(50,415,250,20);
        h6.setOpaque(false);
        h6.setBackground(Color.gray);
        
        fecha=new JLabel("Fecha de Nacimiento");
        fecha.setBounds(50,430,200,20);
        fecha.setFont(fuenteCamposLabel);
        fecha.setForeground(ColorFuente);
        
        txtFecha=new JTextField();
        txtFecha.setBounds(50,455,250,20);
        txtFecha.setFont(fuenteCampos);
        txtFecha.setBorder(null);
        
        h7=new JSeparator();
        h7.setBounds(50,475,250,20);
        h7.setOpaque(false);
        h7.setBackground(Color.gray);

        cel=new JLabel("Teléfono celular");
        cel.setBounds(50,490,150,20);
        cel.setFont(fuenteCamposLabel);
        cel.setForeground(ColorFuente);
        
        txtCel=new JTextField();
        txtCel.setBounds(50,515,250,20);
        txtCel.addKeyListener(new validarCampos());
        txtCel.setFont(fuenteCampos);
        txtCel.setBorder(null);
        
        h8=new JSeparator();
        h8.setBounds(50,535,250,20);
        h8.setOpaque(false);
        h8.setBackground(Color.gray);
        
        email=new JLabel("Email");
        email.setBounds(50,550,180,20);
        email.setFont(fuenteCamposLabel);
        email.setForeground(ColorFuente);
        
        txtEmail=new JTextField();
        txtEmail.setBounds(50,575,250,20);
        txtEmail.setFont(fuenteCampos);
        txtEmail.setBorder(null);
        
        h9=new JSeparator();
        h9.setBounds(50,595,250,20);
        h9.setOpaque(false);
        h9.setBackground(Color.gray);
        
        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(50,630,110,30);
        btnGuardar.setFont(fuenteCamposLabel);
        btnGuardar.setBackground(null);
        btnGuardar.setForeground(ColorFuente);
        btnGuardar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnGuardar));
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(175,630,120,30);
        btnCancelar.setFont(fuenteCamposLabel);
        btnCancelar.setBackground(null);
        btnCancelar.setForeground(ColorFuente);
        btnCancelar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnCancelar));
        
        btnAtras=new JButton(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.setBounds(10,630,30,30);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        
        add(btnAtras);
        add(titulo);
        add(dni);
        add(nom);
        add(cel);
        add(fecha);
        add(email);
        add(cargo);
        add(clave1);
        add(clave2);
        add(usuario);
        add(txtDni);
        add(txtNom);
        add(txtCel);
        add(txtFecha);
        add(txtEmail);
        add(txtClave1);
        add(txtClave2);
        add(txtUsuario);
        add(txtCargo);
        add(btnGuardar);
        add(btnCancelar);
        add(mensaje);
        add(mensaje2);
        add(h1);
        add(h2);
        add(h3);
        add(h4);
        add(h5);
        add(h6);
        add(h7);
        add(h8);
        add(h9);
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public JTextField getTxtDni() {
        return txtDni;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtCel() {
        return txtCel;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtCargo() {
        return txtCargo;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtClave1() {
        return txtClave1;
    }

    public JPasswordField getTxtClave2() {
        return txtClave2;
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
        txtNom.setText("");
        txtDni.setText("");
        txtCel.setText("");
        txtFecha.setText("");
        txtEmail.setText("");
        txtCargo.setText("");
        txtClave1.setText("");
        txtClave2.setText("");
        txtUsuario.setText("");
        
        txtDni.requestFocus();
    }
    
    private class validarCampos extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            char teclaPresionada=e.getKeyChar();
            if(e.getSource()==txtDni || e.getSource()==txtCel)
            {
                if(teclaPresionada<'0' || teclaPresionada>'9')
                    e.consume();
            }
            if(e.getSource()==txtNom)
            {
                if(((teclaPresionada<'a' || teclaPresionada>'z') && (teclaPresionada<'A' || teclaPresionada>'Z')) && teclaPresionada!=(char)32)
                    e.consume();
            }
            if(e.getSource()==txtDni){
                if(txtDni.getText().length()==8)
                    e.consume();
            }
            if(e.getSource()==txtCel){
                if(txtCel.getText().length()==9)
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
