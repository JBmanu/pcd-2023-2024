package pcd.lab04.gui1_unresponsive;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MyView extends JFrame implements ActionListener {

	private final MyController controller;
	
	public MyView(final MyController controller) {
		super("My View");
		
		this.controller = controller;

        this.setSize(400, 60);
        this.setResizable(false);
		
		final JButton button1 = new JButton("Event #1");
		button1.addActionListener(this);

		final JButton button2 = new JButton("Event #2");
		button2.addActionListener(this);
		
		final JPanel buttons = new JPanel();
		buttons.add(button1);		
		buttons.add(button2);
        this.setLayout(new BorderLayout());
        this.add(buttons,BorderLayout.NORTH);

        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent ev) {
				System.exit(-1);
			}
		});
	}
	
	public void actionPerformed(final ActionEvent ev) {
		try {
            this.controller.processEvent(ev.getActionCommand());
		} catch (final Exception ex) {
		}
	}
	
	public void display() {
		SwingUtilities.invokeLater(() -> {
			this.setVisible(true);
		});
	}
	
	
}
