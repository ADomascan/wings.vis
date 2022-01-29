import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props; 
import akka.actor.UntypedActor;
import scala.concurrent.duration.Duration;

public class EchoApp extends UntypedActor {
	//javac -classpath '*' ./*.java -d classes && jar -cvf HelloWorld.jar -C classes/ . && clear &&  java -classpath "*" akka.Main EchoApp 
	
	@Override
	public void preStart() {
		ActorSystem system = ActorSystem.create("test-system");
		final ActorRef echo = system.actorOf(Props.create(Echo.class), "echo");
		// echo.tell("Hello, world...!", getSelf());
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(formatter.format(date));

		new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

		// This object contains the current date value
		// System.out.println(formatter.format(date));
	
		final ActorRef receiver = system.actorOf(Props.create(Receiver.class), "receiver");

		system.scheduler().schedule(Duration.Zero(), Duration.create(3000, TimeUnit.MILLISECONDS), echo,
				"Hello, world! (ursprünglich gesendet von EchoApp-Scheduler) | ",
				system.dispatcher(), receiver);

		// system.stop(echo);
		// system.stop(getSelf());
		// system.terminate();
	}

	@Override
	public void onReceive(Object msg) {
		if (msg != null) {
			// TODO
		} else
			unhandled(msg);
	}

}