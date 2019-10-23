
package InterfaceGraficaRegistro;

import BEAN.ClienteBEAN;
import BEAN.EmpleadoBEAN;
import BEAN.PersonaBEAN;
import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import DAO.PersonaDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaRegistroEmpleado extends JFrame implements ActionListener,FocusListener
{
    private PanelRegistroEmpleado miPanel;
    
    public VentanaRegistroEmpleado()
    {
        setTitle("Registrar Empleado");
        setSize(350,530);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelRegistroEmpleado();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnGuardar().addActionListener(this);
        miPanel.getBtnCancelar().addActionListener(this);
        miPanel.getTxtDni().addFocusListener(this);
        
        miPanel.getBtnCancelar().addKeyListener(new cambioCampo());
        miPanel.getBtnGuardar().addKeyListener(new cambioCampo());
        miPanel.getTxtEmail().addKeyListener(new cambioCampo());
        miPanel.getTxtCel().addKeyListener(new cambioCampo());
        miPanel.getTxtFecha().addKeyListener(new cambioCampo());
        miPanel.getTxtNom().addKeyListener(new cambioCampo());
        miPanel.getTxtDni().addKeyListener(new cambioCampo());
        miPanel.getTxtCargo().addKeyListener(new cambioCampo());
        
        
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
        String nom,dni,cel,fecha,email,cargo,codigoEmpleado;
        dni=miPanel.getTxtDni().getText();
        nom=miPanel.getTxtNom().getText();
        fecha=miPanel.getTxtFecha().getText();
        cel=miPanel.getTxtCel().getText();
        email=miPanel.getTxtEmail().getText();
        cargo=miPanel.getTxtCargo().getText();
        

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
        else
        {
            EmpleadoDAO empdao=new EmpleadoDAO();
            codigoEmpleado=empdao.generarCodigoEmpleado();
            
            PersonaBEAN persona=new PersonaBEAN();
            persona.setDni(dni);
            persona.setNombre(nom);
            persona.setFechaNacimiento(fecha);
            persona.setCelular(cel);
            persona.setEmail(email);
            
            EmpleadoBEAN empleado=new EmpleadoBEAN();
            empleado.setDni(dni);
            empleado.setCargo(cargo);
            empleado.setCodigoEmpleado(codigoEmpleado);
            
            PersonaDAO perdao=new PersonaDAO();

            int verificarDNI=empdao.verificarEmpleado(empleado);
            if(verificarDNI==0)
            {
                perdao.registrarPersona(persona);
                empdao.registrarEmpleado(empleado);
                JOptionPane.showMessageDialog(null,"El empleado ha sido registrado correctamente");
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
        miPanel.getMensaje().setText("");
    }
    
    @Override
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==miPanel.getTxtDni())
        {
            String dni=miPanel.getTxtDni().getText();
            EmpleadoBEAN empleado=new EmpleadoBEAN();
            empleado.setDni(dni);
            
            EmpleadoDAO dao=new EmpleadoDAO();
            int verificacion=dao.verificarEmpleado(empleado);
            if(verificacion>0 && dni.compareTo("")!=0 )
            {
                miPanel.getMensaje().setText("Empleado Registrado");
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
            
            if(e.getSource()==miPanel.getTxtNom())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtNom().nextFocus();
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
