package aman.pramati.thread.chat.client;

import java.io.Serializable;

import aman.pramati.thread.chat.exception.VartalapCheckedException;

public interface VartalapClient extends Serializable {
	
	public void makeConnection();
	
	public void beginVartalap() throws VartalapCheckedException;
	
	public void disconnect();

}
