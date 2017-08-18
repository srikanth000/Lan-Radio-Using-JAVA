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

import java.net.*;
import java.io.*;
import java.util.*;

public class WavFileClient{
	public static void main (String [] args ) throws IOException {
    	int filesize=60022386; 							// filesize temporary hardcoded 6022386

    	long start = System.currentTimeMillis();
   	int bytesRead;
   	int current = 0;
   	Socket sock;									 // localhost for testing
	int i=0;
	 
	while(true)
    	{
	try
	{	
	    sock = new Socket("localhost",8000);				//Socket sock = new Socket("10.8.40.32",8000);
	    System.out.println("Connecting...");
	
	// receive file
    	byte [] mybytearray  = new byte [filesize];
    	InputStream is = sock.getInputStream();
   	Date date = new Date();
	String time = date.toString();
	//File wavFile = new File(time+".wav");
		
	String s="Client"+time+".wav";
	System.out.println(s);
    FileOutputStream fos = new FileOutputStream(s);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bytesRead = is.read(mybytearray,0,mybytearray.length);
    current = bytesRead;

   do {
       bytesRead =is.read(mybytearray, current, (mybytearray.length-current));
       if(bytesRead >= 0) current += bytesRead;
    	} while(bytesRead > -1);

    bos.write(mybytearray, 0 , current);
    bos.flush();
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    
    bos.close();
    sock.close();
    AudioPlayerExample1 audio=new AudioPlayerExample1();
    audio.play(s);
	}
	catch(Exception e)
	{
				System.out.println("please....wait...serve is busyyyyyy");
				System.out.println("connecting......");
	WavFileClient aa=new WavFileClient();
	}
    }
  }
}
