/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author DD
 */
public class startViews extends JFrame{
    private JPanel content;
    
    public startViews(){
        this.setTitle("Trabajo final TDS - Autómatas celulares.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.MarcoCentrado();
        this.add(content=new pnViewPrincipla());
    }
     
    public void MarcoCentrado(){		
        Toolkit miPantalla = Toolkit.getDefaultToolkit();

        //centrar ventana
        Dimension tamanoPantalla = miPantalla.getScreenSize();

        int altoPantalla =  tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;

        this.setSize(anchoPantalla/2, altoPantalla- altoPantalla/4);
        this.setLocation(anchoPantalla/4, altoPantalla/8);    
        
        //cambiar icono de la ventana
	Image miIcono = miPantalla.getImage("src/img/automata.jpg");
	this.setIconImage(miIcono);
    }
    
    public static void main(String args[]){                
        startViews principal = new startViews();
        principal.setVisible(true);
    }
    
}
