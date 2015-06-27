
package Snake.SnakeView;
import sun.awt.resources.awt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */

    
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.Utilities;
import Snake.SnakeController.*;
    
public class SnakeView extends javax.swing.JFrame implements IGui, IInputController {
    
    private JLabel arrayLabels[][];
    private final boolean borderSet;
    private final Color background = new Color(255,255,255);
    private SnakeController controller;
    private int lastInput;

  
    
    public SnakeView(){
    super("Snake Game");
    borderSet = false;
    initializer();
    try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("No se puede encontrar");
	}
    }
    
   	public void setSnake(int x, int y) {
		arrayLabels[x][y].setText("@");
              //  ImageIcon icon = new ImageIcon("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\proyecto\\images\\Verde.png");
               // arrayLabels[x][y].setIcon(icon);

	}

		public void setBoni(int x, int y) {
		arrayLabels[x][y].setText("*");
                //ImageIcon icon = new ImageIcon("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\proyecto\\images\\Rojo.png");
                //arrayLabels[x][y].setIcon(icon);
       
                }

		public void setBorder(int x, int y) {
		if (!borderSet) {
			//ImageIcon icon = new ImageIcon("C:\\Users\\Leonardo\\Documents\\tp-IngSoft\\src\\proyecto\\images\\Naranja.png");
                        //arrayLabels[x][y].setText("#");
                      //  arrayLabels[x][y].setIcon(icon);
		}
	}

		public void setEmpty(int x, int y) {
		arrayLabels[x][y].setText(" ");
	}

		public void setScore(int score) {
		jLabel1.setText("Puntaje: " + score);
	}

		public void sendMessage(String message) {
		jLabel2.setText(message);
	}


    
    private void initializer(){
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
 

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyPressed(java.awt.event.KeyEvent evt){
                jPanel1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 384,
                            Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
                            javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 358,
                            Short.MAX_VALUE));
        
        jLabel1.setText("Puntaje");
	jMenu1.setText("Menu");
    
        

	jMenuItem1.setText("Jugar");
        jMenuItem2.setText("Salir");     
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);        
        jMenuBar1.add(jMenu1);
        this.setJMenuBar(jMenuBar1);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
        });
        
        jMenuItem2.addActionListener(new java.awt.event.ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    
                    jMenuItem2ActionPerformed(evt);
                }
        });
                
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                            getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                            layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addGroup(
                                                                            layout.createParallelGroup(
                                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(
                                                                                                            jPanel1,
                                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGroup(
                                                                                                            layout.createSequentialGroup()
                                                                                                                            .addComponent(
                                                                                                                                            jLabel1)
                                                                                                                            .addGap(248,
                                                                                                                                            248,
                                                                                                                                            248)
                                                                                                                            .addComponent(
                                                                                                                                            jLabel2,
                                                                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                            190,
                                                                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addContainerGap(
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            Short.MAX_VALUE)));
            layout.setVerticalGroup(layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                            layout.createSequentialGroup()
                                                            .addGroup(
                                                                            layout.createParallelGroup(
                                                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(jLabel1)
                                                                                            .addComponent(
                                                                                                            jLabel2,
                                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                            17,
                                                                                                            javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(30, 30, 30)
                                                            .addComponent(jPanel1,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addContainerGap(46, Short.MAX_VALUE)));

            pack();
    }
    
private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)
{
	controller.detenerJuego();
        controller.resetear();
        Thread inicio = new IniciadorDeHilo();
        inicio.run();
        

}

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)
{
    controller.detenerJuego();
    this.dispose();
}

private void jPanel1KeyPressed(java.awt.event.KeyEvent evt){
    char keyChar = evt.getKeyChar();
		// 1 = arriba, 2 = derecha , 3 = abajo, 4 = izquierda, no existen otras direcciones
		if (keyChar == 'w') {
			lastInput = 1;
		} else if (keyChar == 'd') {
			lastInput = 2;
		} else if (keyChar == 's') {
			lastInput = 3;
		} else if (keyChar == 'a') {
			lastInput = 4;
		} else {
			lastInput = -1;
		}
}


    
    public void setMatrixOfLabels()
    {
		//arrayLabels = new JLabel[controller.getWidth()][controller.getHight()];
                arrayLabels = new JLabel[controller.getAncho()][controller.getAlto()];
		//for (int j = 0; j < controller.getHight(); j++) {
		//	for (int i = 0; i < controller.getWidth(); i++) {
                for (int j= 0; j< controller.getAlto(); j++){
                    for (int i=0; i<controller.getAncho() ;i++){
                        
				//
   
                               JLabel newLabel = new JLabel("");
				arrayLabels[i][j] = newLabel;
				newLabel.setVisible(true);
				newLabel.updateUI();
				jPanel1.add(newLabel);
			}
		}
		jPanel1.updateUI();
	}

    	public void setController(SnakeController controller) {
		this.controller = controller;
		jPanel1.setPreferredSize(new Dimension(controller.getAncho() * 20,
				controller.getAlto() * 20));
		jPanel1.setLayout(new GridLayout(controller.getAncho(), controller
				.getAlto()));
		jPanel1.setBackground(background);
		setMatrixOfLabels();
		jPanel1.setFocusable(true);
	}
    
 
    
    	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JPanel jPanel1;

    @Override
    public void updateUI() {
    }

    @Override
    public int getInput() {
        return lastInput;
    }

        
        
        
        
        
     private class IniciadorDeHilo extends Thread
      {
        @Override
        public void run()
        {
        lastInput = -1;
        controller.isJugando();
        controller.jugar();
        }
    }
}
