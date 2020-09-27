package com.api.carrito.ws.util;

import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * contains redundantly the HTTP status of the response sent back to the
     * client in case of error, so that the developer does
     * not have to look into the response headers.
     */
    private int status;
    private String developerMessage; //detailed error description for developers

    public ApiException() {
    }

    public ApiException(int status, String message, String developerMessage) {
        super(message);
        this.status = status;
        this.developerMessage = developerMessage;
    }

    public ApiException(String message) {
      //...
    }

    public ApiException(String message, String developerMessage) {
        super(message);
        this.developerMessage = developerMessage;
        //this.status = ;
    }
  
  // getters & setters
}