import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class PrinterApp extends UntypedActor {

	@Override
	public void preStart() {
		ActorSystem system = ActorSystem.create("test-system");
		final ActorRef greeter = system.actorOf(Props.create(Printer.class), "greeter");
		greeter.tell("Hello, world...!", getSelf());
		getContext().stop(getSelf());
		system.stop(greeter);
		system.terminate();
	}
	
	@Override
	public void onReceive(Object msg) {
		// TODO;
	}
}