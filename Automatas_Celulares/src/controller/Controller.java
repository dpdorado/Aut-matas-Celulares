package controller;

import view.View;
import model.Model;


/**
 *
 * @author DD
 */

public abstract class Controller{          
    protected View view;
    protected Model model;

    public abstract void actualizar();  
}



