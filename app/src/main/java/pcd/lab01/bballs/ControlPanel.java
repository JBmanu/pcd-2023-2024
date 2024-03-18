package pcd.lab01.bballs;

import javax.swing.*;
import java.awt.event.*;

public class ControlPanel extends JFrame implements ActionListener{
    private final JButton buttonPlus;
    private final JButton buttonMinus;
    private final Context context;
    
    public ControlPanel(final Context ctx){
        this.context = ctx;
        this.setTitle("Control Panel");
        this.setSize(250,60);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter(){
			public void windowClosing(final WindowEvent ev){
				System.exit(-1);
			}
			public void windowClosed(final WindowEvent ev){
				System.exit(-1);
			}
		});

        this.buttonPlus = new JButton("+ ball");
        this.buttonMinus = new JButton("- ball");
        final JPanel p = new JPanel();
        p.add(this.buttonPlus);
        p.add(this.buttonMinus);
        this.getContentPane().add(p);
        this.buttonPlus.addActionListener(this);
        this.buttonMinus.addActionListener(this);
    }
    
    public void actionPerformed(final ActionEvent ev){
        final Object src = ev.getSource();
        if (src== this.buttonPlus){
            this.context.createNewBall();
        } else {
            this.context.removeBall();
        }
    }
}
