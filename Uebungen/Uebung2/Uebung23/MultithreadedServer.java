import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {
	public static void main(String[] args) {
		try {
			// Das try-with-resources Statement ermoeglicht die Deklaration von Ressourcen,
			// die am Ende des try Blocks automatisch geschlossen werden.

			// ServerSocket repraesentiert einen Server, dessen Konstruktor die Nummer des
			// Ports uebergeben bekommt, an dem der Server horchen soll.
			try (ServerSocket ss = new ServerSocket(8442)) { // Hochschulkennung st191442 => Port: 8442
				System.out.println("START MultithreadedServer!");
				while (true) {
					// Nach Einrichten des Sockets wird durch die Methode accept() eine Verbindung
					// innerhalb einer Endlosschleife hergestellt.
					Socket socket = ss.accept();
					if (socket != null) {
						// Wenn accept() einen Socket zurückliefert, wird ein neuer ConnectionThread gestartet.
						ConnectionThread ct = new ConnectionThread(socket);
						ct.start();
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}