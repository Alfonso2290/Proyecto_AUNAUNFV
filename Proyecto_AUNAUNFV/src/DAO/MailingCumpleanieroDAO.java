
package DAO;

import java.sql.*;
import java.util.*;
import UTIL.ConexionBD;
import BEAN.MailingCumpleaniero;
import javax.swing.JOptionPane;

public class MailingCumpleanieroDAO {

    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList<MailingCumpleaniero> lista;
    private CallableStatement procedimiento=null;
    
    public ArrayList<MailingCumpleaniero> getListaMailing(){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_CUMPLEAÑEROS('01-01-2019','31-12-2019')";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<MailingCumpleaniero>();
            
            while(tabla.next()){
                MailingCumpleaniero mai=new MailingCumpleaniero();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setFechaNacimiento(tabla.getString(3));
                mai.setCelular(tabla.getString(4));
                mai.setEmail(tabla.getString(5));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<MailingCumpleaniero> getListaMailingFiltroFechaInicio(MailingCumpleaniero ma){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_CUMPLEAÑEROS(?,'31-12-2019')";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ma.getFechaInicio());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<MailingCumpleaniero>();
            
            while(tabla.next()){
                MailingCumpleaniero mai=new MailingCumpleaniero();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setFechaNacimiento(tabla.getString(3));
                mai.setCelular(tabla.getString(4));
                mai.setEmail(tabla.getString(5));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<MailingCumpleaniero> getListaMailingFiltroFechaFinal(MailingCumpleaniero ma){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_CUMPLEAÑEROS('01-01-19',?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ma.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<MailingCumpleaniero>();
            
            while(tabla.next()){
                MailingCumpleaniero mai=new MailingCumpleaniero();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setFechaNacimiento(tabla.getString(3));
                mai.setCelular(tabla.getString(4));
                mai.setEmail(tabla.getString(5));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<MailingCumpleaniero> getListaMailingFiltroFechaInicioFechaFinal(MailingCumpleaniero ma){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_CUMPLEAÑEROS(?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ma.getFechaInicio());
            instruccion.setString(2,ma.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<MailingCumpleaniero>();
            
            while(tabla.next()){
                MailingCumpleaniero mai=new MailingCumpleaniero();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setFechaNacimiento(tabla.getString(3));
                mai.setCelular(tabla.getString(4));
                mai.setEmail(tabla.getString(5));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public void procMailingCumpleaniero(String fechaInicial,String fechaFinal){
        
        try {
            
            conexion=new ConexionBD();
            sql="{CALL envio_email_Cumpleaniero(?,?,?,?)}";
            procedimiento=conexion.getConexionBD().prepareCall(sql);
            procedimiento.setString(1, fechaInicial);
            procedimiento.setString(2, fechaFinal);
            procedimiento.setString(3,"Enviar Correos AunaUNFV.Anexo07");
            procedimiento.setString(4,"Felicidades por ser cliente fiel");
            procedimiento.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Envío de email satisfactoriamente");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Envío de email erroneo");
        }
        
    }
    
    
}
