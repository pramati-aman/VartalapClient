package aman.pramati.thread.chat.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;

import aman.pramati.thread.chat.client.utils.ClientConfiguration;
import aman.pramati.thread.chat.exception.ServerListeningException;
import aman.pramati.thread.chat.exception.VartalapCheckedException;

public class VartalapCLIClient implements VartalapClient {

	private static final long serialVersionUID = 1L;
	private String username;
	private LocalDateTime joiningTime;
	private LocalDateTime lastActiveAt;
	private Socket sock;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	

	private ClientConfiguration config;

	public VartalapCLIClient(ClientConfiguration config) {
		this.config=config;
	}

	public void makeConnection() {
		try {
			sock = new Socket(config.getServerIp(),config.getPort());
			setInputStream((DataInputStream)sock.getInputStream());
			setOutputStream((DataOutputStream)sock.getOutputStream());
		}
		catch (IOException e) {
			throw new ServerListeningException("Unable to successfully connect to the server on IP: "+config.getServerIp()+", port: "+config.getPort());
		} 
	}

	public void clientSettleUp() {
		
	}
	
	public void beginVartalap() throws VartalapCheckedException {
		String incoming, outgoing, msgType="";
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while(!(incoming = inputStream.readUTF()).toUpperCase().startsWith("QUIT")) {
				msgType = incoming.split("#")[0];
				System.out.println(incoming.substring(msgType.length()+1, incoming.length()));
				outgoing = msgType+"#"+br.readLine();
				outputStream.writeUTF(outgoing);
			}	
		}
		catch(IOException ie) {
			throw new VartalapCheckedException("Message Sending failed");
		}
	}

	public void disconnect() {
		
	}

	public String getUsername() {
		return username;
	}

	public LocalDateTime getJoiningTime() {
		return joiningTime;
	}

	public LocalDateTime getLastActiveAt() {
		return lastActiveAt;
	}

	public Socket getSock() {
		return sock;
	}

	public DataInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(DataInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public DataOutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(DataOutputStream outputStream) {
		this.outputStream = outputStream;
	}

	

}
