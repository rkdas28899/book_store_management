package com.obsm.customer.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.obsm.customer.exception.CustomerNotFoundException;
import com.obsm.customer.exception.ReviewNotFoundException;
import com.obsm.customer.model.Customer;
import com.obsm.customer.payload.CustomerUpdateRequest;
import com.obsm.customer.service.ICustomerService;
import com.obsm.customer.model.Review;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	ICustomerService service;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return (service.addCustomer(customer));
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity deleteCustomer(@PathVariable long customerId) throws CustomerNotFoundException {
		return service.deleteCustomer(customerId);
	}

	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest, @PathVariable long customerId) throws CustomerNotFoundException {
		return service.updateCustomer(customerUpdateRequest, customerId);
	}

	@GetMapping("getCustomer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long customerId) throws CustomerNotFoundException {
		return service.getCustomerById(customerId);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return service.getAllCustomer();
	}
	
	
	
	
	
	@PostMapping("/addReview")
	public Review addReview(@RequestBody Review review){
		return (service.addReview(review));
	}
	
	@DeleteMapping("/deleteReview/{reviewId}")
	public Review deleteReview(@PathVariable long reviewId) throws ReviewNotFoundException, RestClientException, URISyntaxException {
		return service.deleteReview(reviewId);
	}

	@PutMapping("/updateReview/{reviewId}")
	public Review updateReview(@RequestBody CustomerUpdateRequest reviewUpdateRequest, @PathVariable long reviewId) throws ReviewNotFoundException, RestClientException, URISyntaxException {
		return service.updateReview(reviewUpdateRequest, reviewId);
	}

	@GetMapping("getReview/{reviewId}")
	public Review getReview(@PathVariable long reviewId) throws ReviewNotFoundException  {
		return service.getReview(reviewId);
	}

//	@GetMapping("/getAllReviews")
//	public List<Review> getAllReviews() {
//		return service.getAllReviews();
//	}
	

}
