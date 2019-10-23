
package DAO;

import java.sql.*;
import java.util.*;
import UTIL.ConexionBD;
import BEAN.ClienteBEAN;
import BEAN.PersonaBEAN;
import javax.swing.JOptionPane;

public class PersonaDAO {
    
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList<PersonaBEAN> lista;
    
    public void registrarPersona(PersonaBEAN persona){
        
        try{
            conexion=new ConexionBD();
            sql="INSERT INTO PERSONA VALUES(?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, persona.getDni());
            instruccion.setString(2, persona.getNombre());
            instruccion.setString(3, persona.getFechaNacimiento());
            instruccion.setString(4, persona.getCelular());
            instruccion.setString(5, persona.getEmail());
            instruccion.executeUpdate();
            
           
        }catch(Exception e){}
        
    }
    
    public int modificarPersona(PersonaBEAN persona){
        int i=0;
        try{
            conexion=new ConexionBD();
            sql="UPDATE PERSONA SET NOMBRE=?,FECHA_NACIMIENTO=?,";
            sql+="CELULAR=?,EMAIL=? ";
            sql+="WHERE DNI=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getFechaNacimiento());
            instruccion.setString(3, persona.getCelular());
            instruccion.setString(4, persona.getEmail());
            instruccion.setString(5, persona.getDni());
            i=instruccion.executeUpdate();
            
        }catch(Exception e){
            
        }
        
        return i;
    }
}
