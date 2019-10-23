package DAO;

import java.sql.*;
import java.util.*;
import UTIL.ConexionBD;
import BEAN.ClienteBEAN;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList<ClienteBEAN> lista;
    
    public ArrayList<ClienteBEAN> getListaClientes(){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT P.*  ";
            sql+="FROM PERSONA P INNER JOIN CLIENTE C ";
            sql+="ON P.DNI=C.DNI ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ClienteBEAN>();
            
            while(tabla.next()){
                ClienteBEAN cliente=new ClienteBEAN();
                cliente.setDni(tabla.getString(1));
                cliente.setNombre(tabla.getString(2));
                cliente.setFechaNacimiento(tabla.getString(3));
                cliente.setCelular(tabla.getString(4));
                cliente.setEmail(tabla.getString(5));
                
                lista.add(cliente);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<ClienteBEAN> getListaNombreClientes(){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT DISTINCT P.NOMBRE  ";
            sql+="FROM PERSONA P INNER JOIN CLIENTE C ";
            sql+="ON P.DNI=C.DNI ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ClienteBEAN>();
            
            while(tabla.next()){
                ClienteBEAN cliente=new ClienteBEAN();
                cliente.setNombre(tabla.getString(1));
                
                lista.add(cliente);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<ClienteBEAN> listarContactosFiltroNombres(ClienteBEAN cliente){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT P.*  ";
            sql+="FROM PERSONA P INNER JOIN CLIENTE C ";
            sql+="ON P.DNI=C.DNI ";
            sql+="WHERE P.NOMBRE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,cliente.getNombre());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ClienteBEAN>();
            
            while(tabla.next()){
                ClienteBEAN clie=new ClienteBEAN();
                clie.setDni(tabla.getString(1));
                clie.setNombre(tabla.getString(2));
                clie.setFechaNacimiento(tabla.getString(3));
                clie.setCelular(tabla.getString(4));
                clie.setEmail(tabla.getString(5));
                
                lista.add(clie);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public int verificarCliente(ClienteBEAN cliente)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM CLIENTE  ";
            sql+="WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, cliente.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
    
    public int registrarCliente(ClienteBEAN cliente){
        int i=0;
        try{
            conexion=new ConexionBD();
            sql="INSERT INTO CLIENTE VALUES(?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, cliente.getDni());
            
            i=instruccion.executeUpdate();
            
            
        }catch(Exception e){}
        
        return i;
    }
    
    public void eliminarCliente(ClienteBEAN cliente){

        try{
            conexion=new ConexionBD();
            sql="DELETE FROM CLIENTE WHERE DNI=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, cliente.getDni());
            instruccion.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!!..No se pudo eliminar el registro del cliente");
        }
    }
    
    
    
    public int verificarDniVenta(ClienteBEAN cliente)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM CLIENTE  ";
            sql+="WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, cliente.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
}
