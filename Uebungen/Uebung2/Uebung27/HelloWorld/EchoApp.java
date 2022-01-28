import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import scala.concurrent.duration.Duration;

public class EchoApp extends UntypedActor {

	@Override
	public void preStart() {
		ActorSystem system = ActorSystem.create("test-system");
		final ActorRef echo = system.actorOf(Props.create(Echo.class), "echo");
		//echo.tell("Hello, world...!", getSelf());
		
		system.scheduler().schedule(Duration.Zero(), Duration.create(5000, TimeUnit.MILLISECONDS), echo, "Hello, world", system.dispatcher(), null);
		
		//system.stop(echo);
		//system.stop(getSelf());
		//system.terminate();
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