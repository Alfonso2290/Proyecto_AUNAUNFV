
package InterfaceGraficaRegistro;

import BEAN.*;
import DAO.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistroUsuario extends JFrame implements ActionListener,FocusListener
{
    private PanelRegistroUsuario miPanel;
    
    public VentanaRegistroUsuario()
    {
        setTitle("Registrar Usuario");
        setSize(350,470);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelRegistroUsuario();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnGuardar().addActionListener(this);
        miPanel.getBtnCancelar().addActionListener(this);
        miPanel.getTxtDni().addFocusListener(this);
        miPanel.getTxtUsu().addFocusListener(this);
        
        miPanel.getBtnCancelar().addKeyListener(new cambioCampo());
        miPanel.getBtnGuardar().addKeyListener(new cambioCampo());
        miPanel.getTxtUsu().addKeyListener(new cambioCampo());
        miPanel.getTxtCla1().addKeyListener(new cambioCampo());
        miPanel.getTxtCla2().addKeyListener(new cambioCampo());
        miPanel.getCbTipo().addKeyListener(new cambioCampo());
        miPanel.getTxtDni().addKeyListener(new cambioCampo());
        
        
        miPanel.getBtnAtras().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaRegistros ventana=new VentanaRegistros();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnCancelar())
        {
            eventoCancelar();
        }
        
        if(e.getSource()==miPanel.getBtnGuardar())
        {
            eventoGuardar();
        }
    }
    
    private void eventoGuardar()
    {
        String dni,tipo,usu,cla1,cla2;
        dni=miPanel.getTxtDni().getText();
        tipo=miPanel.getCbTipo().getSelectedItem().toString();
        usu=miPanel.getTxtUsu().getText();
        cla1=miPanel.getTxtCla1().getText();
        cla2=miPanel.getTxtCla2().getText();
        

        if(dni.equals("") || dni.length()<8)
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo DNI");
            miPanel.getTxtDni().requestFocus();
        }
        else if(tipo.equals("--Seleccionar Tipo--"))
        {
            JOptionPane.showMessageDialog(null, "Usted debe seleccionar el campo Tipo Usuario");
            miPanel.getCbTipo().requestFocus();
        }
        else if(usu.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Usuario");
            miPanel.getTxtUsu().requestFocus();
        }
        else if(cla1.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Contraseña");
            miPanel.getTxtCla1().requestFocus();
        }
        else if(cla2.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Repetir Contraseña");
            miPanel.getTxtCla2().requestFocus();
        }
        else if(!(cla1.equals(cla2)))
        {
            JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no coinciden");
            miPanel.getTxtCla1().setText("");
            miPanel.getTxtCla2().setText("");
            miPanel.getTxtCla1().requestFocus();
        }
        else
        {
            
            UsuarioBEAN usubean=new UsuarioBEAN();
            usubean.setDni(dni);
            usubean.setNombre(usu);
            usubean.setClave(cla1);
            usubean.setTipo(tipo);
            
            UsuarioDAO usudao=new UsuarioDAO();
            
            int verificarNombreUsuario=usudao.verificarNombreUsuario(usu);
            int verificarDNI=usudao.verificarDNIUsuario(usubean);


            if(verificarNombreUsuario==0)
            {
                if(verificarDNI>0)
                {
                    usudao.registrarUsuario(usubean);
                    miPanel.limpiarCampos();
                }else{

                    JOptionPane.showMessageDialog(null, "Error!!..Verifique los datos ingresados");
                    miPanel.getTxtDni().requestFocus();
                }

            }else{

                JOptionPane.showMessageDialog(null, "Error!!..Verifique los datos ingresados");
                miPanel.getTxtDni().requestFocus();
            }
            
        }
    }

    
    @Override
    public void focusGained(FocusEvent e)
    {
        if(e.getSource()==miPanel.getTxtDni()){
            miPanel.getMensaje().setText("");
        }
        
        if(e.getSource()==miPanel.getTxtUsu()){
            miPanel.getMensaje2().setText("");
        }
    }
    
    @Override
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==miPanel.getTxtDni())
        {
            String dni=miPanel.getTxtDni().getText();
            UsuarioBEAN usuario=new UsuarioBEAN();
            usuario.setDni(dni);
            
            UsuarioDAO dao=new UsuarioDAO();
            int verificacion=dao.verificarDNIUsuario(usuario);
            if(verificacion>0 && dni.compareTo("")!=0 )
            {
                miPanel.getMensaje().setText("DNI Válido");
            }
        }
        
        if(e.getSource()==miPanel.getTxtUsu())
        {
            String nombreUsuario=miPanel.getTxtUsu().getText();
            UsuarioBEAN usu=new UsuarioBEAN();
            usu.setNombre(nombreUsuario);
            
            UsuarioDAO dao=new UsuarioDAO();
            int verificacion=dao.verificarNombreUsuario(nombreUsuario);
            if(verificacion>0 && nombreUsuario.compareTo("")!=0 )
            {
                miPanel.getMensaje2().setText("Usuario Registrado");
            }
        }
    }
    
    private void eventoCancelar()
    {
        int rpta=JOptionPane.showConfirmDialog(null,"Esta seguro que desea cancelar?\nLos Datos ingresados en la ventana se perderán","Alerta!!" ,JOptionPane.YES_NO_OPTION);
        if(rpta==JOptionPane.YES_OPTION)
        {
            dispose();
            VentanaRegistros ventana=new VentanaRegistros();
            ventana.setVisible(true);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    private class cambioCampo extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getSource()==miPanel.getTxtDni())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtDni().nextFocus();
            }
            
            if(e.getSource()==miPanel.getCbTipo())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getCbTipo().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtUsu())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtUsu().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCla1())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtCla1().nextFocus();
            }
                
            if(e.getSource()==miPanel.getTxtCla2())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoGuardar(); 
            }
            
            if(e.getSource()==miPanel.getBtnGuardar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoGuardar();
            }
            
            if(e.getSource()==miPanel.getBtnCancelar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                   eventoCancelar();
            }
                
        }
    }
}

