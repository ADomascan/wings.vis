package de.kubbillum.wings.vis.uebungen.uebung14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class SimpleServer {
	public static void main(String[] args) {
		try {

			
	        
				URL url = SimpleServer.class.getResource("SimpleServer.policy");
				System.out.println("url: " + url.toString());
				System.setProperty("java.security.policy", url.toString());
				//System.out.println("url: " + url.toString());

			// set the policy file as the system securuty policy
			//System.setProperty("java.security.policy", "src/main/java/de/kubbillum/wings/vis/uebungen/uebung15/SimpleServer.policy");

			// create a security manager
			SecurityManager sm = new SecurityManager();

			// set the system security manager
			System.setSecurityManager(sm);


			System.out.println("start SimpleServer!");
			// Erzeugt einen Server-Socket, der an den angegebenen Port gebunden ist.
			try (ServerSocket ss = new ServerSocket(8442)) {
				// ServerSocket repräsentiert einen Server, dessen Konstruktor die Nummer des
				// Ports übergeben bekommt, an dem der Server horchen soll.
				// Das try-with-resources Statement ermöglicht die Deklaration von Ressourcen,
				// die am Ende des try Blocks automatisch geschlossen werden.
				String t = null;
				// Die Variable stop dient als Bedindung, bei welcher der Server gestoppt bzw.
				// die while-Schleife nicht fortgesetzt wird.
				// Sie wird innerhalb des Servers auf true gesetzt, wenn dieser die Nachricht
				// "stop" vom Client empfängt.
				boolean stop = false;
				while (!stop) {
					// Nach Einrichten des Sockets wird durch die Methode accept() eine Verbindung
					// innerhalb einer Endlosschleife hergestellt.
					Socket s = ss.accept();
					// Innerhalb der while-Schleife werden auf gleiche Weise, wie in
					// SimpleClient.java beschrieben, Input- und OutputStreams gelesen und
					// geschrieben. Diese werden wieder vom Socket geliefert.
					BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					PrintStream out = new PrintStream(s.getOutputStream());
					t = in.readLine();
					if (t != null) {
						System.out.println("Server receives: " + t);
						if (!"stop".equals(t)) {
							out.println("Hi client!");
						} else {
							stop = true;
							out.println("The server will be stopped!");
						}
						out.flush();
					}
				}
				System.out.println("stop SimpleServer!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}