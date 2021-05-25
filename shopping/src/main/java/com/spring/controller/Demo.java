package com.spring.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

	public static void main(String args[]) throws IOException {

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//System.out.println("Enter String");

		// String s = br.readLine();
		String s1 = "mariyam";

		System.out.print(evenOddString(s1));
	}

	public static String evenOddString(String s) {

		String result = "";

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (i % 2 == 0) {
				result = result + Character.toUpperCase(ch);
			}

			else {
				result = result + Character.toLowerCase(ch);
			}

		}
		return result;

	}

}
