package com.ahmadgilang.b;

public class SoalNo2 {

	/**
	 * Input data: Saya sedang Belajar Bahasa PemOgraman JAVA.  
	 * Output data:Sy sdng Bljr Bhs Pmgrmn JV
	 */
	public static void algo2(){
		String input = "Saya sedang Belajar Bahasa PemOgraman JAVA.";
		System.out.println("Input data : "+input);
		
		input = input.replaceAll("[AEIOUaeiou]", "");
		
		System.out.println("Output data : "+input);
		System.out.println("==============================================================");
	}

	
}
