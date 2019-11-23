
package DAO;

import java.sql.*;
import java.util.*;
import UTIL.ConexionBD;
import BEAN.Mailing;
import javax.swing.JOptionPane;

public class MailingDAO {

    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList<Mailing> lista;
    private CallableStatement procedimiento=null;
    
    public ArrayList<Mailing> getListaMailing(){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_TOP_CLIENTES_PRODUCTOS_CONSUMIDOS('01-01-2019','31-12-2019')";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<Mailing>();
            
            while(tabla.next()){
                Mailing mai=new Mailing();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setNomProducto(tabla.getString(3));
                mai.setEmail(tabla.getString(4));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<Mailing> getListaMailingFiltroFechaInicio(Mailing ma){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_TOP_CLIENTES_PRODUCTOS_CONSUMIDOS(?,'31-12-2019')";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ma.getFechaInicio());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<Mailing>();
            
            while(tabla.next()){
                Mailing mai=new Mailing();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setNomProducto(tabla.getString(3));
                mai.setEmail(tabla.getString(4));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<Mailing> getListaMailingFiltroFechaFinal(Mailing ma){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_TOP_CLIENTES_PRODUCTOS_CONSUMIDOS('01-01-19',?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ma.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<Mailing>();
            
            while(tabla.next()){
                Mailing mai=new Mailing();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setNomProducto(tabla.getString(3));
                mai.setEmail(tabla.getString(4));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<Mailing> getListaMailingFiltroFechaInicioFechaFinal(Mailing ma){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM DBO.TABLA_TOP_CLIENTES_PRODUCTOS_CONSUMIDOS(?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ma.getFechaInicio());
            instruccion.setString(2,ma.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<Mailing>();
            
            while(tabla.next()){
                Mailing mai=new Mailing();
                mai.setDni(tabla.getString(1));
                mai.setNombre(tabla.getString(2));
                mai.setNomProducto(tabla.getString(3));
                mai.setEmail(tabla.getString(4));
                
                lista.add(mai);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public void procMailingTop10ClientesConProductoMasConsumido(String fechaInicial,String fechaFinal){
        
        try {
            
            conexion=new ConexionBD();
            sql="{CALL envio_email(?,?,?,?)}";
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
