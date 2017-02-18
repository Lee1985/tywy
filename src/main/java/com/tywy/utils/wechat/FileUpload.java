package com.tywy.utils.wechat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONObject;
import com.tywy.utils.DateUtils;

public class FileUpload {

	/**
	 * 模拟form表单的形式上传文件，以输出流的形式把文件写入到url中，然后用输入流来获取url的响应
	 * 
	 * @param url请求地址form表单url地址
	 * @param filePath文件在服务器保存路径
	 * @return String url的响应信息返回值
	 * @throws IOException
	 */
	public static JSONObject send(String url, String filePath) throws IOException {

		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		// 如果本地文件大于2M,执行等比压缩操作
		if (file.length() >= 2097152) {
			System.out.println("上传文件【" + file.length() + "】大于2M,执行等比压缩操作");
			// 设置压缩后的图片路径
			String disPath = filePath.replace("tywy_file", "tywy_file/resize");
			// 创建目录
			promptMkdir(disPath);
			// 压缩图片
			resizeImage(filePath, disPath, 800, 450);
			file = new File(disPath);
		}

		// 连接
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		// 设置关键值
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		// 请求正文信息
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		// 定义最后数据分隔线
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");
		out.write(foot);
		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.parseObject(result);
		System.out.println("微信服务器获取【mediaId】返回结果:" + jsonObj);

		return jsonObj;
	}

	/**
	 * @category 立刻创建文件夹的方法 1个参数 path表示服务器路径
	 */
	public static boolean promptMkdir(String path) {
		File myFilePath = new File(path.toString());
		try {
			if (myFilePath.isDirectory()) {
				System.out.println("目录已经存在");
				return false;
			} else {
				myFilePath.mkdirs();
				System.out.println("新建目录成功 " + path + "  " + DateUtils.toString(new Date(), "yyyy-MM-dd HH:mm"));
			}
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}
		return true;
	}

	/***
	 * 功能 :缩放图片，精度较高
	 * 
	 * @param srcImgPath原图片路径
	 * @param distImgPath转换大小后图片路径
	 * @param width转换后图片宽度
	 * @param height转换后图片高度
	 */
	public static void resizeImage(String srcImgPath, String distImgPath, int width, int height) throws IOException {

		String subfix = "jpg";
		subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
		File srcFile = new File(srcImgPath);
		Image srcImg = ImageIO.read(srcFile);

		BufferedImage buffImg = null;
		if (subfix.equals("png")) {
			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		} else {
			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		Graphics2D graphics = buffImg.createGraphics();
		graphics.setBackground(Color.WHITE);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		graphics.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		ImageIO.write(buffImg, subfix, new File(distImgPath));
	}

	public static void main(String[] args) throws IOException {
		String filePath = "C:/tywy_file/wechat_homepage_album_t/20170218/20170218094940733.png";
		String sendUrl = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=MUp6eFrHKmgf1dLK_L41lYmlrPBUT23LO3Md2hMrehJ05fMTGnbEuVaddUohVYvCZ3Skep9R-SXV6WuPSIyEJWbA0DjS0yaN83E1maRLHFTSQffWcvy1bPcreNcqWA4vUYIhABAOSC&type=image";
		JSONObject result = null;
		result = FileUpload.send(sendUrl, filePath);
		System.out.println(result);

	}
}
