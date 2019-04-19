package com.ahmadgilang.b;

public class SoalNo3 {
	
	/**
	 * Input data:  Developer PT. Global Tiket Network
	 * Output data: De5vl3o3pr2PT2.Gbaik2t2Nw
	 *              
	 */
	public static void algo3(){
		String input = "Developer PT. Global Tiket Network";
		System.out.println("Input data : "+input);
		
		char[] arrChar = input.toCharArray();
		String result = "";
		
		for (int i = 0; i < arrChar.length; i++) {
			char c = arrChar[i];
			if(!result.contains(""+c) && !" ".equals(""+c)){
				long count = input.chars().filter(ch -> ch == c).count();
				String cString = count == 1 ? "" : ""+count;
				result += c+""+cString;
			}
		}
		
		System.out.println(result);
			
		System.out.println("==============================================================");
	}
	
}
