package de.kubbillum.wings.vis.uebungen.uebung12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;


public class WriteTextFile {

	public static void main(String[] args) {
		PrintWriter out = null;
		try {
			URL url = WriteTextFile.class.getResource("Outputfile.txt");
			out = new PrintWriter(new BufferedWriter(new FileWriter(url.getPath())));
			String pi = "3.141592654";
			out.println(pi);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}