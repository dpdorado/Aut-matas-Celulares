/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JComboBox;
import model.AutomataElementary;
import model.AutomataNewman;
import model.GameOfLife;
import model.Model;
import view.OprionsLife;
import view.OptionsElementaries;
import view.OptionsNewman;
import view.View;
import view.pnViewPrincipla;

/**
 *
 * @author DD
 */
public class ViewPrincipalController extends ItemChangeController{
    
    public ViewPrincipalController(View view, Model model){
        this.view=view;
        this.model=model;
    }
    
    @Override
    protected boolean isValid() {
        return true;
    }

    @Override
    public void actualizar() {        
        pnViewPrincipla view=(pnViewPrincipla)this.view;
        JComboBox combo=view.getTypeAutomata();
        String item=combo.getSelectedItem().toString();
        if(item.equals("Automatas elementales")){
            OptionsElementaries viewE=new OptionsElementaries();          
            AutomataElementary automata=new AutomataElementary();
            OptionsElementariesController controller=new OptionsElementariesController(viewE,automata);                       
            controller.setViewPrincipal(this.view);   //sobra????                     
            viewE.setController(controller);
            automata.setView(this.view);
            view.setOptions(viewE);
            
        }else if(item.equals("Juego de la vida")){
            OprionsLife viewE=new OprionsLife();
            GameOfLife automata=new GameOfLife();
            OptionsLifeController controller=new OptionsLifeController(viewE,automata);
            controller.setViewPrincipal(this.view);   //sobra????                       
            viewE.setController(controller);            
            automata.setView(this.view);
            view.setOptions(viewE);
        }else if(item.equals("Newman")){
            OptionsNewman viewE=new OptionsNewman();
            AutomataNewman automata=new AutomataNewman();
            OptionsNewmanController controller=new OptionsNewmanController(viewE,automata);
            controller.setViewPrincipal(this.view);   //sobra????                       
            viewE.setController(controller);            
            automata.setView(this.view);
            view.setOptions(viewE);
        }
    }
    
}
