package Libro;

import SnakeController.ReproductorController;
import SnakeModel.ReproductorModel;
import SnakeModel.ReproductorModelInterface;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DJView implements ActionListener,  BeatObserver, BPMObserver {
	BeatModelInterface model;
	ControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
	BeatBar beatBar;
	JLabel bpmOutputLabel;
    JFrame controlFrame;
    JPanel controlPanel;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem startMenuItem;
    JMenuItem stopMenuItem;
    JMenu menuModels;
    JMenuItem modelBeat;
    JMenuItem modelHeart;
    JMenuItem modelReproductor;
    

    public DJView(ControllerInterface controller, BeatModelInterface model) {	
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
    }

    

    
    
    public void createView() {
		// Create all Swing components here
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
	}
  
    public ControllerInterface getController()
    {
        return this.controller;
    }
    public void setController(ControllerInterface controllerNuevo)
    {
        this.controller = controllerNuevo;
    }
    
    public void setModel(BeatModelInterface modelNuevo)
    {
        this.model = modelNuevo;
    
    }
    
    public void hacerInvisible()
    {
        this.viewFrame.setVisible(false);
        this.controlFrame.setVisible(false);
    }
    
    public void hacerVisible()
    {
        this.viewFrame.setVisible(true);
        this.controlFrame.setVisible(true);
    }
    public  BeatModelInterface getInterface()
    {
        return this.model;
    }
    
    public void registerAgain()
    {
       model.registerObserver((BeatObserver)this);
       model.registerObserver((BPMObserver)this); 
    }
    
    public void cerrar()
    {
        this.viewFrame.dispose();
        this.controlFrame.dispose();

    }
    
    public void ocultarMenuModels()
    {
        menuModels.setEnabled(false);
    }
  
    
    public void verMenuModels()
    {
        menuModels.setEnabled(true);
    }
    public void createControls() {
		// Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));

        controlPanel = new JPanel(new GridLayout(1, 2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJ Control");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        
        menuModels = new JMenu("Modelos");      //Aca creo el menu de Models
        modelBeat = new JMenuItem("El beat");
        menuModels.add(modelBeat);
        
        modelBeat.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                //Programar para que se ejecute el model Beat
                BeatModelInterface model = new BeatModel();
                ControllerInterface controller = new BeatController(model);
                removeObservers();
                cerrar();
            }
        });
        
       
        
        
        
        
        modelHeart = new JMenuItem("El Heart");
        menuModels.add(modelHeart);
        
        modelHeart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                // programar para que se ejecute el modelo Heart
               	HeartModel heartModel = HeartModel.getInstancia();
                ControllerInterface model1 = new HeartController(heartModel);
                removeObservers();
                cerrar();
     
            
               
                
            }


    });

        modelReproductor = new JMenuItem("El Reproductor");
        menuModels.add(modelReproductor);
        
        modelReproductor.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event){ 
               try {
                   ReproductorModelInterface model = new ReproductorModel();
                   ControllerInterface controller = new ReproductorController(model);
                   removeObservers();
                   cerrar();
               } // programar para que se ejecute el modelo Reproductor
               catch (Exception ex) {
                   Logger.getLogger(DJView.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
        }
        });
               
        
        startMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.start();
            }
        });
        stopMenuItem = new JMenuItem("Stop");
        menu.add(stopMenuItem); 
        stopMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                controller.stop();
            }
        });
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        menu.add(exit);
        menuBar.add(menu);
        menuBar.add(menuModels);
        controlFrame.setJMenuBar(menuBar);

        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10,40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);
        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);
        controlPanel.add(insideControlPanel);
        
        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
       
    }

        public void removeObservers()
        {
            model.removeObserver((BPMObserver)this);
            model.removeObserver((BeatObserver)this);
            model.off();
        }
    
    public void enableStopMenuItem() {
    	stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
    	stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
    	startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
    	startMenuItem.setEnabled(false);
	}
        
        public void enableModelReproductor(){
        
            modelReproductor.setEnabled(true);
        }
        
        public void disableModelReproductor()
        {
            modelReproductor.setEnabled(false);
        }
        
         public void enableModelHeart(){
        
            modelHeart.setEnabled(true);
        }
        
        public void disableModelHeart()
        {
            modelHeart.setEnabled(false);
        }
        
        public void enableModelBeat(){
        
            modelBeat.setEnabled(true);
        }
        
        public void disableModelBeat()
        {
            modelBeat.setEnabled(false);
        }
        
        

    public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			int bpm = Integer.parseInt(bpmTextField.getText());
        	controller.setBPM(bpm);
		} else if (event.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
    }

	public void updateBPM() 
        {
		if(model != null) 
                {
                    if(model instanceof HeartAdapter)
                    {
                        if(bpmOutputLabel != null)
                            bpmOutputLabel.setText(HeartModel.getLlamadas());
                    }
                    else
                    {
			int bpm = model.getBPM();
                        
			if(bpm == 0) 
                        {
				if (bpmOutputLabel != null) 
                                    bpmOutputLabel.setText("offline");	
			} 
                        else 
                        {
				if(bpmOutputLabel != null)
                                    bpmOutputLabel.setText("Current BPM: " + 
                                                           model.getBPM());	
			}
                    }
		}
	}
  
	public void updateBeat() {
		if (beatBar != null) {
			 beatBar.setValue(100);
		}
	}
        
        public DJView returnEste()
        {
            return this;
        }
}
