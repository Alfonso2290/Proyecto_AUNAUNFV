
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
    
    private ArrayList<String> listaTablas,listaCampos,listaEmails;
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JPanel lamina;
    private JButton btnAtras,btnFiltro,btnTop,btnEnvioMailing;
    private JLabel retornar;
    private String condicionJoin; //2
    private String condicionConcatenada; //3
    private String condicionTop;
    private String condicionBot;
    //Consulta cabecera con/sin top //1
    //Consulta con group by / order by //4 
    private ResultSet tablaSet;
    private String nombreCampaña;
    
    public VentaConsultaCampaña(ArrayList<String> listaTablas,ArrayList<String> listaCampos,String nombreCampaña){
        this.nombreCampaña=nombreCampaña;
        setTitle("Ventana Consulta Campañas");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,tamañoPantalla.height/2+35);
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
        
        btnTop=new JButton("Top");
        btnTop.setBounds(540, 30, 100, 30);
        btnTop.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnTop));
        btnTop.setFont(fuenteCamposLabel);
        btnTop.setForeground(ColorFuente);
        btnTop.setBackground(null);
        btnTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
 
                enviarTop();
            }
        });
        
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
        btnAtras.setBounds(10,333+30,30,20);
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
        
        btnEnvioMailing=new JButton("Enviar Mailing");
        btnEnvioMailing.setBounds(620, 350, 180, 30);
        btnEnvioMailing.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnEnvioMailing));
        btnEnvioMailing.setFont(fuenteCamposLabel);
        btnEnvioMailing.setForeground(ColorFuente);
        btnEnvioMailing.setBackground(null);
        btnEnvioMailing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                envioEmail();
            }
        });
        
        llenarTabla();
        lamina.add(btnTop);
        lamina.add(btnFiltro);
        lamina.add(retornar);
        lamina.add(btnAtras);
        lamina.add(btnEnvioMailing);
        lamina.add(scroll);
        add(lamina);
        
    }
    
    public void enviarFiltro(){
        VentanaConsultaCondicional ventana=new VentanaConsultaCondicional(this,listaTablas,listaCampos);
        ventana.setVisible(true);
    }
    
    public void enviarTop(){
        VentanaConsultaTop ventana=new VentanaConsultaTop(this,listaTablas,listaCampos);
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

    public String getCondicionTop() {
        return condicionTop;
    }

    public void setCondicionTop(String condicionTop) {
        this.condicionTop = condicionTop;
    }
    
    public String getCondicionBot() {
        return condicionBot;
    }

    public void setCondicionBot(String condicionBot) {
        this.condicionBot = condicionBot;
    }
    
    public void envioEmail(){
        
        String cTop="",cJoin,cWhere,cBot;
        
        if(condicionTop==null){
            cTop=" ";
        }else{
            String aux=condicionTop;
            
            for(int i=0;i<aux.length();i++){
                
                if(i>=7)
                    cTop+=aux.charAt(i);
                
            }
            
        }
        
        if(condicionConcatenada==null)
            cWhere=" ";
        else
            cWhere=condicionConcatenada;
        
        if(condicionBot==null)
            cBot=" ";
        else
            cBot=condicionBot;
        
//        if(condicionTop==null)
//            cJoin="SELECT " + condicionJoin;
//        else
        cJoin=condicionJoin;
        
        String consultaTotal=cTop + " " + cJoin + " " + cWhere + " " + cBot;
        
        System.out.println(consultaTotal);
        
        // con la consulta total crear el procedimiento almacenado que cree la funcion
        //CampañaDAO dao=new CampañaDAO();
        //dao.procCreacionDeFuncion(consultaTotal);
        if(verificarCampoEmail()){
            
            capturarEmails();
            System.out.println(listaEmails);
            VentanaEnvioEmail ventana=new VentanaEnvioEmail(listaEmails,nombreCampaña);
            ventana.setVisible(true);
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Ud. debe seleccionar el campo 'EMAIL' para enviar los emails");
        }
        
        // crear formulario para llenar campos (del mensaje) y llamar procedimiento almacenado
    }
    
    
    private void capturarEmails(){
        
        listaEmails=new ArrayList<>();
        
        for(int i=0;i<tabla.getRowCount();i++){
            
            for(int j=0;j<tabla.getColumnCount();j++){
                
                if(modelo.getColumnName(j).equals("PERSONA.EMAIL")){
                    
                    String campo=modelo.getValueAt(i, j).toString();
                    if(verificarDuplicidadLista(campo)==false)
                        listaEmails.add(campo);
                }
            }
        }
        
        
    }
    
    private boolean verificarDuplicidadLista(String prueba){
        boolean b=false;
        
        for(String s:listaEmails){
            if(prueba.equals(s))
                b=true;
        }
        
        
        return b;
        
    }
    
    
    private boolean verificarCampoEmail(){
        boolean b=false;
        
        for(String campo: listaCampos){
            
            if(campo.equals("PERSONA.EMAIL"))
                b=true;
            
        }
        
        return b;
        
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
    
    public void llenarTablaFiltroTop(String condicionalTop,String condicionalBot){
        
        CampañaDAO dao=new CampañaDAO();
        tablaSet=dao.getListaCampañaFiltroTop(condicionalTop,condicionJoin,condicionConcatenada,condicionalBot);
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
                setCondicionTop(null);
                setCondicionBot(null);
                /*System.out.println("Condicional: " + getCondicionTop() + "\n"+
                                                   getCondicionJoin() + "\n"
                                                    + getCondicionConcatenada() + "\n" 
                                                    + getCondicionBot());*/
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
