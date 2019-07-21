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
public class Cellula {
    private int state;

    public Cellula() {              
    }
        
    public Cellula(int state) {
        this.state = state;
    }  

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }      
    
}
