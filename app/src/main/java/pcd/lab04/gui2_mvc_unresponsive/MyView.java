package pcd.lab04.gui2_mvc_unresponsive;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class MyView extends JFrame implements ActionListener, ModelObserver {

	private final MyController controller;
	private final JTextField state;
	
	public MyView(final MyController controller) {
		super("My View");
		
		this.controller = controller;

        this.setSize(400, 60);
        this.setResizable(false);
		
		final JButton button1 = new JButton("Event #1");
		button1.addActionListener(this);

		final JButton button2 = new JButton("Event #2");
		button2.addActionListener(this);

        this.state = new JTextField(10);
		
		final JPanel panel = new JPanel();
		panel.add(button1);		
		panel.add(button2);	
		panel.add(this.state);

        this.setLayout(new BorderLayout());
        this.add(panel,BorderLayout.NORTH);

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

	@Override
	public void modelUpdated(final MyModel model) {
        this.state.setText("state: "+model.getState());
	}

	public void display() {
		SwingUtilities.invokeLater(() -> {
			this.setVisible(true);
		});
	}

}
