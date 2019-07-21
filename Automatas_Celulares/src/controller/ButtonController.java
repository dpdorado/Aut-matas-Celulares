package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract  class ButtonController extends Controller implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(isValid())
          actualizar();
    
    }
    
    protected abstract boolean isValid() ;
}

