package domain;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class MorpionSolitaire extends JFrame{

	MorpionSolitairePanel panel;
	
	JFrame t = new JFrame();
	JPanel pan = new JPanel (new GridLayout (3,3));
	Border blackline = BorderFactory.createLineBorder(Color.black,1); 
	{
	for(int i = 0; i<9;i++){
	   JPanel ptest = new JPanel();
	   ptest.setBorder(blackline);
	   pan.add(ptest);
	}
	
	pan.setBorder(blackline);
	t.add(pan);
	t.setVisible(true);
	
}
	
    public MorpionSolitaire() {
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        panel = new MorpionSolitairePanel();
        content.add(panel, BorderLayout.CENTER);
        setTitle("MorpionSolitaire");
        pack();
        setLocationRelativeTo(null);
    }
}

class MorpionSolitairePanel extends JPanel {
    enum State {
        START, HUMAN, BOT, OVER
    }
}
