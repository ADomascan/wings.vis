
public class PortSecurityManager extends SecurityManager {

	public PortSecurityManager() {
		super();
		System.setProperty("java.security.policy", "ports.policy");
	}
}