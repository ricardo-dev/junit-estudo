package com.junit.estudo.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ListUtilsTest {
	
	static List<String> wordsAux1 = new ArrayList<>();
	
	static ListUtils listUtils;
	
	@BeforeAll
	static void setUp() {
		listUtils = new ListUtils();
		
		wordsAux1.add("one");
		wordsAux1.add("two");
		wordsAux1.add("three");
	}
	
	@AfterAll
	static void finish() {
		wordsAux1.clear();
	}
	
	@Test
	void testListWordAux1() {
		assertEquals(wordsAux1, listUtils.lista());
	}
	
	@Test
	void testContainWordTrue() {
		final String word = "one";
		assertTrue(listUtils.contains(word));
	}
	
	@Test
	void testContainWordFalse() {
		final String word = "five";
		assertFalse(listUtils.contains(word));
	}
}
