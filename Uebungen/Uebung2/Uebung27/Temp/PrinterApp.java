package test;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class PrinterApp extends AbstractActor {
	private String text;

	/*
	 * Die interne Klasse Props enthält die Akteurskonfiguration. Hier werden
	 * Komponenten wie wie der Dispatcher, die Mailbox oder die Einsatzkonfiguration
	 * konfiguriert. Diese Klasse ist unveränderlich und daher thread-sicher, sodass
	 * sie bei der Erstellung neuer Akteure gemeinsam genutzt werden kann.
	 * 
	 * Es wird dringend empfohlen und gilt als Best-Practice, die Factory-Methoden
	 * innerhalb des Actor-Objekts zu definieren, das die Erstellung des
	 * Props-Objekts übernehmen wird.
	 * 
	 * Zur Veranschaulichung wollen wir einen Akteur definieren, der eine
	 * Textverarbeitung vornimmt. Der Akteur erhält ein String-Objekt, mit dem er
	 * die Verarbeitung durchführen wird:
	 * 
	 */
	public static Props props(String text) {
		return Props.create(PrinterApp.class, text);
	}

	@Override
	public void preStart() {
		// Definition eines ActorSystems mit der Standardkonfiguration und einem eigenen
		// Namen
		ActorSystem system = ActorSystem.create("test-system");
		// Nachdem wir nun unseren ersten Akteur erstellt haben, nehmen wir ihn in das
		// ActorSystem auf
		ActorRef printer = system.actorOf(Props.create(Printer.class), "my-actor");
		
		printer.tell("Hello World!", getSelf());

	}

	@Override
	public Receive createReceive() {
		return receiveBuilder().matchEquals("printit", p -> {
	        System.out.println("The address of this actor is: " + getSelf());
	    }).build();
	}
}
