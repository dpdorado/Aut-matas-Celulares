/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.GameOfLife;
import model.Model;
import view.OprionsLife;
import view.View;

/**
 *
 * @author DD
 */
public class OptionsLifeController extends ButtonController{
    private View viewPrincipal;
     
    public OptionsLifeController(View view, Model model){
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
         int numIter,sizeSimulation,porcen;
        OprionsLife viewE=(OprionsLife)this.view;
        
        numIter=viewE.getNumberIterations();        
        sizeSimulation=viewE.getSizeSimulation();
        porcen=viewE.getPorcentage();
        if(numIter != -1 && porcen != -1 && sizeSimulation != -1){
            ((GameOfLife)this.model).setAll(numIter,sizeSimulation,porcen);
            ((GameOfLife)this.model).start();
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos, intente denuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
