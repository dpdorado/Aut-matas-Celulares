/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DD
 */

/*Una célula muerta con exactamente 3 células vecinas vivas "nace" (es decir, al turno siguiente estará viva).
Una célula viva con 2 o 3 células vecinas vivas sigue viva, en otro caso muere (por "soledad" o "superpoblación").*/

//0 muerto
//1 vivo
public class RuleLife {
    public RuleLife(){}
    
    //Con 2 0 3 en estado vivo queda viva
    public int getState(int[] states){   
        int cellLife=0;
        int cellDead=0;//No se utiliza
        int size=states.length;
        int state=0;
        
        for (int i=0;i<size-1;i++){
            if(states[i]==1){
                cellLife++;
            }else{
                cellDead++;//No se utiliza
            }
        }
        
        if (states[size-1]==0 && cellLife==3){
            state=1;
        }else if(states[size-1]==1 && (cellLife==2 || cellLife==3)){
            state=1;
        }
        
        return state;
    }
       
    
    
    
    
}
