package com.tywy.sc.base.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tywy.constant.CfgConstant;

public class ConfigLoadListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Properties prop = new Properties();
		try {
			InputStream in = this.getClass().getResourceAsStream("/config.properties");
			prop.load(in);
			CfgConstant.APPID = prop.getProperty("wechat_pub_appID").trim();
			CfgConstant.APPSECRET = prop.getProperty("wechat_pub_appsecret").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
