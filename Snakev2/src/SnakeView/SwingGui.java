/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SnakeView;

import SnakeController.AbstractSnakeController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Leonardo
 */
public class SwingGui extends javax.swing.JFrame implements IGui, InterfaceEntradaController {

    
    
    private AbstractSnakeController controller;
    private int lastInput;
    private JLabel[][] labels;
    private final boolean borderSet;
    private final Color background = new Color(192, 243, 217);
    ImageIcon manzana  = new ImageIcon(new ImageIcon(getClass().getResource("manzana.gif")).getImage());
    ImageIcon naranja  = new ImageIcon(new ImageIcon(getClass().getResource("naranja.gif")).getImage());
    ImageIcon verde  = new ImageIcon(new ImageIcon(getClass().getResource("verde.gif")).getImage());
    ImageIcon ventana = new ImageIcon(new ImageIcon(getClass().getResource("manzana.png")).getImage());
    ImageIcon toasty = new ImageIcon(new ImageIcon(getClass().getResource("toasty.png")).getImage());
    private GameOver form;
    private Instrucciones formInstrucciones;
    
    /**
     * Creates new form SwingGui
     */
    public SwingGui() {
        super();
        
       form = new GameOver();
       formInstrucciones = new Instrucciones();
       formInstrucciones.setPadre(this);
       form.setPadre(this);
       formInstrucciones.setVisible(false);
       form.setVisible(false);
       initComponents();
       borderSet = false;
   

        
        
    }
    
    public AbstractSnakeController getController()
    {
        return this.controller;
    }
    
    public void setController(AbstractSnakeController controller) {
	this.controller = controller;
	jPanel1.setPreferredSize(new Dimension(controller.getAncho() * 20,
				controller.getAlto()* 20));
	jPanel1.setLayout(new GridLayout(controller.getAlto(), controller
				.getAlto()));
	jPanel1.setBackground(background);
	initLabels();
	jPanel1.setFocusable(true);
	}
    
    
    private void initLabels() {
		labels = new JLabel[controller.getAncho()][controller.getAlto()];
		for (int j = 0; j < controller.getAlto(); j++) {
			for (int i = 0; i < controller.getAncho(); i++) {
				JLabel newLabel = new JLabel(" ");
				labels[i][j] = newLabel;
				newLabel.setVisible(true);
				newLabel.updateUI();
				jPanel1.add(newLabel);
			}
		}
		jPanel1.updateUI();
	}
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jMenu2 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake Game");
        setIconImage(ventana.getImage());
        setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel1.setText("Puntaje:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(388, 362));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Jugar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Instrucciones");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
                controller.stopJugar();
		controller.resetJuego();
		Thread starter = new StarterThread();
		starter.start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
                       this.terminate();

        

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    public void terminate()
    {
                    controller.stopJugar();
                        
                        this.dispose()  ;  
                                
        }
    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

            char keyChar = evt.getKeyChar();
		// 1 = up, 2 = right, 3 = down, 4 = left, other is ignored
		if (keyChar == 'w') {	
                    lastInput = 1;
		} 
                else if (keyChar == 'd') 
                {
			lastInput = 2;
		} 
                else if (keyChar == 's') 
                {
			lastInput = 3;
		} 
                else if (keyChar == 'a') 
                {
			lastInput = 4;
                } 
                else if (keyChar == 'l')
                {
                    controller.siguiente();
                }
                else if (keyChar == 'k')
                {
                    controller.anterior();
                }
                else if (keyChar == 'm')
                {
                    controller.stopMusicaPublic();
                }
                else if (keyChar == 'p')
                {
                    controller.reproducirMusicaPublic();
                }
                
                
                
                else {
			lastInput = -1; //detecta la entrada x teclado y la guarda en una variable que 
                            //la devuelve con el getEntrada
		}
                



    }//GEN-LAST:event_jPanel1KeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        formInstrucciones.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SwingGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SwingGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SwingGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SwingGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SwingGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setSnake(int x, int y) {
        labels[x][y].setIcon(verde);

    }

    @Override
    public void setManzanas(int x, int y) {

        labels[x][y].setIcon(manzana);

    }

    @Override
    public void setBordes(int x, int y) {

        	if (!borderSet) {
                    labels[x][y].setIcon(naranja);
		}
    		

    }

    @Override
    public void setVacio(int x, int y) {
       
                 labels[x][y].setBackground(background);
                 labels[x][y].setIcon(null);

    }

    @Override
    public void setPuntaje(int score) {

    		jLabel1.setText("Puntaje: " + score);
                form.setScore(score);
                

    }
    
    @Override
    public void perdiste()
    {
        form.setVisible(true);
    }
    


    @Override
    public int getEntrada() {
        
        return lastInput; //retorna la ultimadireccion seteada mediante teclado por el usuario
    }



    //CLASE PRIVADA QUE REPRESENTA UN THREAD, COLOCA EN TRUE EL ESTA JUGANDO Y EJECUTA EL LOOP
    
    private class StarterThread extends Thread {
		@Override
		public void run() {
			lastInput = -1;
			controller.setEstaJugando();
			controller.jugar();
             
		}
	}






}
