
package DAO;

import BEAN.EmpleadoBEAN;
import BEAN.UsuarioBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <UsuarioBEAN> lista=null;
    
    public int verificarCuentaDeUsuario(UsuarioBEAN usu)
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT NOMBRE,CONTRASEÑA FROM USUARIO WHERE NOMBRE=? AND CONTRASEÑA =?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,usu.getNombre());
            instruccion.setString(2,usu.getClave());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                cont++;
            
            tabla.close();
            instruccion.close();
            
            
        }catch (Exception e) {}
        
        return cont;
    }
    
    public String getTipoUsuario(UsuarioBEAN usuario)
    {
        String tipo="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT TIPO FROM USUARIO ";
            sql+="WHERE NOMBRE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getNombre());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                tipo=tabla.getString(1);
            
        } 
        catch (Exception e) {
        }
        
        return tipo;
    }
    
    public void registrarUsuario(UsuarioBEAN usuario){
        
        try{
            conexion=new ConexionBD();
            sql="INSERT INTO USUARIO(DNI,NOMBRE,CONTRASEÑA,TIPO) VALUES(?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getDni());
            instruccion.setString(2, usuario.getNombre());
            instruccion.setString(3, usuario.getClave());
            instruccion.setString(4, usuario.getTipo());
            instruccion.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado al usuario exitosamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!!..No se pudo registrar al usuario");
        }
        
    }
    
    public int verificarNombreUsuario(String nombreUsuario){
        
        int i=0;
        try {
            
            conexion=new ConexionBD();
            sql="SELECT COUNT(NOMBRE) FROM USUARIO WHERE NOMBRE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, nombreUsuario);
            tabla=instruccion.executeQuery();
            
            if(tabla.next()){
                i=tabla.getInt(1);
            }
            
        } catch (Exception e) {
        }
        
        return i;
        
    }
    
    public int verificarUsuario(UsuarioBEAN usu)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM USUARIO  ";
            sql+="WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usu.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
    
    public int verificarDNIUsuario(UsuarioBEAN usu)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM PERSONA  ";
            sql+="WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usu.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
}
