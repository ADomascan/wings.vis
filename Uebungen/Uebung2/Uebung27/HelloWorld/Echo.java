import akka.actor.UntypedActor;

public class Echo extends UntypedActor {
	@Override
	public void onReceive(Object msg) {
		if (msg != null) {
			//System.out.println("Nachricht an Echo: " + msg);
			getSender().tell(msg + "(zurückgesendet von Echo) | ", getSelf());
		} else
			unhandled(msg);
	}

}
