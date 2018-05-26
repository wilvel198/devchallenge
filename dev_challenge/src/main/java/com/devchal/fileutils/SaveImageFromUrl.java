package com.devchal.fileutils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SaveImageFromUrl {

	public static void main(String[] args) throws Exception {
		String imageUrl = "https://media1.giphy.com/media/lcySndwSDLxC4eOU86/giphy.gif";
		String destinationFile = "/Users/gv91ig/panda.gif";

		wget(imageUrl);
		
		System.out.println("done");
	}
	
	public static void wget(String url) throws MalformedURLException, IOException {
		String s;
		URL u = new URL(url);

		try (InputStream is = u.openStream()) {
		BufferedReader dis = new BufferedReader(new InputStreamReader(is));
		while ((s = dis.readLine()) != null)
		{
		System.out.println(s);
		}
		}
		}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[4096];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

}