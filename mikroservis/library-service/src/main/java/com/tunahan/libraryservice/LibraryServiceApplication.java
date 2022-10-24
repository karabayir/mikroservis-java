package com.tunahan.libraryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.tunahan.libraryservice.client.RetreiveMessageErrorDecoder;

import feign.Logger;
import feign.codec.ErrorDecoder;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}
	
	//Fault Tolerance kullandığım durumda pasife aldım.
	
	// Add ErrorDecoderBean ( Sprig contex e at ki Spring kullanabilsin)
	
	// Feign Client Error Handling
	
	/*@Bean
	public ErrorDecoder errorDecoder() {
		return new RetreiveMessageErrorDecoder();
	}
	
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}*/

}
