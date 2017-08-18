/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Client;
/**
 *
 * @author maheshp
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class ClientInterface{
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton start=new JButton("Connect");
	JButton stop=new JButton("Exit");	
	JPanel audio=new JPanel();
	JLabel name=new JLabel();	
	JLabel server=new JLabel();
	JPanel j6,j7;
	JLabel l12;
	
	public ClientInterface(){
		try{
			ImageIcon iu=new ImageIcon("3.png");
			l12=new JLabel(iu);
			l12.setBounds(125,15,82,80);
			panel.add(l12);

			frame.setVisible(true);
			frame.setSize(645,550);
			frame.setLayout(null);

			panel.setVisible(true);
			panel.setBounds(0,0,645,550);					//panel.setBackground(Color.orange);
			panel.setLayout(null);
			frame.add(panel);

			audio.setVisible(true);
			audio.setBounds(500,100,200,50);
			panel.add(audio);
			audio.setLayout(null);

			start.setVisible(true);
			start.setBounds(130,300,120,30);
			start.setLayout(null);							//start.setBackground(Color.green);
			start.setForeground(Color.blue);
			panel.add(start);

                        stop.setVisible(true);
			stop.setBounds(260,300,85,30);
			stop.setLayout(null);								//stop.setBackground(Color.green);
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
			server.setText("Client System");
			Font f1=new Font("Arial",Font.BOLD,18);
			server.setFont(f1);
			panel.add(server);


			JPanel j7=new JPanel(null,true);
			j7.setBounds(75,220,300,165);
			j7.setBorder(
			        BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Radio"),
				BorderFactory.createEmptyBorder(0,0,5,5)));
			panel.add(j7);

			start.addActionListener(new ActionListener() {						//Start button action
				public void actionPerformed(ActionEvent e) {
				WavFileClient aa=new WavFileClient();
				String ar[]=new String[2];
				ar[0]="1";
				ar[1]="2";
				try{
				aa.main(ar);}catch(Exception a){}
				}});
                      
                        stop.addActionListener(new ActionListener() {						  //stop button action 
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}});
		}
		catch(Exception e){}
				}
		public static void main(String args[]) throws IOException{
		new ClientInterface();
		}
}
