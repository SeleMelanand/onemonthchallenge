package com.onemonthlearning.com.onemonthlearning;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class Day13JavaChallenge {
	/*
	 * Problem statement :: need to find the index of the targetvalue if it is
	 * present in the given array, if not return the index where it would be if it
	 * wereinserted in the order
	 */

	@Test(groups = { "javaProgram"})
	public void printindex() {

		int[] inputarr = { 5, 3, 8, 1, 9 };
		int tempval = 0;
		// Sorting the array
		for (int i = 0; i < inputarr.length; i++) {
			for (int j = i + 1; j < inputarr.length; j++) {
				if (inputarr[i] > inputarr[j]) {
					tempval = inputarr[i];
					inputarr[i] = inputarr[j];
					inputarr[j] = tempval;
				}

			}
			System.out.print(inputarr[i] + " ");
		}
		System.out.println();
		int targetvalue = 6;

		// identifying the target value is present in the inpur array or not
		String result = "element not present";
		for (int i = 0; i < inputarr.length; i++) {
			if (inputarr[i] == targetvalue) {
				result = "element present";
			}
		}

		if (result.equalsIgnoreCase("element present")) {
			for (int i = 0; i < inputarr.length; i++) {
				if (inputarr[i] == targetvalue) {
					System.out.println("Target value is present in index: " + i);
				}

			}
		} else {
			ArrayList<Integer> arrlist = new ArrayList<Integer>();
			for (int j = 0; j < inputarr.length; j++) {
				arrlist.add(new Integer(inputarr[j]));
			}
			arrlist.add(targetvalue);
			Collections.sort(arrlist);
			System.out.println(arrlist);
			int indexvalue = arrlist.indexOf(targetvalue);
			System.out.println("Target value is present in index: " + indexvalue);
			
			
		}

	}

}
