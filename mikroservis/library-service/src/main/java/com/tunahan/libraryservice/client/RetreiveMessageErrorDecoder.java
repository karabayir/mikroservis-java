package com.tunahan.libraryservice.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import com.tunahan.libraryservice.exception.BookNotFoundException;
import com.tunahan.libraryservice.exception.ExceptionMessage;

import feign.Response;
import feign.codec.ErrorDecoder;

/*
 * Burada bir hata kodu üretiyoruz.
 * Bu ürettiğimiz hata kodunu GeneralExcepition ile yakalayıp anlamlı meseja çevirmeliyiz.
 * Bu anlamlı mesaja çevirme olayı için GeneralException'a git.
 * Spring'in bilmesi için Bean oluşturmayı unutma.(ErrorDecoder ı Spring Contex'e at)
 */

// Fault Tolerance kullanımında bu sınıfın bir işlevi bulunmaz. Pasif konumdadır.
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
	
	private final ErrorDecoder errorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		
		ExceptionMessage message=null;
		
		// InputStream -> for read the  body 
		try(InputStream body = response.body().asInputStream()) {
			
			message = new ExceptionMessage(
					(String) response.headers().get("date").toArray()[0],	
					response.status(),
					HttpStatus.resolve(response.status()).getReasonPhrase(),
					IOUtils.toString(body,StandardCharsets.UTF_8),
					response.request().url());
			
		}catch (IOException exception) {
			return new Exception(exception.getMessage());
		} 
		
		switch(response.status()) {
		case 404:
			throw new BookNotFoundException(message);
		default:
			return errorDecoder.decode(methodKey, response);
		}
		
	
	}

}
