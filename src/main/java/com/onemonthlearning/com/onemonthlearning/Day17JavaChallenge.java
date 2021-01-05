package com.onemonthlearning.com.onemonthlearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class Day17JavaChallenge {

	@Test(groups = { "javaProgram" })
	public void printlargenumber() {
		int[] inputlist = {3,30,34,5,9};

		String temp = Arrays.toString(inputlist).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");

		char[] abc = new char[temp.length()];
		for (int j = 0; j < temp.length(); j++) {
			abc[j] = temp.charAt(j);

		}
		int[] intTempArray = new int[temp.length()];
		int num = 0;

		for (int j = 0; j < abc.length; j++) {
			num = Integer.parseInt(String.valueOf(abc[j]));
			intTempArray[j] = num;
			System.out.print(intTempArray[j]);
		}

		System.out.println("");

		List<Integer> listC = new ArrayList<Integer>();

		for (Integer c : intTempArray) {
			listC.add(c);

		}
		Collections.sort(listC);
		Collections.reverse(listC);
		String bignumber= "";
		for (Integer i : listC) {
			bignumber+= i;
		}
		System.out.println("Biggest number in the given array is : "+ bignumber);
		

		
	}

}
