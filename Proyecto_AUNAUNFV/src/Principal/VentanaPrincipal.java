package Principal;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import InterfaceGraficaRegistro.VentanaRegistroUsuarioInicio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;


public class VentanaPrincipal extends JFrame implements ActionListener
{
    private PanelVentanaPrincipal miPanel;
    private int contador=0;
            
    public VentanaPrincipal()
    {
        setTitle("Ventana Principal");
        setSize(350,400);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();  
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaPrincipal(this);
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnIngresar().addActionListener(this);
        miPanel.getBtnSalir().addActionListener(this);
        miPanel.getBtnIngresar().addKeyListener(new cambioCampo());
        miPanel.getTxtcla().addKeyListener(new cambioCampo());
        miPanel.getTxtusu().addKeyListener(new cambioCampo());
        miPanel.getBtnSalir().addKeyListener(new cambioCampo());
        miPanel.getBtnRegistrar().addMouseListener(new AccionMouseIngreso());
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnSalir())
        {
            System.exit(0);
        }
        
        if(e.getSource()==miPanel.getBtnIngresar())
        {
            eventoIngreso();
        }
    }
    
    public void eventoIngreso()
    {
        String usu,cla;
        usu=miPanel.getTxtusu().getText();
        cla=miPanel.getTxtcla().getText();

        if(usu.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Usuario ");
            miPanel.getTxtusu().requestFocus();
        }
        else if(cla.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Contraseña ");
            miPanel.getTxtcla().requestFocus();
        }
        else
        {
            contador++;
            if(contador==2)
            {
                miPanel.getCerrar().setBounds(305,60,40,12);
                miPanel.getMensaje().setText("A Usted le queda " + (3-contador) + " intento para acceder al Sistema");
            }
            else
            {
                miPanel.getMensaje().setText("A Usted le quedan " + (3-contador) + " intentos para acceder al Sistema");
                miPanel.getMensaje().setBounds(25,55,300,20);
                miPanel.getCerrar().setBounds(310,60,40,12);
            }

            if(contador<4)
            {
                UsuarioBEAN usuario=new UsuarioBEAN();
                usuario.setNombre(usu);
                usuario.setClave(cla);
                UsuarioDAO usuarioDAO=new UsuarioDAO();
                int verificar=usuarioDAO.verificarCuentaDeUsuario(usuario);
                if(verificar==1)
                {
                    String tipo=usuarioDAO.getTipoUsuario(usuario);
                    
                    if(tipo.equals("Administrador"))
                    {
                        setVisible(false);
                        VentanaProcesos miVentana=new VentanaProcesos();
                        miVentana.setVisible(true);
                        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El usuario ingresado no corresponde al Tipo de usuario Administrador");
                        miPanel.limpiarCampos();
                        miPanel.getTxtusu().requestFocus();
                    }
                }
                else if(contador==3)
                {
                    JOptionPane.showMessageDialog(null, "Usted ha superado el límite de intentos\nPrograma Finalizado!!");
                    System.exit(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El usuario y/o contraseña son incorrectos");
                    miPanel.limpiarCampos();
                    miPanel.getTxtusu().requestFocus();
                }
            }
        }
    }
    
    private class cambioCampo extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getSource()==miPanel.getTxtusu())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtusu().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtcla())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoIngreso(); 
            }
            
            if(e.getSource()==miPanel.getBtnIngresar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoIngreso();
            }
            
            if(e.getSource()==miPanel.getBtnSalir())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    System.exit(0);
            }
                
        }
    }
    
    private class AccionMouseIngreso extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            setVisible(false);
            VentanaRegistroUsuarioInicio ventana=new VentanaRegistroUsuarioInicio();
            ventana.setVisible(true);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}

/*public class VentanaPrincipal extends JFrame{
    
    private JPanel miPanel;
    private JLabel icono;
    private JButton ingresar;
    
    public VentanaPrincipal(){
        
        setTitle("Ingreso al Sistema");
        setSize(200,200);
        setResizable(false);
        setLocationRelativeTo(null);
        inicioComponentes();
    }
    
    private void inicioComponentes(){
        
        setLayout(new BorderLayout());
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        
        miPanel=new JPanel();
        miPanel.setLayout(null);
        miPanel.setBackground(new Color(215,215,215));
        
        ingresar=new JButton("Ingresar");
        ingresar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,ingresar));
        ingresar.setBackground(null);
        ingresar.setForeground(ColorFuente);
        ingresar.setFont(fuenteCamposLabel);
        ingresar.addKeyListener(new cambioCampo());
        ingresar.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                eventoIngreso();
            }
            
        });
        
        URL ruta=this.getClass().getResource("/imagenes/logo.jpg");
        icono=new JLabel(new ImageIcon(ruta));
        icono.setBounds(0,0,200,150);
        
        add(ingresar,BorderLayout.SOUTH);
        miPanel.add(icono);
        add(miPanel,BorderLayout.CENTER);
        
    }
    
    private class cambioCampo extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e)
        {
          
            if(e.VK_ENTER==e.getKeyCode())
                eventoIngreso();
        }
    }
    
    private void eventoIngreso(){
        
        dispose();
        VentanaProcesos procesos=new VentanaProcesos();
        procesos.setVisible(true);
        procesos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}*/
