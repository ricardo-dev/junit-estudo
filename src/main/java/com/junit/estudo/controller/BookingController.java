package com.junit.estudo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.junit.estudo.model.BookingModel;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BookingModel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<BookingModel>());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<BookingModel> save(@RequestBody BookingModel bookingModel){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingModel);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<BookingModel> update(@PathVariable("id") Long id, @RequestBody BookingModel bookingModel){
		return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id){
		
	}
}
