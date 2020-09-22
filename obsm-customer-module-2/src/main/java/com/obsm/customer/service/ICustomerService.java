package com.obsm.customer.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.obsm.customer.exception.CustomerNotFoundException;
import com.obsm.customer.exception.ReviewNotFoundException;
import com.obsm.customer.model.Book;
import com.obsm.customer.model.Customer;
import com.obsm.customer.model.Review;
import com.obsm.customer.payload.CustomerUpdateRequest;

public interface ICustomerService {	
		public ResponseEntity<Customer> addCustomer(Customer customer);
		public ResponseEntity<Customer> deleteCustomer(long customerId) throws CustomerNotFoundException;
		public ResponseEntity<Customer> updateCustomer(CustomerUpdateRequest customerUpdateRequest, long customerId) throws CustomerNotFoundException;
		public ResponseEntity<Customer> getCustomerById(long adminId) throws CustomerNotFoundException;
		public ResponseEntity<List<Customer>> getAllCustomer();
		
		public Review addReview(Review review);
		public Review deleteReview(long reviewId) throws ReviewNotFoundException, RestClientException, URISyntaxException;
		public Review updateReview(CustomerUpdateRequest customerUpdateRequest, long reviewId) throws ReviewNotFoundException, RestClientException, URISyntaxException;
		public Review getReview(long reviewId) throws ReviewNotFoundException;
	//	public List<Review> getAllReviews();
		
		


	}


