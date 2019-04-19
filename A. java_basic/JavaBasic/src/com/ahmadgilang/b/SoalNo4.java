package com.ahmadgilang.b;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SoalNo4 {

	public static void algo4()throws IOException{
		String teks = "Since 1995, Java has changed our world . . . and our expectations..  Today, with technology such a part of our daily lives, we take it for granted that we can be connected and access applications and content anywhere, anytime. Because of Java, we expect digital devices to be smarter, more functional, and way more entertaining.  In the early 90s, extending the power of network computing to the activities of everyday life was a radical vision. In 1991, a small group of Sun engineers called the 'Green Team' believed that the next wave in computing was the union of digital consumer devices and computers. Led by James Gosling, the team worked around the clock and created the programming language that would revolutionize our world – Java.  The Green Team demonstrated their new language with an interactive, handheld home-entertainment controller that was originally targeted at the digital cable television industry. Unfortunately, the concept was much too advanced for the them at the time. But it was just right for the Internet, which was just starting to take off. In 1995, the team announced that the Netscape Navigator Internet browser would incorporate Java technology.  Today, Java not only permeates the Internet, but also is the invisible force behind many of the applications and devices that power our day-to-day lives. From mobile phones to handheld devices, games and navigation systems to e-business solutions, Java is everywhere! ";
		
		Map<String, Integer> wordCount = composeWords(teks);
		
		System.out.println("Jumlah kata dari teks di atas : "+jumlahKata(wordCount));
		System.out.println("==============================================================");
		System.out.println("Jumlah kemunculan tiap kata dari teks : ");
		wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
		System.out.println("==============================================================");
		System.out.println("Jumlah kata yang hanya muncul satu kali : "+jumlahKata(jumlahKataMuncul1(wordCount)));
		System.out.println("==============================================================");
		System.out.println("Jumlah kata yang paling banyak muncul dan katanya : "+jumlahKataPalingBanyak(wordCount));
		System.out.println("==============================================================");
		System.out.println("Jumlah kata yang paling sedikit muncul dan katanya : ");
		jumlahKataMuncul1(wordCount).forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
		System.out.println("==============================================================");
	}
	
	public static Map<String, Integer> composeWords(String teks){
		Map<String,Integer> wordCount = Pattern.compile("\\W+")
                .splitAsStream(teks)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.summingInt(s -> 1)));
		
		return wordCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}
	
	public static String jumlahKata(Map<String, Integer> wordCount) {
	    return ""+ wordCount.values()
	      		  .stream()
	      		  .mapToInt(Integer::valueOf)
	      		  .sum();
	}
	
	public static Map<String, Integer> jumlahKataMuncul1(Map<String, Integer> wordCount){
		return wordCount.entrySet().stream()
				.filter(x -> x.getValue() == 1)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}
	
	public static Map.Entry<String,Integer> jumlahKataPalingBanyak(Map<String, Integer> wordCount){
		return wordCount.entrySet().stream()
				  .max(Map.Entry.comparingByValue()).get();
	}
	
}
