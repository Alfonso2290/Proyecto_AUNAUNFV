
package InterfaceGraficaRegistro;

import java.awt.event.*;
import javax.swing.*;
import BEAN.*;
import DAO.*;
import Principal.VentanaPrincipal;
import java.awt.Color;

public class VentanaRegistroUsuarioInicio extends JFrame implements ActionListener,FocusListener
{
    private PanelRegistroUsuarioInicio miPanel;
    
    public VentanaRegistroUsuarioInicio()
    {
        setTitle("Registrar Usuario");
        setSize(350,700);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelRegistroUsuarioInicio();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnGuardar().addActionListener(this);
        miPanel.getBtnCancelar().addActionListener(this);
        miPanel.getTxtUsuario().addFocusListener(this);
        miPanel.getTxtDni().addFocusListener(this);
        
        miPanel.getBtnCancelar().addKeyListener(new cambioCampo());
        miPanel.getBtnGuardar().addKeyListener(new cambioCampo());
        miPanel.getTxtEmail().addKeyListener(new cambioCampo());
        miPanel.getTxtCel().addKeyListener(new cambioCampo());
        miPanel.getTxtFecha().addKeyListener(new cambioCampo());
        miPanel.getTxtNom().addKeyListener(new cambioCampo());
        miPanel.getTxtDni().addKeyListener(new cambioCampo());
        miPanel.getTxtCargo().addKeyListener(new cambioCampo());
        miPanel.getTxtClave1().addKeyListener(new cambioCampo());
        miPanel.getTxtClave2().addKeyListener(new cambioCampo());
        miPanel.getTxtUsuario().addKeyListener(new cambioCampo());
        
        miPanel.getBtnAtras().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaPrincipal ventana=new VentanaPrincipal();
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
        String nom,dni,cel,fecha,email,cargo,usuario,clave1,clave2;
        dni=miPanel.getTxtDni().getText();
        nom=miPanel.getTxtNom().getText();
        fecha=miPanel.getTxtFecha().getText();
        cel=miPanel.getTxtCel().getText();
        email=miPanel.getTxtEmail().getText();
        cargo=miPanel.getTxtCargo().getText();
        usuario=miPanel.getTxtUsuario().getText();
        clave1=miPanel.getTxtClave1().getText();
        clave2=miPanel.getTxtClave2().getText();

        if(dni.equals("") || dni.length()<8)
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo DNI");
            miPanel.getTxtDni().requestFocus();
        }
        else if(nom.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Nombre");
            miPanel.getTxtNom().requestFocus();
        }
        else if(usuario.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Usuario");
            miPanel.getTxtUsuario().requestFocus();
        }
        else if(clave1.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Contraseña");
            miPanel.getTxtClave1().requestFocus();
        }
        else if(clave2.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Repetir Contraseña");
            miPanel.getTxtClave2().requestFocus();
        }
        else if(cargo.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Cargo");
            miPanel.getTxtCargo().requestFocus();
        }
        else if(fecha.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Fecha de Nacimiento");
            miPanel.getTxtFecha().requestFocus();
        }
        else if(cel.equals("") || cel.length()<9)
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Teléfono Celular");
            miPanel.getTxtCel().requestFocus();
        }
        else if(email.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Email");
            miPanel.getTxtEmail().requestFocus();
        }
        else if(!(clave1.equals(clave2))){
            
            JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no coinciden");
            miPanel.getTxtClave1().setText("");
            miPanel.getTxtClave2().setText("");
            miPanel.getTxtClave1().requestFocus();
        }
        else
        {

                PersonaBEAN persona=new PersonaBEAN();
                persona.setDni(dni);
                persona.setNombre(nom);
                persona.setFechaNacimiento(fecha);
                persona.setCelular(cel);
                persona.setEmail(email);
                
                EmpleadoDAO dao=new EmpleadoDAO();
                String codigoEmpleado=dao.generarCodigoEmpleado();
                EmpleadoBEAN empleado=new EmpleadoBEAN();
                empleado.setDni(dni);
                empleado.setCargo(cargo);
                empleado.setCodigoEmpleado(codigoEmpleado);

                UsuarioBEAN usu=new UsuarioBEAN();
                usu.setDni(dni);
                usu.setNombre(usuario);
                usu.setClave(clave1);
                usu.setTipo("Administrador");
                
                PersonaDAO perdao=new PersonaDAO();
                
                UsuarioDAO usudao=new UsuarioDAO();
        
                int verificarNombreUsuario=usudao.verificarNombreUsuario(usuario);
                int verificarDNI=dao.verificarEmpleado(empleado);
                
                
                if(verificarNombreUsuario==0)
                {
                    perdao.registrarPersona(persona);
                    usudao.registrarUsuario(usu);
                    dao.registrarEmpleado(empleado);
                    miPanel.limpiarCampos();
                    
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
        
        if(e.getSource()==miPanel.getTxtUsuario()){
            miPanel.getMensaje2().setText("");
        }
    }
    
    @Override
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==miPanel.getTxtDni())
        {
            String dni=miPanel.getTxtDni().getText();
            ClienteBEAN cli=new ClienteBEAN();
            cli.setDni(dni);
            
            ClienteDAO clidao=new ClienteDAO();
            int verificacion=clidao.verificarCliente(cli);
            if(verificacion>0 && dni.compareTo("")!=0 )
            {
                miPanel.getMensaje().setText("DNI Registrado");
            }
        }
        
        if(e.getSource()==miPanel.getTxtUsuario())
        {
            String nombreUsuario=miPanel.getTxtUsuario().getText();
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
            VentanaPrincipal ventana=new VentanaPrincipal();
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
            
            if(e.getSource()==miPanel.getTxtNom())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtNom().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtUsuario())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtUsuario().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtClave1())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtClave1().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtClave2())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtClave2().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCargo())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtCargo().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtFecha())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtFecha().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCel())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtCel().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtEmail())
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

