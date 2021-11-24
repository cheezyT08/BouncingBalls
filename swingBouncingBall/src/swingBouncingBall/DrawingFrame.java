package swingBouncingBall;

//@author Torin

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class DrawingFrame extends JFrame {
	public DrawingPanel dp = new DrawingPanel();
	public JLabel l = new JLabel("Horizontal Velocity:");
	public JSlider sldVelX = new JSlider(JSlider.HORIZONTAL, 0, 25, 2);
	public JPanel p = new JPanel();
	public JButton bRS = new JButton("Reset Position");
	
	public DrawingFrame() {
		setTitle("Bouncing Ball");
		setResizable(false);
		setSize(DrawingPanel.WIDTH, DrawingPanel.HEIGHT+20);
		setLayout(new BorderLayout());
		p.setBackground(Color.WHITE);
		l.setBackground(Color.WHITE);
		l.setFont(new Font("Sans-Serif", Font.BOLD, 25));
		sldVelX.setBackground(Color.WHITE);
		sldVelX.setMajorTickSpacing(5);
		sldVelX.setMinorTickSpacing(1);
		sldVelX.setPaintTicks(true);
		sldVelX.setPaintLabels(true);
		sldVelX.addChangeListener(new velLstnr());
		sldVelX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
		bRS.addActionListener(new rsLstnr());
		p.add(l);
		p.add(sldVelX);
		p.add(bRS);
		add(p, BorderLayout.NORTH);
		add(dp, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public class velLstnr implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			int inVelX = sldVelX.getValue();
			if(inVelX > 0 && dp.velX <= 0) {
				dp.setVelocityX(inVelX*-1);
			} else {
				dp.setVelocityX(inVelX);
			}
		}

	}
	
	public class rsLstnr implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dp.pX = DrawingPanel.MIN_X_P;
			dp.pY = DrawingPanel.MIN_Y_P;
			dp.velY = 0;
			
			int inVelX = sldVelX.getValue();
			if(inVelX > 0 && dp.velX <= 0) {
				dp.setVelocityX(inVelX*-1);
			} else {
				dp.setVelocityX(inVelX);
			}
		}

	}
	
}
