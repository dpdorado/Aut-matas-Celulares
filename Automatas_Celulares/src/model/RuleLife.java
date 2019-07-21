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

//0 muerto
//1 vivo
public class RuleLife {
    public RuleLife(){}
    
    //Con 2 0 3 en estado vivo queda viva
    public int getState(int[] states){        
        int count=0;
        for (int i=0;i<states.length;i++){
            if(states[i]==1){
                count++;
            }
        }        
        return count==2||count==3?1:0;
    }
}
