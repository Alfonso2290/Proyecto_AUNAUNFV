
package InterfaceGraficaConsulta;

import Principal.VentanaProcesos;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VentanaConsultas extends JFrame{
    
    private JPanel lamina;
    private JLabel cliente,producto,venta,cli,pro ,ven,titulo,detalle,det;
    private JButton btnAtras;
    
    public VentanaConsultas(){
        
        setTitle("Selección de consulta");
        setSize(650,320);
        setResizable(false);
        setLocationRelativeTo(null);

        inicioComponentes();
    }
    
    private void inicioComponentes(){
        
        lamina=new JPanel();
        lamina.setLayout(null);
        lamina.setBackground(Color.LIGHT_GRAY.brighter());
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 18);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        
        titulo=new JLabel("SELECCIÓN DE CONSULTA");
        titulo.setBounds(200,20,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        cliente=new JLabel(new ImageIcon("src/imagenes/cliente.png"));
        cliente.setBounds(55,70,100,150);
        cliente.addMouseListener(new eventoMouse());
        
        cli=new JLabel("CLIENTES");
        cli.setBounds(65,160,100,150);
        cli.setForeground(ColorFuente);
        cli.setFont(fuenteCamposLabel);
        cli.addMouseListener(new eventoMouse());
        
        producto=new JLabel(new ImageIcon("src/imagenes/producto.png"));
        producto.setBounds(195,70,100,150);
        producto.addMouseListener(new eventoMouse());
        
        pro=new JLabel("PRODUCTOS");
        pro.setBounds(195,160,120,150);
        pro.setForeground(ColorFuente);
        pro.setFont(fuenteCamposLabel);
        pro.addMouseListener(new eventoMouse());
        
        venta=new JLabel(new ImageIcon("src/imagenes/venta.png"));
        venta.setBounds(335,70,100,150);
        venta.addMouseListener(new eventoMouse());
        
        ven=new JLabel("VENTAS");
        ven.setBounds(355,160,100,150);
        ven.setForeground(ColorFuente);
        ven.setFont(fuenteCamposLabel);
        ven.addMouseListener(new eventoMouse());
        
        detalle=new JLabel(new ImageIcon("src/imagenes/detalle.png"));
        detalle.setBounds(485,70,100,150);
        detalle.addMouseListener(new eventoMouse());
        
        det=new JLabel("DETALLE VENTAS");
        det.setBounds(465,160,180,150);
        det.setForeground(ColorFuente);
        det.setFont(fuenteCamposLabel);
        det.addMouseListener(new eventoMouse());
        
        btnAtras=new JButton(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.setBounds(10,260,30,20);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        btnAtras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaProcesos ventana=new VentanaProcesos();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        lamina.add(cliente);
        lamina.add(cli);
        lamina.add(titulo);
        lamina.add(producto);
        lamina.add(pro);
        lamina.add(venta);
        lamina.add(ven);
        lamina.add(btnAtras);
        lamina.add(detalle);
        lamina.add(det);
        
        add(lamina);
    }
    
    public class eventoMouse extends MouseAdapter{
        
        public void mouseClicked(MouseEvent e){
            
            if(e.getSource()==cliente || e.getSource()==cli){
                
                dispose();
                VentanaConsultaClientes ventana=new VentanaConsultaClientes();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
            if(e.getSource()==producto || e.getSource()==pro){
                
                dispose();
                VentanaConsultaProductos ventana=new VentanaConsultaProductos();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
            if(e.getSource()==venta || e.getSource()==ven){
                
                dispose();
                VentanaConsultaVentas ventana=new VentanaConsultaVentas();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
            if(e.getSource()==detalle || e.getSource()==det){
                
                dispose();
                VentanaConsultaDetalleVentas ventana=new VentanaConsultaDetalleVentas();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
