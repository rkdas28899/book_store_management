package com.obsm.customer.exception;

public class ReviewNotFoundException extends RuntimeException
  {
	public ReviewNotFoundException(String error){
        super(error);
  }
	
  }
