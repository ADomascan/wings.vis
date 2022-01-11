package de.kubbillum.wings.vis.uebungen.uebung15;

import java.net.URL;

public class PortSecurityManager extends SecurityManager {

	public PortSecurityManager(int allowedPortFrom, int allowedPortTo) {
		super();
		URL url = PortSecurityManager.class.getResource("ports.policy");
		System.out.println("url: " + url.toString());
		System.setProperty("java.security.policy", url.toString());
	}
}
