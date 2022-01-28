import java.util.Scanner;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class QueryApp extends UntypedActor {

	@Override
	public void preStart() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Ihre Flugpreissuche");
		System.out.println("===================");
		System.out.print("Start: ");
		String from = sc.nextLine();
		System.out.print("Ziel: ");
		String to = sc.nextLine();

		ActorSystem system = ActorSystem.create("test-system");
		final ActorRef bookingSite = system.actorOf(Props.create(BookingSite.class), "bookingSite");
		Flight flightRequest = new Flight(from.toUpperCase(), to.toUpperCase(), null);
		bookingSite.tell(flightRequest, getSelf());
		System.out.println("Suchergebnisse: ");
		System.out.println();
		sc.close();


		// system.scheduler().schedule(Duration.Zero(), Duration.create(5000,
		// TimeUnit.MILLISECONDS), echo, "Hello, world 123...!", system.dispatcher(),
		// null);

		// system.stop(bookingSite);
		// system.stop(getSelf());
		// system.terminate();
	}

	@Override
	public void onReceive(Object msg) {
		if (msg != null) {
			System.out.println("Nachricht an EchoApp: " + msg);
			getSender().tell(msg, getSelf());
		} else
			unhandled(msg);
	}

}