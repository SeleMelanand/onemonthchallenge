package com.onemonthlearning.com.onemonthlearning;

import java.util.Arrays;

import org.testng.annotations.Test;

public class Day15Challenge {

	@Test
	public void anagramcode() {
		String input1 = "anagram";
		String input2 = "nagaram";
		boolean status ;
		if (input1.length() != input2.length()) {
			status =false;
		} else {

			char[] abc = input1.toLowerCase().toCharArray();
			char[] def = input2.toLowerCase().toCharArray();
			Arrays.sort(abc);
			Arrays.sort(def);
			status = Arrays.equals(abc, def);

		}
		System.out.println(status);
		if(status == true) {
		System.out.println("Given string ::"+input1 + " & "+ input2+ " :: are anagram");	
		}
		else {
			System.out.println("Given string ::"+input1 + " & "+ input2+ " :: are not anagram");	

		}

	}
}
