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
public class GameOfLife extends absAutomataCellular{
    private int stage;   
    private int liveProportion;
    private RuleLife rule;
    private FileManager file;

    public GameOfLife(){
        super(1);
        //this.id=2;//ID de un autómata del juego de la vida
    }
    
    public GameOfLife(int stage, int side, int liveProportion) {
        super(side);
        this.stage = stage;
        this.side = side;
        this.liveProportion = liveProportion;
        rule=new RuleLife();
        //this.id=2;//ID de un autómata del juego de la vida
    }
    
    public void setAll(int stage, int side, int liveProportion) {        
        this.stage = stage;
        this.setSide(side);
        this.liveProportion = liveProportion;
        rule=new RuleLife();
        this.file=new FileManager("Juego de la vida");
        //this.id=2;//ID de un autómata del juego de la vida
    }
    
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }


    public int getLiveProportion() {
        return liveProportion;
    }

    public void setLiveProportion(int liveProportion) {
        this.liveProportion = liveProportion;
    }
    
    
    //Buuscar una manera de simplificar
    //Inicializamos la tabla con los valores dados por el usuario.
    @Override
    public void initCells(){
        int port=(this.side*this.side)*this.liveProportion/100;
        int[] aleatoriosF=new int[port];
        int[] aleatoriosC=new int[port];                     
        for (int i=0;i<port;i++){            
            aleatoriosF[i]=(int) (Math.random() *(this.side-1));            
            aleatoriosC[i]=(int) (Math.random() *(this.side-1));            
        }
                                
        for(int i=0;i<this.side;i++){
            for(int j=0;j<this.side;j++){                
               this.cells[i][j]=new Cellula(0);                                
            }
        }
        
        for(int i=0;i<aleatoriosF.length;i++){                           
            this.cells[aleatoriosF[i]][aleatoriosC[i]].setState(1);                                            
        }       
    }
    
    //Inicia la simulación
    @Override
    public void start(){        
        int count=0;        
        int[] states=new int[9];
        this.initCells();
        this.writeCharacteristics();
        this.bandera=0;
        this.notificar();         
        this.bandera=1;
        while(count<this.stage){
            for(int i=0;i<this.side;i++){
                for(int j=0;j<this.side;j++){                   
                    if(i>0 && i<this.side-1 && j>0 && j<this.side-1){                                                                                   
                        states[0]=this.cells[i][j-1].getState();//izquierda
                        states[1]=this.cells[i][j+1].getState();//derecha
                        states[2]=this.cells[i-1][j].getState();//arriba
                        states[3]=this.cells[i+1][j].getState();//abajo
                        states[4]=this.cells[i-1][j-1].getState();//superior izquierda
                        states[5]=this.cells[i-1][j+1].getState();//superior derecha
                        states[6]=this.cells[i+1][j-1].getState();//inferior isquierda
                        states[7]=this.cells[i+1][j+1].getState(); //inferior derecha                      
                    }else if(i==0 && j==0){
                        states[0]=this.cells[i][this.side-1].getState();
                        states[1]=this.cells[i][j+1].getState();
                        states[2]=this.cells[this.side-1][j].getState();
                        states[3]=this.cells[i+1][j].getState();
                        states[4]=this.cells[this.side-1][this.side-1].getState();
                        states[5]=this.cells[this.side-1][j+1].getState();
                        states[6]=this.cells[i+1][this.side-1].getState();
                        states[7]=this.cells[i+1][j+1].getState();                        
                    }else if(i==0 && j==this.side-1){
                        states[0]=this.cells[i][j-1].getState();
                        states[1]=this.cells[i][0].getState();
                        states[2]=this.cells[this.side-1][j].getState();
                        states[3]=this.cells[i+1][j].getState();                        
                        states[4]=this.cells[this.side-1][j-1].getState();
                        states[5]=this.cells[this.side-1][0].getState();
                        states[6]=this.cells[i+1][j-1].getState();
                        states[7]=this.cells[i+1][0].getState();                        
                    }else if(i==this.side-1 && j==0){  
                        //4
                        states[0]=this.cells[i][this.side-1].getState();
                        states[1]=this.cells[i][j+1].getState();
                        states[2]=this.cells[i-1][j].getState();
                        states[3]=this.cells[0][j].getState();
                        states[4]=this.cells[i-1][this.side-1].getState();
                        states[5]=this.cells[i-1][j+1].getState();
                        states[6]=this.cells[0][this.side-1].getState();
                        states[7]=this.cells[0][j+1].getState();                        
                    }else if(i==this.side-1 && j==this.side-1){   
                        //5
                        states[0]=this.cells[i][j-1].getState();
                        states[1]=this.cells[i][0].getState();
                        states[2]=this.cells[i-1][j].getState();
                        states[3]=this.cells[0][j].getState();
                        states[4]=this.cells[i-1][j-1].getState();
                        states[5]=this.cells[i-1][0].getState();
                        states[6]=this.cells[0][j-1].getState();
                        states[7]=this.cells[0][0].getState();                        
                    }else if(i==0){ 
                        //6
                        states[0]=this.cells[i][j-1].getState();
                        states[1]=this.cells[i][j+1].getState();
                        states[2]=this.cells[this.side-1][j].getState();
                        states[3]=this.cells[i+1][j].getState();
                        states[4]=this.cells[this.side-1][j-1].getState();
                        states[5]=this.cells[this.side-1][j+1].getState();
                        states[6]=this.cells[i+1][j-1].getState();
                        states[7]=this.cells[i+1][j+1].getState();                        
                    }else if(i==this.side-1){
                        //7
                        states[0]=this.cells[i][j-1].getState();
                        states[1]=this.cells[i][j+1].getState();
                        states[2]=this.cells[i-1][j].getState();
                        states[3]=this.cells[0][j].getState();
                        states[4]=this.cells[i-1][j-1].getState();
                        states[5]=this.cells[i-1][j+1].getState();
                        states[6]=this.cells[0][j-1].getState();
                        states[7]=this.cells[0][0+1].getState();                        
                    }else if(j==0){
                        states[0]=this.cells[i][this.side-1].getState();
                        states[1]=this.cells[i][j+1].getState();
                        states[2]=this.cells[i-1][j].getState();
                        states[3]=this.cells[i+1][j].getState();
                        states[4]=this.cells[i-1][this.side-1].getState();
                        states[5]=this.cells[i-1][j+1].getState();
                        states[6]=this.cells[i+1][this.side-1].getState();
                        states[7]=this.cells[i+1][j+1].getState();                        
                    }else if(j==this.side-1){
                        states[0]=this.cells[i][j-1].getState();
                        states[1]=this.cells[i][0].getState();
                        states[2]=this.cells[i-1][j].getState();
                        states[3]=this.cells[i+1][j].getState();
                        states[4]=this.cells[i-1][j-1].getState();
                        states[5]=this.cells[i-1][0].getState();
                        states[6]=this.cells[i+1][j-1].getState();
                        states[7]=this.cells[i+1][0].getState();                        
                    }                                                                                                   
                    states[8]=this.cells[i][j].getState();
                    this.cells[i][j].setState(this.rule.getState(states));
                }
            }           
            this.writeIteration(count+1);
            this.notificar();            
            count++;
            
        }     
        this.notificarMensaje("Informe creado.");
    }    
    
    private void writeCharacteristics(){
        file.initNameFile();
        file.writeLine("************************Autómata celular************************");        
        file.writeLine("Datos iniciales");
        file.writeLine("Iteraciones: "+Integer.toString(this.stage));
        file.writeLine("Tamaño de simulación(tamaño*tamaño): "+Integer.toString(this.side));
        file.writeLine("Porcentaje de celualas vivas: "+Integer.toString(this.liveProportion));
        file.writeLine("Celulas iniciales");
        this.writeIteration(0);
        file.writeLine("*****************************************************************");        
    }
    private void writeIteration(int iteration){
        String[][] matriz=new String[this.side][this.side];
        for(int i=0;i<this.side;i++){
            for(int j=0;j<this.side;j++){
                matriz[i][j]=Integer.toString(this.cells[i][j].getState());
            }
        }
        file.writeLine("");
        file.writeLine("*************************"+"Iteración "+Integer.toString(iteration)+"*****************************");        
        this.file.writeMatriz(matriz);
        file.writeLine("*****************************************************************");        
    }
    
}
