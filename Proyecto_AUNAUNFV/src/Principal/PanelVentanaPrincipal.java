
package Principal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.util.Map;

public class PanelVentanaPrincipal extends JPanel 
{
    private JLabel titulo,usu,cla,mensaje,btnRegistrar;
    private JTextField txtusu;
    private JPasswordField txtcla;
    private JButton btnSalir,btnIngresar;
    private JSeparator h1,h2;
    private JLabel cerrar,icono1,icono2;
    private VentanaPrincipal ventana;
    
    public PanelVentanaPrincipal(VentanaPrincipal ventana)
    {
        this.ventana=ventana;
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteMensaje=new Font("Decker",Font.ITALIC,12);
        
        titulo=new JLabel("INICIO DE SESIÓN");
        titulo.setBounds(90,10,200,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        mensaje=new JLabel("Usted tiene 3 intentos para acceder al Sistema");
        mensaje.setBounds(40,55,270,20);
        mensaje.setFont(fuenteMensaje);
        mensaje.setForeground(ColorFuente);
        
        cerrar=new JLabel(insertarIcono("/imagenes/close.png"));
        cerrar.setBounds(290,60,40,12);
        cerrar.addMouseListener(new AccionMouse());
        
        icono1=new JLabel(insertarIcono("/imagenes/user.png"));
        icono1.setBounds(10,100,40,30);
        
        usu=new JLabel("Usuario ");
        usu.setBounds(50,100,80,20);
        usu.setFont(fuenteCamposLabel);
        usu.setForeground(ColorFuente);
        
        txtusu=new JTextField();
        txtusu.setBounds(50,125,250,20);
        txtusu.setFont(fuenteCampos);
        txtusu.setBorder(null);
        
        h1=new JSeparator();
        h1.setBounds(50,145,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        icono2=new JLabel(insertarIcono("/imagenes/llave.png"));
        icono2.setBounds(10,180,40,30);
        
        cla=new JLabel("Contraseña ");
        cla.setBounds(50,180,120,20);
        cla.setFont(fuenteCamposLabel);
        cla.setForeground(ColorFuente);
        
        txtcla=new JPasswordField();
        txtcla.setBounds(50,205,250,20);
        txtcla.setFont(fuenteCampos);
        txtcla.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,225,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setBounds(80,270,100,30);
        btnIngresar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnIngresar));
        btnIngresar.setFont(fuenteCamposLabel);
        btnIngresar.setBackground(null);
        btnIngresar.setForeground(ColorFuente);
        
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(190,270,85,30);
        btnSalir.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnSalir));
        btnSalir.setFont(fuenteCamposLabel);
        btnSalir.setBackground(null);
        btnSalir.setForeground(ColorFuente);
        
        btnRegistrar=new JLabel("Registrarse");
        btnRegistrar.setBounds(130,320,100,30);
        btnRegistrar.setFont(fuenteCamposLabel);
        btnRegistrar.setBackground(null);
        btnRegistrar.setForeground(ColorFuente);
        Map attributes = fuenteCamposLabel.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnRegistrar.setFont(fuenteCamposLabel.deriveFont(attributes));
        
        add(txtusu);
        add(txtcla);
        add(titulo);
        add(usu);
        add(cla);
        add(cerrar);
        add(btnSalir);
        add(btnIngresar);
        add(mensaje);
        add(h1);
        add(h2);
        add(icono1);
        add(icono2);
        add(btnRegistrar);

    }

    public JLabel getCerrar() {
        return cerrar;
    }
    
    public JTextField getTxtusu() 
    {
        return txtusu;
    }

    public JPasswordField getTxtcla() 
    {
        return txtcla;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JLabel getMensaje() {
        return mensaje;
    }
    
    public void limpiarCampos()
    {
        txtcla.setText("");
        txtusu.setText("");
    }

    public JLabel getBtnRegistrar() {
        return btnRegistrar;
    }
    
    
    
    private Icon insertarIcono(String ruta)
    {
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        
        return icono;
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
    
    private class AccionMouse extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            cerrar.setVisible(false);
            mensaje.setVisible(false);
            icono1.setBounds(10,70,40,30);
            usu.setBounds(50,70,80,20);
            txtusu.setBounds(50,95,250,20);
            h1.setBounds(50,115,250,20);
            icono2.setBounds(10,150,40,30);
            cla.setBounds(50,150,120,20);
            txtcla.setBounds(50,175,250,20);
            h2.setBounds(50,195,250,20);
            btnIngresar.setBounds(80,240,100,30);
            btnSalir.setBounds(190,240,85,30);
            btnRegistrar.setBounds(130,290,100,30);
            ventana.setSize(350,370);
        }
    }
    
    
}
