/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Server;
/**
 *
 * @author maheshp
 */

import java.util.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class ServerInterface{
	static ServerSocket servsock;
	static Socket s[];
	JFrame frame=new JFrame();				//Total Original frame...
	JPanel panel=new JPanel();				//Total panel in frame...
	JButton start=new JButton("Start");		//Start button...
	JButton stop=new JButton("Exit");			//Stop button...
	JPanel audio=new JPanel();
	JLabel name=new JLabel();				//Label for main title...
	JLabel server=new JLabel();				//Label of System title...
	JProgressBar pg1;						//Progress bar...
	int i=0;
	JPanel j6,j7;							//For Label around buttons
	JLabel l12;
	
	public ServerInterface(){
		try{
			ImageIcon iu=new ImageIcon("3.png");
			l12=new JLabel(iu);
			l12.setBounds(125,15,82,80);
			panel.add(l12);

			frame.setVisible(true);
			frame.setSize(645,550);
			frame.setLayout(null);

			panel.setVisible(true);
			panel.setBounds(0,0,645,550);							//panel.setBackground(Color.orange);
			panel.setLayout(null);
			frame.add(panel);

			audio.setVisible(true);
			audio.setBounds(500,100,200,50);
			panel.add(audio);
			audio.setLayout(null);

			start.setVisible(true);
			start.setBounds(130,300,80,30);
			start.setLayout(null);								//start.setBackground(Color.green);
			start.setForeground(Color.blue);
			panel.add(start);

                        stop.setVisible(true);
			stop.setBounds(220,300,80,30);
			stop.setLayout(null);									//stop.setBackground(Color.green);
			stop.setForeground(Color.blue);
			panel.add(stop);

			name.setVisible(true);
			name.setBounds(225,15,250,75);
			name.setText("Client Server Stream");
			Font f=new Font("Arial",Font.BOLD,20);
			name.setFont(f);
			name.setForeground(Color.red);
			panel.add(name);

			server.setVisible(true);
			server.setBounds(265,55,250,75);
			server.setText("Server System");
			Font f1=new Font("Arial",Font.BOLD,18);
			server.setFont(f1);
			panel.add(server);

			pg1=new JProgressBar();
			pg1.setBounds(425,460,160,25);
			panel.add(pg1);
			pg1.setValue(0);
			pg1.setStringPainted(true);


			JPanel j6=new JPanel(null,true);
			j6.setBounds(420,445,170,45);
			j6.setBorder(
			      BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Progress"),
				BorderFactory.createEmptyBorder(0,0,5,5)));
			panel.add(j6);

			JPanel j7=new JPanel(null,true);
			j7.setBounds(75,220,300,165);
			j7.setBorder(
			      BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Radio"),
				BorderFactory.createEmptyBorder(0,0,5,5)));
			panel.add(j7);

			start.addActionListener(new ActionListener() {					//Start button action
				public void actionPerformed(ActionEvent e) {
				try{
				servsock = new ServerSocket(8000);						//Creating a socket
					s=new Socket[1];								//Change the number of clients here....
				}catch(IOException io){}
				MainClass aa=new MainClass();
				String ar[]=null;
				try{
				aa.main(ar);}catch(Exception a){}
				}});
                       
                        stop.addActionListener(new ActionListener() {					 //stop button action 
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}});
			}catch(Exception e){}}
		public static void main(String args[]) throws IOException{
		new ServerInterface();
		}
}
