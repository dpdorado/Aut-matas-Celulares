package model;

import view.View;

/**
 *
 * @author DD
 */
public class Model {        
    protected View sourceView;
   
    public void setView(View view) {
        this.sourceView=view;
    }

    public View getView() {
        return this.sourceView;
    }
    
    public void notificar(){        
        this.sourceView.actualizar(this);        
    } 
    
    public void notificarMensaje(String mensaje){
        this.sourceView.actualizar(mensaje);
    }
}
