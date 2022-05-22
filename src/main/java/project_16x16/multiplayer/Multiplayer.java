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

	private JSONObject data;
	private boolean isHost;

	/**
	 * Constructor for a connecting client
	 * 
	 * @param player
	 * @param hostIP
	 * @param port
	 */
	public Multiplayer(SideScroller player, String hostIP, int port, boolean isHost) throws java.net.ConnectException {
		this.setHost(isHost);
		setData(null);
		if (isHost) {
			setServer(new Server(player, port));
			if (!getServer().active()) {
				throw new java.net.ConnectException();
			}
		} else {
			setClient(new Client(player, hostIP, port));
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

		if (isHost()) {
			setClient(getServer().available());
		}

		if (getClient() != null && getClient().available() > 0) {
			String packet = getClient().readString();
			try {
				setData(JSONObject.parse(packet));
			} catch (java.lang.RuntimeException e) {
			}
		}
		return getData();
	}

	public void writeData(String packet) {
		if (isHost()) {
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

	public void setServer(Server server){
		this.server = server;
	}
	
	public Server getServer(){
		return server;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient(){
		return client;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}

	public JSONObject getData() {
		return data;
	}
}