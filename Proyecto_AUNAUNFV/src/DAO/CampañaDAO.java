/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;
import UTIL.ConexionBD;
import javax.swing.JOptionPane;

public class CampañaDAO {
    
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList<String> lista;
    private CallableStatement procedimiento=null;
    
    public ResultSet getListaCampaña(ArrayList<String> listaTablas, ArrayList<String> listaCampos){
        
        try{
            int cantidadCampos=listaCampos.size();
            conexion=new ConexionBD();
            sql="SELECT ";
            
            for(int i=0;i<listaCampos.size();i++){
                
                if(i==listaCampos.size()-1)
                    sql+=listaCampos.get(i) + " ";
                else
                    sql+=listaCampos.get(i) + ",";
            }
            
            sql+="FROM ";
            
            for(int i=0;i<listaTablas.size();i++){
                
                if(i==0){
                    
                    sql+="PERSONA INNER JOIN CLIENTE ";
                    sql+="ON PERSONA.DNI=CLIENTE.DNI ";
                    
                }else if(i==1){
                    
                    sql+="INNER JOIN VENTA ";
                    sql+="ON CLIENTE.DNI=VENTA.DNI ";
                    
                }else if(i==2){
                    
                    sql+="INNER JOIN DETALLE_VENTA ";
                    sql+="ON VENTA.NUM_TICKET=DETALLE_VENTA.NUM_TICKET ";
                    
                }else if(i==3){
                    
                    sql+="INNER JOIN PRODUCTO ";
                    sql+="ON DETALLE_VENTA.COD_PRODUCTO=PRODUCTO.COD_PRODUCTO ";
                    
                }    
                
            }
            
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tabla;
    }
    
    public ResultSet getListaCampañaFiltro(ArrayList<String> listaTablas, ArrayList<String> listaCampos,String condicional){
        
        try{
            int cantidadCampos=listaCampos.size();
            conexion=new ConexionBD();
            sql="SELECT ";
            
            for(int i=0;i<listaCampos.size();i++){
                
                if(i==listaCampos.size()-1)
                    sql+=listaCampos.get(i) + " ";
                else
                    sql+=listaCampos.get(i) + ",";
            }
            
            sql+="FROM ";
            
            for(int i=0;i<listaTablas.size();i++){
                
                if(i==0){
                    
                    sql+="PERSONA INNER JOIN CLIENTE ";
                    sql+="ON PERSONA.DNI=CLIENTE.DNI ";
                    
                }else if(i==1){
                    
                    sql+="INNER JOIN VENTA ";
                    sql+="ON CLIENTE.DNI=VENTA.DNI ";
                    
                }else if(i==2){
                    
                    sql+="INNER JOIN DETALLE_VENTA ";
                    sql+="ON VENTA.NUM_TICKET=DETALLE_VENTA.NUM_TICKET ";
                    
                }else if(i==3){
                    
                    sql+="INNER JOIN PRODUCTO ";
                    sql+="ON DETALLE_VENTA.COD_PRODUCTO=PRODUCTO.COD_PRODUCTO ";
                    
                }    
                
            }
            
            sql+=" " + condicional + " ";
            
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tabla;
    }
    
    public ResultSet getListaCampañaFiltroTop(String condicionalTop,String condicionalJoin,String condicionalWhere,String condicionalBot){
        
        try{
            
            conexion=new ConexionBD();
            sql=condicionalTop + " ";
            sql+=" " + condicionalJoin + " ";
            if(condicionalWhere==null)
                sql+=" ";
            else
                sql+=" " + condicionalWhere + " ";
            sql+=" " + condicionalBot + " ";
            
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tabla;
    }
    
    public String getConsultaJoin(ArrayList<String> listaTablas, ArrayList<String> listaCampos){
        
        sql="";
            
        for(int i=0;i<listaCampos.size();i++){

            if(i==listaCampos.size()-1)
                sql+=listaCampos.get(i) + " ";
            else
                sql+=listaCampos.get(i) + ",";
        }

        sql+="FROM ";

        for(int i=0;i<listaTablas.size();i++){

            if(i==0){

                sql+="PERSONA INNER JOIN CLIENTE ";
                sql+="ON PERSONA.DNI=CLIENTE.DNI ";

            }else if(i==1){

                sql+="INNER JOIN VENTA ";
                sql+="ON CLIENTE.DNI=VENTA.DNI ";

            }else if(i==2){

                sql+="INNER JOIN DETALLE_VENTA ";
                sql+="ON VENTA.NUM_TICKET=DETALLE_VENTA.NUM_TICKET ";

            }else if(i==3){

                sql+="INNER JOIN PRODUCTO ";
                sql+="ON DETALLE_VENTA.COD_PRODUCTO=PRODUCTO.COD_PRODUCTO ";

            }    

        }
        
        return sql;
    }
    
    public void procCreacionDeFuncion(String consulta){
        
        try {
            
            conexion=new ConexionBD();
            sql="{CALL CREAR_FUNCION(?)}";
            procedimiento=conexion.getConexionBD().prepareCall(sql);
            procedimiento.setString(1, consulta);
            procedimiento.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Creacion de tabla temporal correctamente");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al crear tabla temporal");
        }
        
    }
    
    public void procEnvioEmail(String email,String asunto,String mensaje){
        
        try {
            
            conexion=new ConexionBD();
            sql="{CALL ENVIAR_CORREO_MASIVO(?,?,?,?)}";
            procedimiento=conexion.getConexionBD().prepareCall(sql);
            procedimiento.setString(1, email);
            procedimiento.setString(2,"Enviar Correos AunaUNFV.Anexo07");
            procedimiento.setString(3,asunto);
            procedimiento.setString(4,mensaje);
            procedimiento.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Envío de email satisfactoriamente");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Envío de email erroneo");
        }
        
    }
}
