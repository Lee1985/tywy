package com.tywy.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtils {
	
	public static String getTextFromTHML(String htmlStr) {
		Document doc = Jsoup.parse(htmlStr);
		String text = doc.text();
		// remove extra white space
		StringBuilder builder = new StringBuilder(text);
		int index = 0;
		while(builder.length()>index){
			char tmp = builder.charAt(index);
			if(Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)){
				builder.setCharAt(index, ' ');
			}
			index++;
		}
		text = builder.toString().replaceAll(" +", " ").trim();
		return text;
	}

}
