package com.junit.estudo.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	
	public List<String> lista(){
		List<String> words = new ArrayList<>();
		words.add("one");
		words.add("two");
		words.add("three");
		return words;
	}
	
	public boolean contains(String word) {
		List<String> words = new ArrayList<>();
		words.add("one");
		words.add("two");
		words.add("three");
		return words.contains(word);
	}
}
