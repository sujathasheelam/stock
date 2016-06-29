package com.stockAccounting.Examples;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		String p = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a value");
		String s = sc.next();
		System.out.println(s);
		int count = s.length();
		System.out.println(count);
		// s.charAt(2);
		for (int i = count-1; i >= 0; i--) {
			char reverse = s.charAt(i);
			p = p + reverse;
		}
		System.out.println(p);
		if (s.equals(p)) {
			System.out.println(s + " given no is palindrome");
		} else {
			System.out.println(s + " given no is not a palindrome");
		}
	}

}
