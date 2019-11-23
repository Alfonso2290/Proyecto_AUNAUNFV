
package UtilidadesMailingCumpleaniero;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaCumpleaniero extends DefaultTableModel{
  
    String[] titulos;
    Object[][] datos;

    public ModeloTablaCumpleaniero(Object[][] datos, String[] titulos) {
        super();
        this.titulos=titulos;
        this.datos=datos;
        setDataVector(datos, titulos);
    }

    public ModeloTablaCumpleaniero() {}

    public boolean isCellEditable (int row, int column)
    {
        return false;
    }
}


