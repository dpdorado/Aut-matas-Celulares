/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author DD
 */
public abstract  class ItemChangeController extends Controller implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(isValid())
            actualizar();
    }

    protected abstract boolean isValid() ;    
    
}
