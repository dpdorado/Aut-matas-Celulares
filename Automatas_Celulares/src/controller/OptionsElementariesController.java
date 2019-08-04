/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.AutomataElementary;
import model.Model;
import view.OptionsElementaries;
import view.View;

/**
 *
 * @author DD
 */
public class OptionsElementariesController extends ButtonController{   
    private View viewPrincipal;
    
    public OptionsElementariesController(View view, Model model){
        this.view=view;
        this.model=model;
    }

    public View getViewPrincipal() {
        return viewPrincipal;
    }

    public void setViewPrincipal(View viewPrincipal) {
        this.viewPrincipal = viewPrincipal;
    }
        
    @Override
    protected boolean isValid() {
        return true;
    }

    @Override
    public void actualizar() {
        int numIter,sizeSimulation,ruleNumber;
        int opcion=0;
        boolean opcion_b=false;
        OptionsElementaries viewE=(OptionsElementaries)this.view;        
        numIter=viewE.getNumberIterations();
        ruleNumber=viewE.getRuleNumber();
        sizeSimulation=viewE.getSizeSimulation();
        if(numIter != -1 && ruleNumber != -1 && sizeSimulation != -1){
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea  generar vector inicial aleatorio?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            opcion_b=opcion==0?true:false;
            ((AutomataElementary)this.model).setAll(numIter,ruleNumber,Integer.toString(ruleNumber),sizeSimulation,opcion_b);
            ((AutomataElementary)this.model).start();
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }    
    
}
