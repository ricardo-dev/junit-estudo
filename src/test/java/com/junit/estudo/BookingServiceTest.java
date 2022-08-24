package com.junit.estudo;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.junit.estudo.model.BookingModel;
import com.junit.estudo.repository.BookingRepository;
import com.junit.estudo.service.BookingService;

@RunWith(SpringRunner.class) // spring <-> junit
public class BookingServiceTest {
	
	@TestConfiguration
	static class BookingServiceTestConfiguration {
		
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}

	@Autowired
	private BookingService bookingService;
	
	@MockBean
	private BookingRepository bookingRepository;
	
	@Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2022-08-14");
		LocalDate checkOut = LocalDate.parse("2022-08-24");
		BookingModel bookingModel = new BookingModel("1", "Ricardo",
				checkIn, checkOut, 2);
		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
			.thenReturn(java.util.Optional.of(bookingModel));
	}
	
	@Test
	public void bookingTestServiceDaysCalculatorNotTen() {
		this.testDaysNotTen();
		String name = "Ricardo";
		int days = bookingService.daysCalculatorWithDatabase(name);
		Assertions.assertEquals(days, 11);
	}
	
	@Test
	public void bookingTestServiceDaysCalculator() {
		String name = "Ricardo";
		int days = bookingService.daysCalculatorWithDatabase(name);
		Assertions.assertEquals(days, 10);
	}
	
	
	//MOCKY other datas
	
	private void testDaysNotTen() {
		LocalDate checkIn = LocalDate.parse("2022-08-14");
		LocalDate checkOut = LocalDate.parse("2022-08-25");
		BookingModel bookingModel = new BookingModel("1", "Ricardo",
				checkIn, checkOut, 2);
		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
			.thenReturn(java.util.Optional.of(bookingModel));
	}
}
