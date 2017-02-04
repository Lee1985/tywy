package com.tywy.utils.wechat;

import com.tywy.sc.data.model.wechat.ReceiveXmlVO;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * 解析接收到的微信xml，返回消息对象
 */
public class ReceiveXmlUtil {

    /**
     * request转换XML
     *
     * @param request
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String parseXml(HttpServletRequest request) throws IOException {

        String xml = null;
        /** 读取接收到的xml消息 */
        StringBuffer sb = new StringBuffer();
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        xml = sb.toString(); // 接收到微信端发送过来的xml数据
        return xml;
    }

    /**
     * 解析微信xml消息 利用反射机制,调用set方法 ,获取该实体
     *
     * @param strXml
     * @return
     */
    public static ReceiveXmlVO getReceiveXmlVO(String strXml, String className) {

        ReceiveXmlVO xmlVO = null;
        if (strXml.length() <= 0 || strXml == null) {
            return null;
        }

        try {
            // 将字符串转化为XML文档对象
            Document document = DocumentHelper.parseText(strXml);

            xmlVO = new ReceiveXmlVO();
            // 利用反射机制,调用set方法 ,获取该实体的元类型
            Class<?> clazz = Class.forName(className);
            xmlVO = (ReceiveXmlVO) clazz.newInstance();// 创建这个实体的对象

            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有节点
            Iterator<?> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element ele = (Element) iterator.next();
                // 获取set方法中的参数字段（实体类的属性）
                Field field = clazz.getDeclaredField(ele.getName());
                // 获取set方法，field.getType())获取它的参数数据类型
                Method method = clazz.getDeclaredMethod("set" + ele.getName(), field.getType());
                // 调用set方法
                method.invoke(xmlVO, ele.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlVO;
    }

}
