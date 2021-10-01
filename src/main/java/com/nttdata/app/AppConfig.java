package com.nttdata.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuración para RestTemplate
 * 
 * @author Jorge Heras
 * @version 0.1 29/09/2021
 */

@Configuration
public class AppConfig {

	/**
	 * Método Bean de registro de ResTemplate
	 * 
	 * @return Nueva instancia de RestTemplate
	 */
	@Bean("clientRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}

}
