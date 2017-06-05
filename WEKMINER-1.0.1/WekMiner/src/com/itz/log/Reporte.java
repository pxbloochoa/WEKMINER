/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itz.log;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Naii
 */
public class Reporte extends JFrame {

    String ruta;
    String[] etiquetas;
    int[] totales;
    double[] porcentajes;
    JPanel panel;

    public Reporte(String ruta) {
        this.ruta = ruta;
        leerArchivo();

    }

    public void leerArchivo() {

        try {
            int etiquetasContador = 0;
            int totalesContador = 0;
            int porcentajesContador = 0;
            Scanner sc = new Scanner(new File(ruta));
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.contains("Numero De Clusters:")) {
                    String[] valores = linea.trim().split(" ");
                    int tamaño = Integer.parseInt(valores[valores.length - 1]);

                    etiquetas = new String[tamaño];
                    totales = new int[tamaño];
                    porcentajes = new double[tamaño];
                }
                if (linea.contains("Valores del cluster")) {
                    String[] valores = linea.trim().split("=");
                    etiquetas[etiquetasContador] = valores[valores.length - 1].trim();
                    etiquetasContador++;
                }
                if (linea.contains("Cluster numero")) {
                    String[] valores = linea.trim().replaceAll("   ", " ").replaceAll("  ", " ").split(" ");
                    totales[totalesContador] = Integer.parseInt(valores[4]);
                    porcentajes[porcentajesContador] = Double.parseDouble(valores[8]);
                    totalesContador++;
                    porcentajesContador++;
                }

            }

            for (int i = 0; i < etiquetas.length; i++) {
                System.out.println("Etiqueta Cluster " + i + ": " + etiquetas[i]);
                System.out.println("Elemntos Cluster " + i + ": " + totales[i]);
                System.out.println("Porcentaje Cluster " + i + ": " + porcentajes[i]);
                System.out.println("\n\n");

            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void init() {
        panel = new JPanel();
        //getContentPane().add(panel);

        // Fuente de Datos 
        DefaultCategoryDataset grafica_barras = new DefaultCategoryDataset();
        for (int i = 0; i < totales.length; i++) {
            grafica_barras.addValue(totales[i], " Cluster= " + i + " valor= " + totales[i], etiquetas[i]);
        }
 
        //Grafica de barras 3D
        JFreeChart chart = ChartFactory.createBarChart3D("GRAFICAS DE CLOUSTER", "CLUSTER", "DATOS",
                grafica_barras, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.gray);
        chart.getTitle().setPaint(Color.black);
         
        //Grafica pastel
        DefaultPieDataset grafica_pastel = new DefaultPieDataset();
        
        for (int i = 0; i < porcentajes.length; i++) {
            grafica_pastel.setValue(" Cluster = " + i + " Valor = " + porcentajes[i] + "%", porcentajes[i]);
        }
        JFreeChart chartt = ChartFactory.createPieChart3D("GRAFICA DE CLOUSTER", grafica_pastel, true, true, false);
        chartt.setBackgroundPaint(Color.gray);
        chartt.getTitle().setPaint(Color.black);
        
        // Mostrar Grafico

        ChartFrame barras = new ChartFrame("Grafica", chart);
        //barras.setVisible(true);
        //barras.pack();
        barras.getChartPanel();
        

        ChartFrame pastel = new ChartFrame("Grafica", chartt);
        pastel.setVisible(true);
        pastel.pack();
    }
    
    
    
    public JPanel Pastel() {
        panel = new JPanel();
        //getContentPane().add(panel);

        // Fuente de Datos 
        DefaultCategoryDataset grafica_barras = new DefaultCategoryDataset();
        for (int i = 0; i < totales.length; i++) {
            grafica_barras.addValue(totales[i], " Cluster= " + i + " valor= " + totales[i], etiquetas[i]);
        }
         
        //Grafica pastel
        DefaultPieDataset grafica_pastel = new DefaultPieDataset();
        
        for (int i = 0; i < porcentajes.length; i++) {
            grafica_pastel.setValue(" Cluster = " + i + " Valor = " + porcentajes[i] + "%", porcentajes[i]);
        }
        JFreeChart chartt = ChartFactory.createPieChart3D("GRAFICA DE CLOUSTER", grafica_pastel, true, true, false);
        chartt.setBackgroundPaint(Color.gray);
        chartt.getTitle().setPaint(Color.black);
        
        // Mostrar Grafico
        

        ChartFrame pastel = new ChartFrame("Grafica", chartt);
        //pastel.setVisible(true);
        pastel.pack();
        panel=pastel.getChartPanel();
        
        return panel;
    }

   public JPanel Barras() {
        panel = new JPanel();
        //getContentPane().add(panel);

        // Fuente de Datos 
        DefaultCategoryDataset grafica_barras = new DefaultCategoryDataset();
        for (int i = 0; i < totales.length; i++) {
            grafica_barras.addValue(totales[i], " Cluster= " + i + " valor= " + totales[i], etiquetas[i]);
        }
 
        //Grafica de barras 3D
        JFreeChart chart = ChartFactory.createBarChart3D("GRAFICAS DE CLOUSTER", "CLUSTER", "DATOS",
                grafica_barras, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.gray);
        chart.getTitle().setPaint(Color.black);
         
      
        
        // Mostrar Grafico

        ChartFrame barras = new ChartFrame("Grafica", chart);
        //barras.setVisible(true);
        barras.pack();
        panel=barras.getChartPanel();
        
        return panel;
        
    }
   

}
