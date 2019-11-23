
package InterfaceMailing;

import BEAN.Mailing;
import BEAN.MailingCumpleaniero;
import DAO.MailingCumpleanieroDAO;
import DAO.MailingDAO;
import UtilidadesMailingCumpleaniero.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class PanelMailingCumpleanios extends JPanel
{
    private ModeloTablaCumpleaniero modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnAtras,btnEnvioMailing;
    private JButton btnBuscar;
    private JLabel retornar,fechaI,fechaF;
    private ArrayList<MailingCumpleaniero> lista;
    private JLabel mensaje,titulo;
    private int filasTabla;
    private int columnasTabla;
    private JDateChooser fechaInicio,fechaFinal;
    
    public PanelMailingCumpleanios()
    {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        Inicio();
    }

    private void Inicio()
    {
        setLayout(null);
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        
        titulo=new JLabel("CLIENTES CUMPLEAÑEROS");
        titulo.setBounds(270,80,800,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        fechaI=new JLabel("F. Inicio");
        fechaI.setBounds(200, 140, 80, 30);
        fechaI.setFont(fuenteCamposLabel);
        fechaI.setForeground(ColorFuente);
        
        fechaInicio=new JDateChooser();
        fechaInicio.setBounds(300, 140, 100, 30);
        
        fechaF=new JLabel("F. Final");
        fechaF.setBounds(460, 140, 80, 30);
        fechaF.setFont(fuenteCamposLabel);
        fechaF.setForeground(ColorFuente);
        
        fechaFinal=new JDateChooser();
        fechaFinal.setBounds(540, 140, 100, 30);
        
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(670, 140, 100, 30);
        btnBuscar.addActionListener(new filtrar());
        btnBuscar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnBuscar));
        btnBuscar.setFont(fuenteCamposLabel);
        btnBuscar.setForeground(ColorFuente);
        btnBuscar.setBackground(null);
        
        String ruta="/imagenes/retornar.png";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        retornar=new JLabel(icono);
        retornar.setBounds(780, 140, 30, 30);
        retornar.addMouseListener(new AccionMouse());
        
        scroll=new JScrollPane();
        tabla=new JTable();
        tabla.setBackground(Color.WHITE);
        tabla.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        tabla.setOpaque(false);
        scroll.setViewportView(tabla);
        
        mensaje=new JLabel();
        mensaje.setBounds(220,270,350,50);
        mensaje.setFont(new Font("Arial",Font.BOLD,18));
        mensaje.setForeground(Color.RED);
        
        capturarListaTabla();
        
        if(lista.size()!=0)
        {
            construirTabla();

            scroll.setBounds(10,190,800,200);
            
            mensaje.setText("");
            
            add(fechaInicio);
            add(fechaFinal);
            add(fechaI);
            add(fechaF);
            add(btnBuscar);
            add(retornar);
            add(titulo);
            add(scroll);
        }
        else
        {
            mensaje.setText("<< No tienes clientes actualmente >>");
        }
        
        add(mensaje);
        
        btnAtras=new JButton(new ImageIcon("src/imagenes/atras.png"));
        btnAtras.setBounds(10,423,30,20);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.setFont(fuenteCamposLabel);
        
        btnEnvioMailing=new JButton("Enviar Mailing");
        btnEnvioMailing.setBounds(630, 410, 150, 30);
        btnEnvioMailing.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnEnvioMailing));
        btnEnvioMailing.setFont(fuenteCamposLabel);
        btnEnvioMailing.setForeground(ColorFuente);
        btnEnvioMailing.setBackground(null);
        btnEnvioMailing.addActionListener(new EnvioEmail());
        
        add(btnAtras);
        add(btnEnvioMailing);
    }
    
    
    private void capturarListaTabla()
    {
        MailingCumpleanieroDAO clienteDAO=new MailingCumpleanieroDAO();
        lista=clienteDAO.getListaMailing();
    }
    
    private class filtrar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            MailingCumpleaniero mai=new MailingCumpleaniero();
            
            if(fechaInicio.getCalendar()!=null){
                int diaI=fechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                int mesI=fechaInicio.getCalendar().get(Calendar.MONTH) + 1;
                int añoI=fechaInicio.getCalendar().get(Calendar.YEAR);
                String fechaInicioFiltro=diaI + "-" + mesI + "-" + añoI;
                mai.setFechaInicio(fechaInicioFiltro);
            }
            
            if(fechaFinal.getCalendar()!=null){
                int diaF=fechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);
                int mesF=fechaFinal.getCalendar().get(Calendar.MONTH) + 1;
                int añoF=fechaFinal.getCalendar().get(Calendar.YEAR);
                String fechaFinalFiltro=diaF + "-" + mesF + "-" + añoF;
                mai.setFechaFinal(fechaFinalFiltro);
            }
            
            MailingCumpleanieroDAO dao=new MailingCumpleanieroDAO();
            
            if(e.getSource()==btnBuscar)
            {
                if(fechaInicio.getCalendar()!=null && fechaFinal.getCalendar()==null){
                    
                    lista=dao.getListaMailingFiltroFechaInicio(mai);
                    llenarTabla("");
                    
                }else if(fechaInicio.getCalendar()==null && fechaFinal.getCalendar()!=null){
                    
                    lista=dao.getListaMailingFiltroFechaFinal(mai);
                    llenarTabla("");
                    
                }else if(fechaInicio.getCalendar()!=null && fechaFinal.getCalendar()!=null){
                    
                    lista=dao.getListaMailingFiltroFechaInicioFechaFinal(mai);
                    llenarTabla("");
                }else
                {
                    lista=dao.getListaMailing();
                    llenarTabla("");
                    //JOptionPane.showMessageDialog(null, "Para realizar un filtro Usted debe seleccionar un Nombre y/o Distrito");
                }
                
            }
        }
    }
    
    private void llenarTabla(String msj)
    {
        if(lista.size()!=0)
        {
            scroll.setVisible(true);
            limpiarTabla();
            construirTabla();
            mensaje.setBounds(250,150,350,50);
            mensaje.setText("");
        }
        else
        {
            scroll.setVisible(false);
            mensaje.setBounds(270,250,470,50);
            mensaje.setText("<< No se encontraron filtros >>");
        }
    }
    
    private class AccionMouse extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==retornar)
            {   
                capturarListaTabla();
                llenarTabla("");
            }
        }
    }
    
    public JButton getBtnAtras() {
        return btnAtras;
    }

    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++)
        {
            modelo.removeRow(i);
            i--;
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
    
    private void construirTabla() {
        
        ArrayList<String> titulosList=new ArrayList<>();

        titulosList.add("DNI");
        titulosList.add("Nombre");
        titulosList.add("Fecha Nacimiento");
        titulosList.add("Teléfono");
        titulosList.add("Email");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i]=titulosList.get(i);
        }
    
        Object[][] data =obtenerMatrizDatos(titulosList);
        construirTabla(titulos,data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[lista.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadesCumpleaniero.DNI] = lista.get(x).getDni()+ "";
            informacion[x][UtilidadesCumpleaniero.NOMBRE] = lista.get(x).getNombre()+ "";
            informacion[x][UtilidadesCumpleaniero.FECHA] = lista.get(x).getFechaNacimiento()+ "";
            informacion[x][UtilidadesCumpleaniero.TELEFONO] = lista.get(x).getCelular()+ "";
            informacion[x][UtilidadesCumpleaniero.EMAIL] = lista.get(x).getEmail()+ "";
        }

        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
      
        modelo=new ModeloTablaCumpleaniero(data, titulos);
        tabla.setModel(modelo);
        
        filasTabla=tabla.getRowCount();
        columnasTabla=tabla.getColumnCount();
     
        for (int i = 0; i < titulos.length; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldasCumpleniero("texto"));
        }

        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setRowHeight(25);
        tabla.setGridColor(new java.awt.Color(0, 0, 0)); 
        
        tabla.getColumnModel().getColumn(UtilidadesCumpleaniero.DNI).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(UtilidadesCumpleaniero.NOMBRE).setPreferredWidth(350);
        tabla.getColumnModel().getColumn(UtilidadesCumpleaniero.FECHA).setPreferredWidth(160);
        tabla.getColumnModel().getColumn(UtilidadesCumpleaniero.TELEFONO).setPreferredWidth(130);
        tabla.getColumnModel().getColumn(UtilidadesCumpleaniero.EMAIL).setPreferredWidth(350);
        
        JTableHeader jtableHeader = tabla.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTablaCumpleaniero());
        tabla.setTableHeader(jtableHeader);

        scroll.setViewportView(tabla);
     }
    
    
    public class EnvioEmail  implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
            MailingCumpleanieroDAO dao=new MailingCumpleanieroDAO();
            
            MailingCumpleaniero mai=new MailingCumpleaniero();
            
            if(fechaInicio.getCalendar()!=null){
                int diaI=fechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                int mesI=fechaInicio.getCalendar().get(Calendar.MONTH) + 1;
                int añoI=fechaInicio.getCalendar().get(Calendar.YEAR);
                String fechaInicioFiltro=diaI + "-" + mesI + "-" + añoI;
                mai.setFechaInicio(fechaInicioFiltro);
            }
            
            if(fechaFinal.getCalendar()!=null){
                int diaF=fechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);
                int mesF=fechaFinal.getCalendar().get(Calendar.MONTH) + 1;
                int añoF=fechaFinal.getCalendar().get(Calendar.YEAR);
                String fechaFinalFiltro=diaF + "-" + mesF + "-" + añoF;
                mai.setFechaFinal(fechaFinalFiltro);
            }
            
            
            if(e.getSource()==btnEnvioMailing)
            {
                if(fechaInicio.getCalendar()!=null && fechaFinal.getCalendar()==null){
                    
                    dao.procMailingCumpleaniero(mai.getFechaInicio(), "31-12-2019");
                    
                }else if(fechaInicio.getCalendar()==null && fechaFinal.getCalendar()!=null){
                    
                    dao.procMailingCumpleaniero("01-01-2019", mai.getFechaFinal());
                    
                }else if(fechaInicio.getCalendar()!=null && fechaFinal.getCalendar()!=null){
                    
                    dao.procMailingCumpleaniero(mai.getFechaInicio(),mai.getFechaFinal());
                }else
                {
                    dao.procMailingCumpleaniero("01-01-2019", "31-12-2019");
                }
                
            }
            
        }
        
    }
    
}

