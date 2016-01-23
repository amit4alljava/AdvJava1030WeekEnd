package com.shop.servlets;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("D:\\JavaWeekEnd10to12\\logs\\Abcd.txt");
		System.setOut(ps);
		System.out.println("Hello Java");

	}

}
