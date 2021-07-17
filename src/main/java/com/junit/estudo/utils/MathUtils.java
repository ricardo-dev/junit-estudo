package com.junit.estudo.utils;

public class MathUtils {
	
	public static int mdc(int a, int b) {
		if(b > 0 && a % b == 0) {
			return b;
		}
		else if(b == 0) {
			return Math.abs(a);
		}
		return -1;
	}
}
