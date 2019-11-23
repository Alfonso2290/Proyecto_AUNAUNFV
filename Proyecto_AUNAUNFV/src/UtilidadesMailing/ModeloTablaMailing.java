
package UtilidadesMailing;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaMailing extends DefaultTableModel{
  
    String[] titulos;
    Object[][] datos;

    public ModeloTablaMailing(Object[][] datos, String[] titulos) {
        super();
        this.titulos=titulos;
        this.datos=datos;
        setDataVector(datos, titulos);
    }

    public ModeloTablaMailing() {}

    public boolean isCellEditable (int row, int column)
    {
        return false;
    }
}


