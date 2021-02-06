package org.gliderwiki.Sound_Vanila;

import java.io.File;

import org.jtransforms.fft.DoubleFFT_1D;

public class testMerge {
	
	static int kk ;
	
	  public static double[] realFFT(File file)
	    {
	        // Get the .wav data using the readWav class
	        double[] data_to_fft = readWav.getWavData(file);

	        /* Get the length of the array.
	        Since we are feeding real numbers into the fft,
	        the length of the array should be equal to the
	        number of frames, which we get using the readWav class. */
	        int n = (int) readWav.getWavFrames(file);
	        
	        kk = n;

	        // Make a new fft object
	        DoubleFFT_1D fft = new DoubleFFT_1D(n);

	        // Perform the realForward fft
	       // fft.realForward(data_to_fft);
	        fft.complexForward(data_to_fft); //a 배열에 output overwrite

	        // Return the final data
	        return data_to_fft;
	    }
	  
	  
	  public static void main( String[] args )
	    {
		  
		  	File fichier_son = new File("C:\\Users\\sangsu\\Desktop\\piano_DATA\\pianoSample_C4.wav");
	        double[] test = realFFT(fichier_son); 
		  
	    	
	        double[] mag = new double[kk/2];
	        for(int k=0;k<kk/2;k++){
	           mag[k] = Math.sqrt(Math.pow(test[2*k],2)+Math.pow(test[2*k+1],2)  );
	        }
	        
	       for(int m=0; m<512; m++) {
	    	    System.out.println(m/4 + " 주파수 : " + mag[m]);
	       }
	       
	    }

}
