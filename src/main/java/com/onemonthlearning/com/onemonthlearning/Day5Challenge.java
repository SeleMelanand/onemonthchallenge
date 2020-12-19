package com.onemonthlearning.com.onemonthlearning;

import org.testng.annotations.Test;

public class Day5Challenge {
	@Test
	public void updatedString() {
		String inputval = "askdjsdkqoweiqwoeiuqwo";
		String outputval = null;
		char[] abcd = new char[inputval.length()];

		for (int i = 0; i < inputval.length(); i++) {
			abcd[i] = inputval.charAt(i);

			if (abcd[i] == 'a' || abcd[i] == 'e' || abcd[i] == 'i' || abcd[i] == 'o' || abcd[i] == 'u' || abcd[i] == 'A'
					|| abcd[i] == 'E' || abcd[i] == 'I' || abcd[i] == 'O' || abcd[i] == 'U') {
				abcd[i] = ' ';
			}

		}
		outputval = String.valueOf(abcd);
		System.out.println("Input string : " + inputval);
		System.out.println("Output String : " + outputval.replaceAll("\\s", ""));

	}
}