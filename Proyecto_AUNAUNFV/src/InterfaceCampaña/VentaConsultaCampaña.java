
package InterfaceCampaña;

import DAO.CampañaDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
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
    private JButton btnAtras,btnFiltro;
    private JLabel retornar;
    private String condicionJoin; //2
    private String condicionConcatenada; //3
    //Consulta cabecera con/sin top //1
    //Consulta con group by / order by //4 
    private ResultSet tablaSet;
    
    public VentaConsultaCampaña(ArrayList<String> listaTablas,ArrayList<String> listaCampos){
        setTitle("Ventana Consulta Campañas");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,tamañoPantalla.height/2);
        setResizable(false);
        setLocationRelativeTo(null);
        this.listaTablas=listaTablas;
        this.listaCampos=listaCampos;
        setearConsultaJoin();
        Inicio();  
    }
    
    private void setearConsultaJoin(){
        
        CampañaDAO dao=new CampañaDAO();
        setCondicionJoin(dao.getConsultaJoin(listaTablas, listaCampos));
    }
    
    private void Inicio(){
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 18);
        
        btnFiltro=new JButton("Filtro");
        btnFiltro.setBounds(670, 30, 100, 30);
        btnFiltro.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnFiltro));
        btnFiltro.setFont(fuenteCamposLabel);
        btnFiltro.setForeground(ColorFuente);
        btnFiltro.setBackground(null);
        btnFiltro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
 
                enviarFiltro();
            }
        });
        
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
        
        String ruta="/imagenes/retornar.png";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        retornar=new JLabel(icono);
        retornar.setBounds(780, 30, 30, 30);
        retornar.addMouseListener(new AccionMouse());
        
        
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
        lamina.add(btnFiltro);
        lamina.add(retornar);
        lamina.add(btnAtras);
        lamina.add(scroll);
        add(lamina);
        
    }
    
    public void enviarFiltro(){
        VentanaConsultaCondicional ventana=new VentanaConsultaCondicional(this,listaTablas,listaCampos);
        ventana.setVisible(true);
    }

    public ResultSet getTablaSet() {
        return tablaSet;
    }

    public void setTablaSet(ResultSet tablaSet) {
        this.tablaSet = tablaSet;
    }

    public String getCondicionJoin() {
        return condicionJoin;
    }

    public void setCondicionJoin(String condicionJoin) {
        this.condicionJoin = condicionJoin;
    }
    
    public String getCondicionConcatenada() {
        return condicionConcatenada;
    }

    public void setCondicionConcatenada(String condicionConcatenada) {
        this.condicionConcatenada = condicionConcatenada;
    }
    
    public void concatenarCondicionConcatenada(String condicionConcatenada) {
        this.condicionConcatenada += condicionConcatenada;
    }
    
    private void llenarTabla(){
        
        CampañaDAO dao=new CampañaDAO();
        tablaSet=dao.getListaCampaña(listaTablas, listaCampos);
        String[] arreglo;
        
        try {
            while(tablaSet.next()){
                
                arreglo=new String[listaCampos.size()];
                
                for(int i=0;i<listaCampos.size();i++){
                    arreglo[i]=tablaSet.getString(i+1);
                }
                
                modelo.addRow(arreglo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaConsultaCampaña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarTablaFiltro(String condicional){
        
        CampañaDAO dao=new CampañaDAO();
        tablaSet=dao.getListaCampañaFiltro(listaTablas, listaCampos,condicional);
        String[] arreglo;
        limpiarTabla();
        try {
            while(tablaSet.next()){
                
                arreglo=new String[listaCampos.size()];
                
                for(int i=0;i<listaCampos.size();i++){
                    arreglo[i]=tablaSet.getString(i+1);
                }
                
                modelo.addRow(arreglo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaConsultaCampaña.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++)
        {
            modelo.removeRow(i);
            i--;
        }
    }
    
    private class AccionMouse extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==retornar)
            {   
                limpiarTabla();
                llenarTabla();
                setCondicionConcatenada(null);
                System.out.println("Condicional " + getCondicionConcatenada());
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
