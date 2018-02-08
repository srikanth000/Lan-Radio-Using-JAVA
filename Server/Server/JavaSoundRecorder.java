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

import java.util.*;
import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

/**
 * A sample program is to demonstrate how to record sound in Java
 * author: www.codejava.net
 */
public class JavaSoundRecorder {
	// record duration, in milliseconds
	static final long RECORD_TIME = 6000;	// 1 minute 60000
	// path of the wav file
	/*
	String fileName(String a)
	{
		return a;
	}*/
	// display time and date using toString()
        // System.out.println(date.toString()); 
	
	// format of audio file
	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
	// the line from which audio data is captured
	TargetDataLine line;
	 /**
	 * Defines an audio format
	 */
	AudioFormat getAudioFormat() {
		float sampleRate = 16000;
		int sampleSizeInBits = 8;
		int channels = 2;
		boolean signed = true;
		boolean bigEndian = true;
		AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
											 channels, signed, bigEndian);
		return format;
	}
	 /**
	 * Captures the sound and record into a WAV file
	 */
	String start() {
	Date date = new Date();
	String time = date.toString();
	File wavFile = new File("Server"+time+".wav");
	String s="Server"+time+".wav";										//System.out.println(s);
		
		try {
			AudioFormat format = getAudioFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

			// checks if system supports the data line
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("Line not supported");
				System.exit(0);
			}
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();	// start capturing

			System.out.println("Start capturing...");

			AudioInputStream ais = new AudioInputStream(line);

			System.out.println("Start recording...");

			// start recording
			AudioSystem.write(ais, fileType, wavFile);

			} catch (LineUnavailableException ex) {
			ex.printStackTrace();
			} catch (IOException ioe) {
			ioe.printStackTrace();
			}
		return s;
		}
	/**
	 * Closes the target data line to finish capturing and recording
	 */
	void finish() 
	{
		line.stop();
		line.close();
		System.out.println("Finished now,");
	}
	 void play() throws IOException
	{
			Thread stopper = new Thread(new Runnable() {
			
			public void run() 
			{
				try{
					Thread.sleep(RECORD_TIME);
				     } catch (InterruptedException ex) {
					ex.printStackTrace();
					}
				//recorder.finish();
				finish();
				}
	});
		stopper.start();
		// start recording

		String file=start();
		System.out.println(file);
		for(int i=0;i<1;i++){											//Change the number of clients here...
		ServerInterface.s[i]=ServerInterface.servsock.accept();
		}
		//System.out.println("djfhdkj");
		WavFileServer wfs=new WavFileServer();
		wfs.run(file);
		//sock.close();

		System.out.println("Again Start\n");
	}
	/**
	 * Entry to run the program
	 */
	public static void main(String[] args) throws IOException {
		final JavaSoundRecorder recorder = new JavaSoundRecorder();
		// creates a new thread that waits for a specified
		// of time before stopping
	}
}
