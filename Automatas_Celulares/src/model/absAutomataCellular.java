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
public abstract class absAutomataCellular extends Model{
    protected Cellula[][] cells;
    protected int side;
    protected int bandera;
    //protected int id=-1;
    public int getSide(){
        return this.side;
    }
    public void setSide(int side){
        this.side=side;
        this.cells = new Cellula[side][side];
    }
        
    public Cellula[][] getCells() {
        return cells;
    }

    public void setCells(Cellula[][] cells) {
        this.cells = cells;
    }
    
    public absAutomataCellular(int side) {
        this.cells = new Cellula[side][side];
    }  

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
    
    protected abstract void initCells();
    public abstract void start();
}
