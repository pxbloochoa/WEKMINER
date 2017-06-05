package com.itz.log;
import com.csvreader.CsvReader;
import java.lang.Object;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CargaCSV {
String ruta;

public CargaCSV(){

}

public void arregloCSV(JTable tabla,String ruta){
    DefaultTableModel tablaDefault = new DefaultTableModel();
    try {
      //Crea conexion de un archivo csv con java que permite manipularlo 
        CsvReader Etl = new CsvReader(ruta);
        
            Etl.readHeaders();
            Etl.readRecord();
        int totalColumnas=Etl.getColumnCount();
        for (int i = 0; i < totalColumnas; i++) {
            try {
                //asigna el nombre de la columna dependiendo las cabeceras del archivo CSV
                tablaDefault.addColumn(Etl.getHeader(i).toUpperCase());
            } catch (IOException ex) {
                Logger.getLogger(CargaCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//fin for
        int total=0;
        while(Etl.readRecord()){
            //Se crea un arreglo con los datos de cada fila del archivo CSV
        Object [] arreglo=new Object[totalColumnas];
            for (int i = 0; i < totalColumnas; i++) {
            arreglo[i]=Etl.get(i);
            }
            tablaDefault.addRow(arreglo);
            total++;
        }//fin while
        //texto.setText(total+"");
        tabla.setModel(tablaDefault);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(CargaCSV.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
            Logger.getLogger(CargaCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void llenaCombo(String ruta,JComboBox comboI){

        DefaultComboBoxModel combo=(DefaultComboBoxModel) comboI.getModel();
    try {
        CsvReader Etl = new CsvReader(ruta);
        Etl.readHeaders();
         Etl.readRecord();
         int totalColumnas=Etl.getColumnCount();
        Object [] arreglo=new Object[totalColumnas];
        for (int i = 0; i < totalColumnas; i++) {
           combo.addElement(Etl.getHeader(i));
        }
         
    } catch (IOException ex) {
        
    }
           
}

public int totalFilas(String ruta){
    try {
        CsvReader Etl = new CsvReader(ruta);
        
        Etl.readHeaders();
        Etl.readRecord();
         int total=0;
        while(Etl.readRecord()){
           
        
            total++;
        }//fin while 
        return total;
    } catch (IOException ex) {
      
    }
    return 0;
}

}
