package de.kubbillum.wings.vis.uebungen.uebung14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleClient {

	public static void main(String[] args) {
		// Initialisierung des Sockets; bidirektionale
		// Netzwerk-Kommunikationsschnittstelle, deren Verwaltung das Betriebssystem
		// übernimmt.
		Socket s = null;
		Scanner sc = null;
		// Liste mit Nachrichten, die nacheinander an den Server gesendet werden.
		List<String> messages = new ArrayList<String>();
		messages.add("Hello server!");
		messages.add("How are you?");
		messages.add("stop"); // Die Nachricht "stop" erzwingt das Stoppen des Servers.
		String message = null;
		try {
//			for (String m : messages) {
			sc = new Scanner(System.in);
			while (!"stop".equals(message)) {
				// Einrichtung der Socketverbindung über Port 8441 zu localhost
				// !!! localhost anstelle von rivera.wi.hs-wismar.de
				s = new Socket("localhost", 8442); // Kennung st191442 => Port: 8442
				// BufferedReader: Filter zur Pufferung von Eingaben, kann verwendet werden, um
				// die Performance beim Lesen von externen Dateien zu erhöhen. Da nicht jedes
				// Byte einzeln gelesen wird, verringert sich die Anzahl der Zugriffe auf den
				// externen Datenträger, und die Lesegeschwindigkeit erhöht sich.
				// s.getInputStream(): liefert InputStream, aus dem gelesen werden kann
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// PrintStream wird zum Schreiben von Strings verwendet
				// s.getOutputStream(): liefert OutputStream, in den geschrieben werden kann
				PrintStream out = new PrintStream(s.getOutputStream());
				// out.println(): Schreibt den gewünschten String und fügt automatisch einen
				// Zeilenumbruch an
				
			
				// Einlesen der Eingabe in den String "message"
				System.out.print("Client: ");
				message = sc.nextLine();
				// Schließen des Scanners (nicht nötig, aber empfohlen)
				
				//
				// System.out.println("eingabe: " + eingabe);
				// Einlesen der Eingabe in den String "eingabe"
				out.println(message);
				// out.flush(): Leert den Ausgabestream und erzwingt das Ausschreiben aller
				// gepufferten Ausgabebytes
				out.flush();
				// in.readLine(): liest eine komplette Textzeile als String
				String t = in.readLine();
				System.out.println("Server: " + t);
			}
			// Probleme bei den Input-Output-Vorgängen oder ein falscher Host-Name können
			// Exceptions werfen, die im try-catch-Block abgefangen werden
		} catch (

		IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (s != null) {
				try {
					s.close();
					sc.close();
				} catch (IOException e) {
					System.out.println("Socket nicht zu schliessen...");
					System.out.println(e.getMessage());
				}
			}
		}
	}
}