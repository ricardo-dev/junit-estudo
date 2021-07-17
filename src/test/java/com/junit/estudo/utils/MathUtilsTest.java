package com.junit.estudo.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//@SpringBootTest
class MathUtilsTest {
	
	@Test
	void testMdcAParP1() {
		final int a = 6;
		final int b = 3;
		final int esperado = b;
		final int calculado = MathUtils.mdc(a, b);
		assertEquals(esperado, calculado);
	}
	
	@Test
	void testMdcAImparP1() {
		final int a = 9;
		final int b = 3;
		final int esperado = b;
		final int calculado = MathUtils.mdc(a, b);
		assertEquals(esperado, calculado);
	}
	
	@Test
	void testMdcParesP2() {
		final int a = 16;
		final int b = 8;
		final int divisor = 4;
		final int calculado = MathUtils.mdc(a, b);
		assertTrue(calculado % divisor == 0);
	}
	
	@Test
	void testMdcAPositivoP3() {
		final int a = 15;
		final int b = 0;
		final int esperado = 15; //valor absoluto
		final int calculado = MathUtils.mdc(a, b);
		assertEquals(calculado, esperado);
	}
	
	@Test
	void testMdcANegativoP3() {
		final int a = 30;
		final int b = 0;
		final int esperado = 30; //valor absoluto
		final int calculado = MathUtils.mdc(a, b);
		assertEquals(calculado, esperado);
	}
}
