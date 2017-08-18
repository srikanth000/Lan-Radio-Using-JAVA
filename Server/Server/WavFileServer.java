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

import java.net.*;
import java.io.*;
import java.util.*;

public class WavFileServer  {
	// create socket
    	void run(String s) throws IOException{
        System.out.println("Waiting...");
		for(int i=0;i<1;i++)
	{																//Change the number of clients here...
		Socket sock=ServerInterface.s[i];									//new Socket();
       																	//sock = servsock.accept();
      		System.out.println("Accepted connection : " + sock);
      	
      // sendfile
      File myFile = new File (s);
      byte [] mybytearray  = new byte [(int)myFile.length()];
      FileInputStream fis = new FileInputStream(myFile);
      BufferedInputStream bis = new BufferedInputStream(fis);
      bis.read(mybytearray,0,mybytearray.length);
      OutputStream os = sock.getOutputStream();
      System.out.println("Sending...");
      os.write(mybytearray,0,mybytearray.length);
      os.flush();
     
      sock.close();
	}

     String[]args=null;
     JavaSoundRecorder jsr=new JavaSoundRecorder();
     jsr.main(args);
     System.out.println("ThanQ\n");
   }
}
