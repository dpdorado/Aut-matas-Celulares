/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ViewPrincipalController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Cellula;
import model.Model;
import model.absAutomataCellular;

/**
 *
 * @author DD
 */
public class pnViewPrincipla extends JPanel implements View{
    private JButton[][] buttons;
    private JPanel simu;
    /**
     * Creates new form pnViewPrincipla
     */
    public pnViewPrincipla() {
        initComponents();
        initController();
        this.pnBoard.setLayout(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxTypeSimulation = new javax.swing.JComboBox<>();
        pnOptions = new javax.swing.JPanel();
        pnSimulation = new javax.swing.JPanel();
        pnBoard = new javax.swing.JPanel();

        jLabel1.setText("Tipo simulación: ");

        cbxTypeSimulation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Juego de la vida", "Automatas elementales", "Newman" }));

        pnOptions.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnOptionsLayout = new javax.swing.GroupLayout(pnOptions);
        pnOptions.setLayout(pnOptionsLayout);
        pnOptionsLayout.setHorizontalGroup(
            pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnOptionsLayout.setVerticalGroup(
            pnOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnSimulation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnBoard.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnBoardLayout = new javax.swing.GroupLayout(pnBoard);
        pnBoard.setLayout(pnBoardLayout);
        pnBoardLayout.setHorizontalGroup(
            pnBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        pnBoardLayout.setVerticalGroup(
            pnBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnSimulationLayout = new javax.swing.GroupLayout(pnSimulation);
        pnSimulation.setLayout(pnSimulationLayout);
        pnSimulationLayout.setHorizontalGroup(
            pnSimulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSimulationLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(pnBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        pnSimulationLayout.setVerticalGroup(
            pnSimulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSimulationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(cbxTypeSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnSimulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxTypeSimulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnSimulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTypeSimulation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnBoard;
    private javax.swing.JPanel pnOptions;
    private javax.swing.JPanel pnSimulation;
    // End of variables declaration//GEN-END:variables

    public void setOptions(JPanel view){
        this.pnOptions.removeAll();
        this.pnOptions.setLayout(new BorderLayout());
        this.pnOptions.add(view,BorderLayout.CENTER);
        this.pnOptions.updateUI();
    }
    
    
    public JComboBox getTypeAutomata(){
        return this.cbxTypeSimulation;
    }
        
    private void initController(){
        ViewPrincipalController controller=new ViewPrincipalController(this,null); 
        this.cbxTypeSimulation.addItemListener(controller);
    }
    
    @Override
    public boolean actualizar(Model aModel) {        
        this.loadBoard(aModel);        
         return true;
    }
    @Override
    public void actualizar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "TDS", JOptionPane.INFORMATION_MESSAGE);
    }    
    
    
    private void loadBoard(Model aModel){         
        absAutomataCellular automata=(absAutomataCellular)aModel;
        int side=automata.getSide();
        Cellula[][] cells = automata.getCells();
        JPanel panel= this.pnBoard;        
        if (this.buttons==null){
            panel.setLayout(new GridLayout(side,side,0,0));
            this.initGrid(panel, side);
        }else if(((GridLayout)panel.getLayout()).getRows()!=side){
            panel.setLayout(new GridLayout(side,side,0,0));
            this.initGrid(panel, side);
        }   
        this.maquillaTablero(side);      
        this.initColors(this.buttons, side, cells);           
    }    
    private void initGrid(JPanel panel, int side){
        panel.removeAll();
        this.buttons=new JButton[side][side];
        for (int i=0;i<side;i++){
            for(int j=0;j<side;j++){
                JButton button=new JButton();
                String id = String.valueOf(i) +"-" + String.valueOf(j);
                button.setName(id);
                
                button.setSize(5, 5);
                button.setToolTipText(id);
                buttons[i][j]=button; 
                panel.add(button);
            }
        } 
    }
    private void initColors(JButton[][] buttons,int side,Cellula[][] cells){                       
        for (int i=0;i<side;i++){
            for(int j=0;j<side;j++){                
                switch(cells[i][j].getState()){
                    case 0:
                        buttons[i][j].setBackground(Color.WHITE);
                        break;
                    case 1:
                        buttons[i][j].setBackground(Color.BLACK);
                        break;
                }                
            }
        }
        this.pnBoard.updateUI();
    }
    public void maquillaTablero(int size)
    {
        for(int i = 0 ; i < size ; i++)
        {
            for(int j = 0; j < size ; j++)
            {
                this.buttons[i][j].setBackground(Color.BLACK);
            }
        }
    
    }
}
