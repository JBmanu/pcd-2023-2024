package pcd.lab05.chrono.version1_basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterGUI extends JFrame 
                        implements ActionListener, CounterEventListener {

	private final JButton start;
	private final JButton stop;
	private final JButton reset;
	private final JTextField display;
	
	private final Controller controller;
	private final Counter counter;
	
	public CounterGUI(final Counter c, final Controller contr){
        this.setTitle("Counter GUI");
        this.setSize(300,100);
        this.counter = c;
        this.controller = contr;
        this.display = new JTextField(5);
        this.display.setEditable(false);
        this.display.setText(""+ c.getValue());
        this.start = new JButton("start");
        this.stop = new JButton("stop");
        this.reset = new JButton("reset");
        this.stop.setEnabled(false);
		
		final Container cp = this.getContentPane();
		final JPanel panel = new JPanel();
		
		final Box p0 = new Box(BoxLayout.X_AXIS);
		p0.add(this.display);
		final Box p1 = new Box(BoxLayout.X_AXIS);
		p1.add(this.start);
		p1.add(this.stop);
		p1.add(this.reset);
		final Box p2 = new Box(BoxLayout.Y_AXIS);
		p2.add(p0);
		p2.add(Box.createVerticalStrut(10));
		p2.add(p1);
		
		panel.add(p2);
		cp.add(panel);

        this.addWindowListener(new WindowAdapter(){
			public void windowClosing(final WindowEvent ev){
				System.exit(-1);
			}
			public void windowClosed(final WindowEvent ev){
				System.exit(-1);
			}
		});

        this.start.addActionListener(this);
        this.stop.addActionListener(this);
        this.reset.addActionListener(this);
        this.counter.addListener(this);
	}
	
	public void actionPerformed(final ActionEvent ev){
		final Object src = ev.getSource();
		if (src== this.start){
            this.controller.notifyStarted();
            this.start.setEnabled(false);
            this.stop.setEnabled(true);
            this.reset.setEnabled(false);
		} else if (src == this.stop){
            this.controller.notifyStopped();
            this.start.setEnabled(true);
            this.stop.setEnabled(false);
            this.reset.setEnabled(true);
		} else if (src == this.reset){
            this.controller.notifyReset();
		}
	}
	
	public void counterChanged(final CounterEvent ev){
		SwingUtilities.invokeLater(()-> {
            this.display.setText(""+ ev.getValue());
		});
	}
	
	public void display() {
        javax.swing.SwingUtilities.invokeLater(() -> {
        	this.setVisible(true);
        });
    }
	
	
}
