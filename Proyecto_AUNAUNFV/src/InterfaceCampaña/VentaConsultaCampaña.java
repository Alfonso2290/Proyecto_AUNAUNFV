
package InterfaceCampaña;

import DAO.CampañaDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class VentaConsultaCampaña extends JFrame{
    
    private ArrayList<String> listaTablas,listaCampos;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JPanel lamina;
    private JButton btnAtras;
    
    public VentaConsultaCampaña(ArrayList<String> listaTablas,ArrayList<String> listaCampos){
        setTitle("Ventana Consulta Campañas");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,tamañoPantalla.height/2);
        setResizable(false);
        setLocationRelativeTo(null);
        this.listaTablas=listaTablas;
        this.listaCampos=listaCampos;
        Inicio();  
    }
    
    private void Inicio(){
        
        lamina=new JPanel();
        
        modelo=new DefaultTableModel();
        tabla= new JTable();
        scroll=new JScrollPane();
        
        tabla.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(255, 255, 255)));
        tabla.setOpaque(true);
        tabla.setBackground( new Color(65,65,65) );
        tabla.setToolTipText("Tabla Seguimiento");
        tabla.setForeground(Color.white);
        tabla.setEnabled(false);
        scroll.setViewportView(tabla);
        scroll.setBounds(10,80,800,250);
        
        
        for(String cabecera: listaCampos){
            modelo.addColumn(cabecera);
        }
        
        tabla.setModel(modelo);
        
        lamina.setBackground(Color.LIGHT_GRAY.brighter());
        lamina.setLayout(null);
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 18);
        btnAtras=new JButton(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.setBounds(10,333,30,20);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        btnAtras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaCampaña ventana=new VentanaCampaña();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        llenarTabla();
        lamina.add(btnAtras);
        lamina.add(scroll);
        add(lamina);
        
    }
    
    private void llenarTabla(){
        
        CampañaDAO dao=new CampañaDAO();
        ResultSet tabla=dao.getListaCampaña(listaTablas, listaCampos);
        String[] arreglo;
        
        try {
            while(tabla.next()){
                
                arreglo=new String[listaCampos.size()];
                
                for(int i=0;i<listaCampos.size();i++){
                    arreglo[i]=tabla.getString(i+1);
                }
                
                modelo.addRow(arreglo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaConsultaCampaña.class.getName()).log(Level.SEVERE, null, ex);
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
