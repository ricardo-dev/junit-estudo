package com.junit.estudo.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.estudo.model.BookingModel;
import com.junit.estudo.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	public int daysCalculatorWithDatabase(String name) {
		Optional<BookingModel> bookingModelOptional = this.bookingRepository.findByReserveName(name);
		return Period.between(bookingModelOptional.get().getCheckIn(),
				bookingModelOptional.get().getCheckOut()).getDays();
	}
}
