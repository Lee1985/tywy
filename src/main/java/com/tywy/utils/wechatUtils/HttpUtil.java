package com.tywy.utils.wechatUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	/**
	 * send http by get method
	 * 
	 * @param url
	 * @return String
	 * @throws Exception
	 * @throws Exception
	 */
	public static String doGet(String url) throws Exception {
		StringBuffer result = new StringBuffer();
		URL sendurl = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) sendurl.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("contentType", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		InputStream in = httpURLConnection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		reader.close();
		in.close();
		return result.toString();
	}

	/**
	 * send http by post method
	 * 
	 * @param url
	 * @return String
	 * @throws Exception
	 */
	public static String doPost(String url) throws Exception {
		StringBuffer result = new StringBuffer();
		URL sendurl = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) sendurl.openConnection();
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
		httpURLConnection.setRequestProperty("contentType", "utf-8");
		httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

		InputStream in = httpURLConnection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			result.append(line);
		}
		reader.close();
		in.close();
		return result.toString();
	}

}
