package de.kubbillum.wings.vis.uebungen.uebung13;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import de.kubbillum.wings.vis.uebungen.uebung11.ReadTextFile;

public class ReadBinFile {

	public static void main(String[] args) {
		DataInputStream in = null;
		try {
			URL url = ReadBinFile.class.getResource("Data.out");
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(url.getPath())));
			double pi = in.readDouble();
			System.out.println("pi = " + pi);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}