package project_16x16.multiplayer;

import java.net.ConnectException;
import processing.data.JSONObject;
import processing.net.*;

import project_16x16.SideScroller;

public class Multiplayer {

	/**
	 * A client connects to a server and sends data back and forth.
	 */
	private Client client;
	/**
	 * A server sends and receives data to and from its associated clients (other
	 * programs connected to it)
	 */
	private Server server;

	JSONObject data;
	public boolean isHost;

	/**
	 * Constructor for a connecting client
	 * 
	 * @param player
	 * @param hostIP
	 * @param port
	 */
	public Multiplayer(SideScroller player, String hostIP, int port, boolean isHost) throws java.net.ConnectException {
		this.isHost = isHost;
		data = null;
		if (isHost) {
			setServer(player, port);
			if (!getServer().active()) {
				throw new java.net.ConnectException();
			}
		} else {
			setClient(player, hostIP, port);
			if (!getClient().active()) {
				throw new java.net.ConnectException();
			}
		}
	}

	/**
	 * Use default (LAN) port and host.
	 * 
	 * @param player
	 * @param isHost
	 * @throws ConnectException
	 */
	public Multiplayer(SideScroller player, boolean isHost) throws ConnectException {
		this(player, "127.0.0.1", 25565, isHost);
	}

	public JSONObject readData() {

		if (isHost) {
			client = getServer().available();
		}

		if (getClient() != null && getClient().available() > 0) {
			String packet = getClient().readString();
			try {
				data = JSONObject.parse(packet);
			} catch (java.lang.RuntimeException e) {
			}
		}
		return data;
	}

	public void writeData(String packet) {
		if (isHost) {
			getServer().write(packet); // write to client(s)
		} else {
			if (getClient().active()) {
				getClient().write(packet); // write to server
			}
		}
	}

	public void exit() {
		if (getClient() != null) {
			getClient().stop();
		}
		if (getServer() != null) { // TODO message clients.
			getServer().stop();
		}
	}

	public void setServer(SideScroller player, int port){
		server = new Server(player, port);
	}
	
	public Server getServer(){
		return server;
	}

	public void setClient(SideScroller player, String hostIP, int port){
		client = new Client(player, hostIP, port);
	}

	public Client getClient(){
		return client;
	}
}