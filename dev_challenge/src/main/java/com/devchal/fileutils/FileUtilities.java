package com.devchal.fileutils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.log4j.Logger;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;








public class FileUtilities {
	
	static Logger logger = Logger.getLogger(FileUtilities.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("--------------- RUNNING FILE UTILITES -------------");
		
		String fileURL = "https://media.giphy.com/media/feqkVgjJpYtjy/giphy.gif";
		String outFilePath = "/Users/gv91ig/giphy1.gif";
		File outFile = new File(outFilePath);
		
		try {
			URL imageUrl = new URL(fileURL);
			
			try (InputStream in = imageUrl.openStream()) {
			    Files.copy(in, new File(outFilePath).toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		logger.info("DONE");
	

	}
	
	public static void saveUrl(final String filename, final String urlString)
	        throws MalformedURLException, IOException {
	    BufferedInputStream in = null;
	    FileOutputStream fout = null;
	    try {
	        in = new BufferedInputStream(new URL(urlString).openStream());
	        fout = new FileOutputStream(filename);

	        final byte data[] = new byte[2048];
	        int count;
	        while ((count = in.read(data, 0, 2048)) != -1) {
	            fout.write(data, 0, count);
	        }
	    } finally {
	        if (in != null) {
	            in.close();
	        }
	        if (fout != null) {
	            fout.close();
	        }
	    }
	}
	public static void downloadFile(String urli, File outputFile)
			throws IOException, MalformedURLException {

		long startTime = System.currentTimeMillis();

		// Get a connection to the URL and start up a buffered reader.
		URL url = new URL(urli);
		url.openConnection();
		InputStream reader = url.openStream();

		// Setup a buffered file writer to write out what we read from the
		// website.
		FileOutputStream writer = new FileOutputStream(outputFile);
		byte[] buffer = new byte[153600];
		long totalBytesRead = 0;
		int bytesRead = 0;

		while ((bytesRead = reader.read(buffer)) > 0) {
			writer.write(buffer, 0, bytesRead);
			// buffer = new byte[153600];
			totalBytesRead += bytesRead;
			// logger.debug("Downloaded {} Kb ", (totalBytesRead / 1024));
		}

		long endTime = System.currentTimeMillis();


		writer.close();
		reader.close();
	}

	public static String encodeFile(String fileLocation){
		String encodedFile = null;
		
		
		
		return encodedFile;
	}
	

	

	

	
	  public static byte[] toByteArray(String fileLoc) throws Exception {
		  
	        File file = new File(fileLoc);
	        int length = (int) file.length();
	        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
	        byte[] bytes = new byte[length];
	        reader.read(bytes, 0, length);
	        reader.close();
	        return bytes;
	 
	    }
	  
	  public static InputStream getFileFromWeb(String fileURL) throws IOException{
		  
		  InputStream in = null;
		  
		  URL url = new URL(fileURL);   
		    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();   
		    try 
		    {     
		        in = new BufferedInputStream(urlConnection.getInputStream());     
		       // readStream(in);  <-----NO SUCH METHOD
		    }
		    finally 
		    {     
		       // urlConnection.disconnect();   
		    } 
		  
		 
		    
		  return in;
	  }
	  
	  public static byte[] convert2ByteArray(InputStream is)
			    throws IOException{
			        ByteArrayOutputStream baos = new ByteArrayOutputStream();
			        int reads = is.read();
			       
			        while(reads != -1){
			            baos.write(reads);
			            reads = is.read();
			        }
			      
			        return baos.toByteArray();
			       
			    }
	  
	  private static Path download(String sourceURL, String targetDirectory) throws IOException
	  {
	      URL url = new URL(sourceURL);
	      String fileName = sourceURL.substring(sourceURL.lastIndexOf('/') + 1, sourceURL.length());
	      Path targetPath = new File(targetDirectory + File.separator + fileName).toPath();
	      Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

	      return targetPath;
	  }
	  
}

