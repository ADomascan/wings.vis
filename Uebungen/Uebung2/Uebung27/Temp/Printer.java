package test;

import akka.actor.AbstractActor;

public class Printer extends AbstractActor {
	public static enum Msg {
		GREET, DONE;
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder().matchEquals("printit", p -> {
	        System.out.println("The address of this actor is: " + getSelf());
	    }).build();
		
	}

}
