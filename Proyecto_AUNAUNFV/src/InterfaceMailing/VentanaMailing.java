
package InterfaceMailing;

import Principal.VentanaProcesos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaMailing extends JFrame {
    
    private PanelMailing miPanel;
    private PanelMailingCumpleanios lamina;
    private JComboBox<String> cbTipo;
    private Dimension tamañoPantalla;
    
    public VentanaMailing()
    {
        setTitle("Mailing");
        tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,80);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
    }
    
    private void Inicio()
    {
        cbTipo=new JComboBox<String>();
        cbTipo.addItem("--Seleccionar--");
        cbTipo.addItem("TOP 10 CLIENTES MÁS FIELES Y SU PRODUCTO MÁS CONSUMIDO");
        cbTipo.addItem("CUMPLEAÑOS");
        
        
        cbTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(cbTipo.getSelectedItem().toString().equals("--Seleccionar--")){
                    
                    setSize(tamañoPantalla.width*3/5,80);
                    setLocationRelativeTo(null);
                    
                }else if(cbTipo.getSelectedItem().toString().equals("TOP 10 CLIENTES MÁS FIELES Y SU PRODUCTO MÁS CONSUMIDO")){
                    setSize(tamañoPantalla.width*3/5,480);
                    setLocationRelativeTo(null);
                    Top10();
                    if(lamina!=null)
                        lamina.setVisible(false);
                    if(miPanel!=null)
                        miPanel.setVisible(true);
                    
                    
                }else if(cbTipo.getSelectedItem().toString().equals("CUMPLEAÑOS")){
                    setSize(tamañoPantalla.width*3/5,480);
                    setLocationRelativeTo(null);
                    Cumpleañero();
                    if(lamina!=null)
                        lamina.setVisible(true);
                    if(miPanel!=null)
                        miPanel.setVisible(false);
                }
            }
        });
        
        add(cbTipo);
        
    }
    
    private void Top10(){
        
        miPanel=new PanelMailing();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnAtras().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaProcesos ventana=new VentanaProcesos();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        
        add(miPanel);
    }
    
    private void Cumpleañero(){
        
        lamina=new PanelMailingCumpleanios();
        lamina.setBackground(Color.LIGHT_GRAY.brighter());
        
        lamina.getBtnAtras().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaProcesos ventana=new VentanaProcesos();
                ventana.setVisible(true);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        
        add(lamina);
    }
    
}
