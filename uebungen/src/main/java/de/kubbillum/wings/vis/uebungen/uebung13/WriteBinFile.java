package de.kubbillum.wings.vis.uebungen.uebung13;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinFile {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.out")));
			double pi = 3.141592654;
			out.writeDouble(pi);
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