/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author DD
 */
public class FileManager {
    private String path;
    private String name;
    public FileManager(String name){
        this.name=name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public void initNameFile(){
        SimpleDateFormat MI_FORMATO = new SimpleDateFormat("dd-MM-yyyy HM-mm-ss", Locale.getDefault());          
        Date Ahora = new Date();         
        this.path = "src/files/"+this.name+" - "+MI_FORMATO.format(Ahora)+".txt";                          
        this.createFile(this.path);
    }
    
    private boolean createFile(String path){    
        
        boolean varResultado=false;
        try {
            File file=new File(path);
            if (!file.exists()){
                varResultado=file.createNewFile();
            }else {
                varResultado=true;
            }
            return varResultado;	        	
        }catch(Exception e) {
                return false;
        }	 
    }
    
    public void writeLine(String line){        
        FileWriter fw = null;                                 
        try {
            fw = new FileWriter(this.path,true);                           
            fw.write(System.getProperty("line.separator")); //nueva línea
            fw.write(line);            
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fw = null;
            }
        }
    
    }
    
    public void writeMatriz(String[][] matriz){
        String line;        
        FileWriter fw = null;                         
        
        try {
            fw = new FileWriter(this.path,true);
            for (int i=0; i<matriz.length; i++){
                line="";
                for(int j=0;j<matriz.length;j++){
                    line+=matriz[i][j]+" ";                
                }                
                fw.write(System.getProperty("line.separator")); //nueva línea
                fw.write(line);                                
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fw = null;
            }
        }
    }
}
