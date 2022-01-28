import akka.actor.UntypedActor;

public class Printer extends UntypedActor {
	@Override
	public void onReceive(Object msg) {
		if (msg != null) {
			System.out.println("Nachricht: " + msg);
		    getContext().stop(getSelf());
		} else
			unhandled(msg);
	}

}
