package com.obsm.customer.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.obsm.customer.exception.CustomerNotFoundException;
import com.obsm.customer.exception.ReviewNotFoundException;
import com.obsm.customer.model.Customer;
import com.obsm.customer.model.Review;
import com.obsm.customer.payload.CustomerUpdateRequest;
import com.obsm.customer.repository.CustomerRepo;
import com.obsm.customer.utils.Helper;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	 Review review;
		
	 @Autowired
	 RestTemplate rt;

	@Autowired
	CustomerRepo repo;
	public ResponseEntity<Customer> addCustomer(Customer customer) {
		try {
			if (customer != null) {
				return new ResponseEntity<>(repo.save(customer), HttpStatus.CREATED);
			} else throw new CustomerNotFoundException("Not a valid request");
		}catch(CustomerNotFoundException customerNotFound){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity deleteCustomer(long customerId) throws CustomerNotFoundException {
		try {
			Customer deletedCustomer = repo.getOne(customerId);
			if (repo.existsById(customerId)) {
				repo.delete(deletedCustomer);
				return new ResponseEntity(HttpStatus.OK);
			} else throw new CustomerNotFoundException("Customer is Null");
		}catch (CustomerNotFoundException customerNotFound){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}catch(Exception exception){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(CustomerUpdateRequest customerUpdateRequest, long customerId)
			throws CustomerNotFoundException {
		try {
			Customer updatedCustomer = repo.getOne(customerId);
			if (!repo.existsById(customerId)) {
				throw new CustomerNotFoundException("Customer doesn't exists!");
			}
			Helper.copyCustomerDetails(updatedCustomer, customerUpdateRequest);
			return new ResponseEntity<>(repo.save(updatedCustomer),HttpStatus.ACCEPTED);
		}catch(CustomerNotFoundException customerNotFound){
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(long customerId) throws CustomerNotFoundException {
		try {
			Customer customer = repo.getOne(customerId);
			if(repo.existsById(customerId))
				return new ResponseEntity<>(customer, HttpStatus.FOUND);
			else throw new CustomerNotFoundException("No Customer is available");
		}catch (CustomerNotFoundException customerNotFound){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception exception){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<List<Customer>> getAllCustomer() 
	{
		return new ResponseEntity(repo.findAll(),HttpStatus.FOUND);
	}
	
		
		@Override
		public Review addReview(Review review) {
			Review addedreview=rt.postForObject("http://localhost:8160/review/addReview",review,Review.class);
			return addedreview;
		}

		@Override
		public Review deleteReview(long reviewId) throws ReviewNotFoundException, RestClientException, URISyntaxException{
			rt.delete(new URI("http://localhost:8160/review/deleteReview/"+reviewId));
			return review;
		}
		
		@Override
		public Review updateReview(CustomerUpdateRequest customerUpdateRequest, long reviewId) throws ReviewNotFoundException, RestClientException, URISyntaxException {
			rt.put(new URI("http://localhost:8160/review/updateReview/"+reviewId),customerUpdateRequest);
			return review;
			
		}
		
		@Override
		public Review getReview(long reviewId) throws ReviewNotFoundException{
			Review review=rt.getForObject("http://localhost:8160/review/getReview/"+reviewId,Review.class);
			return review;
		}
		
//		@Override
//		public List<Review> getAllReviews() {
//			List<Review> reviews=rt.getForEntity("http://localhost:8160/review/getAllReviews",ArrayList.class);
//			return Arrays.asList(reviews);	
//		}
		
		


}
