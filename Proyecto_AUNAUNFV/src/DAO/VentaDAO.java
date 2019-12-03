
package DAO;

import java.sql.*;
import java.util.*;
import UTIL.ConexionBD;
import BEAN.VentaBEAN;
import javax.swing.JOptionPane;

public class VentaDAO {

    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList<VentaBEAN> lista;
    private CallableStatement procedimiento=null;
    
    public ArrayList<VentaBEAN> getListaVentas(){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> getListaDNIVentas(){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT DISTINCT DNI FROM VENTA ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setDni(tabla.getString(1));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroDNI(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ven.getDni());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroFechaInicio(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE FECHA=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ven.getFechaInicio());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroFechaFinal(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE FECHA<=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ven.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroDNIFechaInicio(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE DNI=? AND FECHA=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ven.getDni());
            instruccion.setString(2,ven.getFechaInicio());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroDNIFechaFinal(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE DNI=? AND FECHA<=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ven.getDni());
            instruccion.setString(2,ven.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroFechaInicioFechaFinal(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE FECHA BETWEEN ? AND ?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,ven.getFechaInicio());
            instruccion.setString(2,ven.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public ArrayList<VentaBEAN> listarVentasFiltroDNIFechaInicioFechaFinal(VentaBEAN ven){
        
        try{
            conexion=new ConexionBD();
            sql="SELECT * FROM VENTA WHERE DNI=? AND FECHA BETWEEN ? AND ?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, ven.getDni());
            instruccion.setString(2,ven.getFechaInicio());
            instruccion.setString(3,ven.getFechaFinal());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<VentaBEAN>();
            
            while(tabla.next()){
                VentaBEAN venta=new VentaBEAN();
                venta.setNumTicket(tabla.getString(1));
                venta.setDni(tabla.getString(2));
                venta.setFecha(tabla.getString(3));
                venta.setMontoTotal(tabla.getDouble(4));
                venta.setIgv(tabla.getDouble(5));
                venta.setMontoNeto(tabla.getDouble(6));
                venta.setEstado(tabla.getString(7));
                
                lista.add(venta);
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    public void eliminarVenta(VentaBEAN venta){

        try{
            conexion=new ConexionBD();
            sql="DELETE FROM VENTA WHERE NUM_TICKET=? ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, venta.getNumTicket());
            instruccion.executeUpdate();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!!..No se pudo eliminar el registro de la venta");
        }
    }
    
    public int verificarNumeroTicket(VentaBEAN venta)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM VENTA  ";
            sql+="WHERE NUM_TICKET=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, venta.getNumTicket());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
    
    public String getFechaRegistroActual()
    {
        String fecha="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT GETDATE() ";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                fecha=tabla.getString(1);
            
        } 
        catch (Exception e) {
        }
        
        return fecha;
    }
    
    public void registrarVenta(VentaBEAN venta){
        
        try{
            conexion=new ConexionBD();
            sql="INSERT INTO VENTA VALUES(?,?,?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, venta.getNumTicket());
            instruccion.setString(2, venta.getDni());
            instruccion.setString(3, venta.getFecha());
            instruccion.setDouble(4, venta.getMontoTotal());
            instruccion.setDouble(5, venta.getIgv());
            instruccion.setDouble(6, venta.getMontoNeto());
            instruccion.setString(7,"CANCELADO");
            instruccion.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado la venta exitosamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!!..No se pudo registrar la venta");
        }
        
    }
    
    public String generarCodigo()
    {
        String codigo="V000000001",temp;
        long temp2;
        try
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(NUM_TICKET) FROM VENTA";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();

            if(tabla.next())
            {
                temp=tabla.getString(1);
                temp2=Integer.parseInt(temp.charAt(1) + "" + temp.charAt(2) + "" + temp.charAt(3)+ "" + temp.charAt(4) + "" +
                        temp.charAt(5) + ""  + temp.charAt(6) + "" +  temp.charAt(7) + "" +  temp.charAt(8) + "" + temp.charAt(9) );
                temp2++;
                if(temp2<10)
                    codigo="V00000000" + temp2 + "";
                else if(temp2<100)
                    codigo="V0000000" + temp2 + "";
                else if(temp2<1000)
                    codigo="V000000" + temp2 + "";
                else if(temp2<10000)
                    codigo="V00000" + temp2 + "";
                else if(temp2<100000)
                    codigo="V0000" + temp2 + "";
                else if(temp2<1000000)
                    codigo="V000" + temp2 + "";
                else if(temp2<10000000)
                    codigo="V00" + temp2 + "";
                else if(temp2<100000000)
                    codigo="V0" + temp2 + "";
                else if(temp2<1000000000)
                    codigo="V" + temp2 + "";
            }

        }
        catch (Exception e)
        { }

        return codigo;
    }
    
    
    
    
}


