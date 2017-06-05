/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itz.Interfaces;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingWorker;

/**
 *
 * @author gaad5
 */
public class Inicio extends SwingWorker<Integer, String > {

    private JProgressBar progreso;
    private JLabel etiqueta;
    private JButton boton;
    int c=0;
    Container x;
    public Inicio(JButton boton) {
        this.boton = boton;
    }

    public Inicio(JProgressBar progreso, JLabel etiqueta,Container p) {
        this.progreso = progreso;
        this.etiqueta = etiqueta;
        this.x=p;
    }
    
    
    
    @Override
    protected Integer doInBackground() throws Exception {
        
     
        getProgreso().setIndeterminate(true);
        
        for(int i=0; i<101; i++){
        getEtiqueta().setText("Cargando   " +   i);
        c++;
        Thread.sleep(50);
         
        }
        
        getProgreso().setIndeterminate(false);
        getEtiqueta().setVisible(false);
       
        //ini in = new ini();
        new prueba().setVisible(true);
        x.show(false);
       
       
        
        
        return 0;
    }

   
    public JProgressBar getProgreso() {
        return progreso;
    }

    /**
     * @param progreso the progreso to set
     */
    public void setProgreso(JProgressBar progreso) {
        this.progreso = progreso;
    }

    /**
     * @return the etiqueta
     */
    public JLabel getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the boton
     */
    public JButton getBoton() {
        return boton;
    }

    /**
     * @param boton the boton to set
     */
    public void setBoton(JButton boton) {
        this.boton = boton;
    }


    
}
