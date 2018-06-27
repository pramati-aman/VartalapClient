package aman.pramati.thread.chat.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import aman.pramati.thread.chat.client.utils.ClientConfiguration;
import aman.pramati.thread.chat.exception.VartalapCheckedException;

public class ClientMain {
	
	@Autowired
	public static ClientConfiguration config;

	public static void main(String[] args) {
		SpringApplication.run(ClientMain.class, args);
		VartalapClient vc = VartalapFactory.getVartalapClient(config);
		vc.makeConnection();
		try {
			vc.beginVartalap();
		} catch (VartalapCheckedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
