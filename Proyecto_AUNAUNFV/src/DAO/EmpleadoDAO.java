
package DAO;

import BEAN.EmpleadoBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class EmpleadoDAO {
    
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <EmpleadoBEAN> lista=null;
    
    public String generarCodigoEmpleado()
    {
        String codigo="E0000001",temp;
        long temp2;
        try
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(COD_EMPLEADO) FROM EMPLEADO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();

            if(tabla.next())
            {
                temp=tabla.getString(1);
                temp2=Integer.parseInt(temp.charAt(1) + "" + temp.charAt(2) + "" + temp.charAt(3)+ "" + temp.charAt(4) + "" +
                        temp.charAt(5) + ""  + temp.charAt(6) + "" +  temp.charAt(7) );
                temp2++;
                if(temp2<10)
                    codigo="E000000" + temp2 + "";
                else if(temp2<100)
                    codigo="E00000" + temp2 + "";
                else if(temp2<1000)
                    codigo="E0000" + temp2 + "";
                else if(temp2<10000)
                    codigo="E000" + temp2 + "";
                else if(temp2<100000)
                    codigo="E00" + temp2 + "";
                else if(temp2<1000000)
                    codigo="E0" + temp2 + "";
                else if(temp2<10000000)
                    codigo="E" + temp2 + "";
                    
            }

        }
        catch (Exception e)
        { }

        return codigo;
    }
    
    public void registrarEmpleado(EmpleadoBEAN empleado){
        
        try{
            conexion=new ConexionBD();
            sql="INSERT INTO EMPLEADO VALUES(?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, empleado.getCodigoEmpleado());
            instruccion.setString(2, empleado.getDni());
            instruccion.setString(3, empleado.getCargo());
            instruccion.executeUpdate();
            
        }catch(Exception e){}
        
    }
    
    public int registrarEmpleados(EmpleadoBEAN empleado){
        
        int i=0;
        try{
            conexion=new ConexionBD();
            sql="INSERT INTO EMPLEADO VALUES(?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, empleado.getCodigoEmpleado());
            instruccion.setString(2, empleado.getDni());
            instruccion.setString(3, empleado.getCargo());
            i=instruccion.executeUpdate();
            
        }catch(Exception e){}
        
        return i;
    }
    
    public int verificarEmpleado(EmpleadoBEAN emp)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM EMPLEADO  ";
            sql+="WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, emp.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
    
}
