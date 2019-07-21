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
        OptionsElementaries viewE=(OptionsElementaries)this.view;        
        numIter=viewE.getNumberIterations();
        ruleNumber=viewE.getRuleNumber();
        sizeSimulation=viewE.getSizeSimulation();
        if(numIter != -1 && ruleNumber != -1 && sizeSimulation != -1){
            ((AutomataElementary)this.model).setAll(numIter,this.obtenerBinario(ruleNumber),Integer.toString(ruleNumber),sizeSimulation);
            ((AutomataElementary)this.model).start();
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public int[] obtenerBinario(int numero){
        int[] result=new int[8];
        String binariString=Integer.toBinaryString(numero);             
        char[] aux =binariString.toCharArray();
        int tmn_aux=aux.length;
        int res=result.length-tmn_aux;
        int index_aux=0;
        for(int i=0;i<tmn_aux;i++){
            result[i]=0;
        }
        
        for(int i=res;i<result.length;i++){
            result[i]= Integer.parseInt("" + (aux[index_aux]));
            index_aux++;
        }
             
        return result;
    }
    
}
