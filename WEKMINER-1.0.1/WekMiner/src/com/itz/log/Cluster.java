package com.itz.log;
import com.csvreader.CsvReader;
import com.itz.Interfaces.prueba;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
 
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
 
public class Cluster {
 
	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
 
	public static void main(String[] args) throws Exception {
            

             
         }
JTable tabla;
    public Cluster(JTable tabla) {
        this.tabla=tabla;
    }
        
        
        
        
        public void concatena(JTextArea text,int numclu,String path) throws Exception {
            
              CSVLoader loader = new CSVLoader();
            loader.setSource(new File(path)); 
            Instances  data = loader.getDataSet(); 
		SimpleKMeans kmeans = new SimpleKMeans();
 
		kmeans.setSeed(10);
                kmeans.displayStdDevsTipText();
          	kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(numclu);
                kmeans.buildClusterer(data);
		
		int[] assignments = kmeans.getAssignments();
            
                Object [] numeroCluster=new Object [kmeans.getNumClusters()];
                for (int i = 0; i < numeroCluster.length; i++) {
                numeroCluster[i]=i;
            }
             ArrayList<Integer> totalValores = new ArrayList<Integer>();
                
             // sacando total de cada cluster   
           for(int x=0;x<numeroCluster.length;x++){

            // recorremos los valores del array B
           int elemA=0;
           String clu="";
            for(int j=0;j<assignments.length;j++){
            clu=assignments[j]+"";
                
                if(numeroCluster[x].toString().compareTo(clu)==0){
                elemA++;
                }
                    
                    
            }
            
              totalValores.add(elemA);
            elemA=0;

        }
           Object[] totalClusterConteo = totalValores.toArray(); 
           
           
       //sacando la fila donde esta el primer cluster
           ArrayList<Integer> totalValores2 = new ArrayList<Integer>();
           int bandera=0;
               for(int x=0;x<numeroCluster.length;x++){
 
            // recorremos los valores del array B
           
           String clu="";
            for(int j=0;j<assignments.length;j++){
            clu=assignments[j]+"";
                if(numeroCluster[x].toString().compareTo(clu)==0 && bandera==0){
               int encontrado=j;
               totalValores2.add(encontrado);
              bandera=1; 
                }
           }
              bandera=0;
        }
           Object[] array3 = totalValores2.toArray();
        
           String total="";
           int registros=assignments.length;
           double porcentaje;
           float []porcentajeValor=new float[totalClusterConteo.length];
           for (int i = 0; i < totalClusterConteo.length; i++) {
               float a=Float.parseFloat(totalClusterConteo[i]+"");
                   porcentajeValor[i]=a*100/registros;
               }
           
           
          
    
            String valorCluster="";
            
            int length=totalClusterConteo.length;
           
            for (int i = 0; i < array3.length; i++) {
                valorCluster += "Valores del cluster  "+i+"  = "+elementosCluster(i,length)+"\n";
                
            }
           
            
           
            for (int i = 0; i < numeroCluster.length; i++) {
               total+=  "Cluster numero "+ i + " =   " +totalClusterConteo[i]+"   porcentaje de"
                       + " cluster:  "+porcentajeValor[i]+" %\n";
            }
             
            String contenido="Clustering \n"
                    //+ "\n"
                    + "\n"
                    + " Numero De Clusters:  "+length+"\n"
                   // + "\n"
                    + "\n"
                    + " Contenido: \n"
                   // + "\n"
                    + valorCluster+"\n"
                   // + "\n"
                    + "\n"
                    + " Total y Porcentaje: \n"
                    //+ "\n"
                    + total;
            
             text.setLineWrap (true);

text.setLineWrap (true);

text.setWrapStyleWord(true);

text.setWrapStyleWord(true);
            
            text.setText(contenido);
        
        }
        
        public String  elementosCluster(int a, int length){
    
    
    
    
   int total=tabla.getColumnCount();
   String datos[]= new String[total];
  
    for (int i = 0; i < total; i++) {
        
     datos[i]=tabla.getValueAt(a, i).toString(); 
    
    }
    String resultado="";
     for (int i = 0; i < datos.length; i++) {
        resultado+=datos[i]+"  ";
    }
    
    
return resultado;
}
}