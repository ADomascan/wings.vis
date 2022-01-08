package de.kubbillum.wings.vis.uebungen.uebung13;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import de.kubbillum.wings.vis.uebungen.uebung12.WriteTextFile;

public class WriteBinFile {

	public static void main(String[] args) {
		DataOutputStream out = null;
		try {
			Path path = Paths.get(WriteBinFile.class.getResource("WriteBinFile.class").getPath().replace("/C:","")).getParent();
			System.out.println(path);
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path + "/Data.out")));
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