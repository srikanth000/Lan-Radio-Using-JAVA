/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Server;
/**
 *
 * @author srikanth
 */
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(final String[] arg)
        {
        	SwingUtilities.invokeLater(new Runnable()
            	{
                public void run()
                {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new PanelWithButton());
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                }
            });
        }
}
