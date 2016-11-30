package com.tywy.utils.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

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
	public static String doPost(String url, String parameters) {
		String body = null;
		int status = 0;
		System.out.println("parameters:" + parameters);
		HttpPost method = new HttpPost(url);
		if (method != null & parameters != null && !"".equals(parameters.trim())) {
			try {

				// 建立一个NameValuePair数组，用于存储欲传送的参数
				method.addHeader("Content-type", "application/json; charset=utf-8");
				method.setHeader("Accept", "application/json");
				method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));

				HttpClient httpClient = new DefaultHttpClient();
				HttpResponse response = httpClient.execute(method);
				int statusCode = response.getStatusLine().getStatusCode();

				System.out.println("statusCode:" + statusCode);
				if (statusCode != HttpStatus.SC_OK) {
					System.out.println("Method failed:" + response.getStatusLine());
					status = 1;
				}

				// Read the response body
				body = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				// 网络错误
				status = 3;
			} finally {
				System.out.println("调用接口状态：" + status);
			}
		}
		return body;
	}
}
