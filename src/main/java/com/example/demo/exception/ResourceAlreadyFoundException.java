package com.example.demo.exception;

public class ResourceAlreadyFoundException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public ResourceAlreadyFoundException(String msg) {
	    super(msg);
	  }
	}
