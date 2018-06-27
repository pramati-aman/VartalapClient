package aman.pramati.thread.chat.client.utils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:client.properties")
@ConfigurationProperties
public class ClientConfiguration {
	
	@Length(max=15,min=7)
	String serverIp;
	
	@Min(1025)
	@Max(65536)
	Integer port;

	String clientMode;
	
	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getClientMode() {
		return clientMode;
	}

	public void setClientMode(String clientMode) {
		this.clientMode = clientMode;
	}
	
	
}
