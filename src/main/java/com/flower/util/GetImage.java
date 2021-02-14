package com.flower.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
 
 
public class GetImage {
	public static void main(String args[]) {
		String fileUrl = "http://172.18.177.2:8080/?action=snapshot";
		String savePath = "d:\\test.jpg";
		try {
			URL url = new URL(fileUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream in = new DataInputStream(connection.getInputStream());
			DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			connection.disconnect();
 
		} catch (Exception e) {
			System.out.println(e + fileUrl + savePath);
		}
	}
	public static String getPicture(String savePath,String fileUrl){
		{
			/*String fileUrl = "http://172.18.177.2:8080/?action=snapshot";
			String savePath = "d:\\test.jpg";*/
			try {
				URL url = new URL(fileUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				DataInputStream in = new DataInputStream(connection.getInputStream());
				DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
				byte[] buffer = new byte[4096];
				int count = 0;
				while ((count = in.read(buffer)) > 0) {
					out.write(buffer, 0, count);
				}
				out.close();
				in.close();
				connection.disconnect();

			} catch (Exception e) {
				return "-1";
				//System.out.println(e + fileUrl + savePath);
			}
		}
		return "1";
	}
}