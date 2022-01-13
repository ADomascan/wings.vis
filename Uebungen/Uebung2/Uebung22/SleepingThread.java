import java.util.Date;

public class SleepingThread extends Thread {
	public void run () {
		Date startTime = new Date();
		try {
			Thread.currentThread().sleep((int) (20000 * Math.random()));
		} catch (Exception es) {
			
		}
		long elapsedTime = new Date().getTime() - startTime.getTime();
		System.out.println(Thread.currentThread().getName() +" with priority " + Thread.currentThread().getPriority() + " slept for " + elapsedTime + "milliseconds");
	}
}
