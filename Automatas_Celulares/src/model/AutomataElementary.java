/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DD
 */

//1=negro
//0=blanco
public class AutomataElementary  extends absAutomataCellular{
    private int stage;
    private String rule;
    private int[] binaryRules;
    private ArrayList<RuleElementary> rules;
    private FileManager file;
        
    
    public AutomataElementary(){
        super(1);
        //this.id=1;//ID de un autómata elemental
    }
    
    public AutomataElementary(int stage, int[] rules, int side) {
        super(side);
        this.stage = stage;
        this.loadRules(rules);
        this.side = side;        
        //this.id=1;//ID de un autómata elemental
    }

    
    public void setAll(int stage, int[] rules,String rule, int side) {        
        this.stage = stage;
        this.loadRules(rules);
        this.setSide(side);
        this.binaryRules=rules;
        this.rule=rule;
        this.file=new FileManager("Autómata elemental");
        //this.id=1;//ID de un autómata elemental
    }
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public ArrayList<RuleElementary> getRules() {
        return rules;
    }

    public void setRules(ArrayList<RuleElementary> rules) {
        this.rules = rules;
    }
 
    
    //Cargamos las 8 reglas
    private void loadRules(int[] rules){
        this.rules=new ArrayList<RuleElementary>();
        if (rules.length==8){
            RuleElementary rule;
            //1
            rule=new RuleElementary(1,1,1,rules[0]);
            this.rules.add(rule);
            //2
            rule=new RuleElementary(1,1,0,rules[1]);
            this.rules.add(rule);
            //3
            rule=new RuleElementary(1,0,1,rules[2]);
            this.rules.add(rule);
            //4
            rule=new RuleElementary(1,0,0,rules[3]);
            this.rules.add(rule);
            //5
            rule=new RuleElementary(0,1,1,rules[4]);
            this.rules.add(rule);
            //6
            rule=new RuleElementary(0,1,0,rules[5]);
            this.rules.add(rule);
            //7
            rule=new RuleElementary(0,0,1,rules[6]);
            this.rules.add(rule);
            //8
            rule=new RuleElementary(0,0,0,rules[7]);
            this.rules.add(rule);
        }else{
            //lanzar exeption
        }
        
    }  
    
    //inicializar matriz  de celulas por defecto
    @Override
    public void initCells(){
        for(int i=0;i<this.side;i++){
            for(int j=0;j<this.side;j++){
                this.cells[i][j]=new Cellula(0);                
            }
        }
        
        //iniciar una sola celula en 1
        this.cells[0][1+this.side/2].setState(1);
    }
    
    //Iniciar simulación
    @Override
    public void start(){              
        int[] states=new int[3];
        this.initCells();
        this.writeCharacteristics();
        this.bandera=0;
        this.notificar();   
        this.bandera=1;
        for(int i=1;i<this.side;i++){
            if (i>this.stage){
                break;
            }
            for(int j=0;j<this.side;j++){
                states[1]=this.cells[i-1][j].getState();
                if(j>0 && j<this.side-1){                       
                    states[0]=this.cells[i-1][j-1].getState();                        
                    states[2]=this.cells[i-1][j+1].getState();
                }else if(j==0){
                    states[0]=this.cells[i-1][this.side-1].getState();                    
                    states[2]=this.cells[i-1][j+1].getState();
                }else if(j==this.side-1){
                    states[0]=this.cells[i-1][j-1].getState();                        
                    states[2]=this.cells[i-1][0].getState();
                }
                this.cells[i][j].setState(this.getStetateNew(states));
            }     
            this.writeIteration(i);
            this.notificar();            
        }       
        this.notificarMensaje("Informe creado.");
    }
    
    //Obtiene el nuevo estado de una celula    
    private int getStetateNew(int[] states){
        int state=0;
        for(RuleElementary rule: this.rules){
            if(rule.getLeft()==states[0] && rule.getCenter()==states[1] && rule.getRight()==states[2]){
                state=rule.getResult();
                break;
            }
        }
        return state;
    }
    
     private void writeCharacteristics(){
        file.initNameFile();
        file.writeLine("************************Autómata celular************************");        
        file.writeLine("Datos iniciales");
        file.writeLine("Iteraciones: "+Integer.toString(this.stage));
        file.writeLine("Tamaño de simulación(tamaño*tamaño): "+Integer.toString(this.side));
        file.writeLine("Regla número: " + this.rule);
        file.writeLine("Regla en binario: " + this.getRuleString());
        file.writeLine("Celulas iniciales");
        this.writeIteration(0);
        file.writeLine("*****************************************************************");        
    }
     
    private String getRuleString(){
        String rule="";
        for (int i =0; i<this.binaryRules.length;i++){
            rule+= Integer.toString(this.binaryRules[i]);
        }
        return rule;
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
