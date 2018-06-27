package aman.pramati.thread.chat.client;

import aman.pramati.thread.chat.client.utils.ClientConfiguration;

public class VartalapFactory {

	public static VartalapClient getVartalapClient(ClientConfiguration config) {
		
//		if(config.getClientMode().equals("CLI"))
		
		return new VartalapCLIClient(config);
	}

}
