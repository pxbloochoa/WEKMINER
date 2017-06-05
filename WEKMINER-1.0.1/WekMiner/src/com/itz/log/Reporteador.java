/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itz.log;

import javax.swing.JFrame;
import javax.swing.JPanel;
import static org.omg.CORBA.ORB.init;

/**
 *
 * @author Naii
 */
public class Reporteador extends JFrame{

    /**
     * @param args the command line arguments
     * 
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Reporte r = new Reporte("/home/pablo/Documentos/WEKMINER-master/WekMiner/texto.txt");
        r.init();
              
        
    }
    
}
