package com.junit.estudo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.estudo.controller.BookingController;
import com.junit.estudo.model.BookingModel;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void bookingTestGetAll() throws Exception {
		mockMvc.perform(get("/bookings"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void bookingTestSave() throws JsonProcessingException, Exception {
		BookingModel bookingModel = getBookingModel();
		mockMvc.perform(post("/bookings")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(bookingModel)))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void bookingTestUpdate() throws JsonProcessingException, Exception {
		BookingModel bookingModel = getBookingModel();
		mockMvc.perform(put("/bookings/"+bookingModel.getId())
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(bookingModel)))
		.andExpect(status().isOk());
	}

	
	@Test
	public void bookingTestDelete() throws Exception {
		BookingModel bookingModel = getBookingModel();
		mockMvc.perform(delete("/bookings/"+bookingModel.getId()))
			.andExpect(status().isNoContent());
	}
	
	private BookingModel getBookingModel() {
		LocalDate checkIn = LocalDate.parse("2022-08-14");
		LocalDate checkOut = LocalDate.parse("2022-08-24");
		BookingModel bookingModel = new BookingModel("1", "Ricardo",
				checkIn, checkOut, 2);
		return bookingModel;
	}
}
