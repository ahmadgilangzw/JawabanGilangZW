package com.ahmadgilang.b;

public class SoalNo1 {

	/**
	 * Input data: Saya sedang Belajar Bahasa PemOgraman JAVA.  
	 * Output data: sAYA SEDANG bELAJAR bAHASA pEMoGRAMAN java
	 */
	public static void algo1(){
		String input = "Saya sedang Belajar Bahasa PemOgraman JAVA";
		System.out.println("Input data : "+input);
		
		char[] arrChar = input.toCharArray();
		
		for (int i = 0; i < arrChar.length; i++) {
			char c = arrChar[i];
			if(Character.isUpperCase(c)){
				arrChar[i] = Character.toLowerCase(c);
			}else{
				arrChar[i] = Character.toUpperCase(c);
			}
		}
		
		System.out.println("Output data : "+new String(arrChar));
		System.out.println("==============================================================");
	}
	
}
