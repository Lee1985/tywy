package com.tywy.utils.wechat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http工具类
 *
 * @author Liuheli
 */
public class NetWorkCenter {

    /**
     * 默认连接超时时间(毫秒) 由于目前的设计原因，该变量定义为静态的，超时时间不能针对每一次的请求做定制 备选优化方案：
     * 1.考虑是否重新设计这个工具类，每次请求都需要创建一个实例; 2.请求方法里加入超时时间参数
     * 或者说是否没必要定制,10秒是一个比较适中的选择，但有些请求可能就是需要快速给出结果T_T
     */
    public static final int CONNECT_TIMEOUT = 10 * 1000;

    private static final Logger LOG = LoggerFactory.getLogger(NetWorkCenter.class);
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * 发起HTTP GET同步请求 jdk8使用函数式方式处理请求结果 jdk6使用内部类方式处理请求结果
     *
     * @param url      请求对应的URL地址(不包含？，&，==)
     * @param paramMap GET请求所带参数Map，即URL地址问号后面所带的键值对，很蛋疼的实现方式，后续得改进，还没什么好的方案
     * @return 请求收到响应后回调函数，参数有2个，第一个为resultCode，即响应码，比如200为成功，404为不存在，
     * 500为服务器发生错误； 第二个为resultJson,即响应回来的数据报文
     */
    public static String doGet(String url, Map<String, String> paramMap) {
        String result = "";
        String paramData = null;
        if (CommonUtils.nonNull(paramMap)) {
            StringBuilder buffer = new StringBuilder();
            // 根据传进来的参数拼url后缀- -!
            for (Map.Entry<String, String> param : paramMap.entrySet()) {
                buffer.append(param.getKey()).append("=").append(param.getValue()).append("&");
            }
            // 去掉最后一个&符号
            paramData = buffer.substring(0, buffer.length() - 1);
        }
        result = doRequest("GET", url, paramData, null);
        return result;
    }

    /**
     * send http by doPost method
     *
     * @param url
     * @param paramData
     * @return
     */
    public static String doPost(String url, String paramData) {
        String result = doRequest("POST", url, paramData, null);
        return result;
    }

    /**
     * 处理HTTP请求 基于org.apache.http.client包做了简单的二次封装
     *
     * @param method    HTTP请求类型
     * @param url       请求对应的URL地址
     * @param paramData 请求所带参数，目前支持JSON格式的参数
     * @param fileList  需要一起发送的文件列表
     * @return 请求收到响应后回调函数，参数有2个，第一个为resultCode，即响应码，比如200为成功，404为不存在，
     * 500为服务器发生错误； 第二个为resultJson,即响应回来的数据报文
     */
    private static String doRequest(String method, String url, String paramData,
                                    final List<File> fileList) {
        String resultJson = "";

        // 如果url没有传入，则直接返回
        if (CommonUtils.isBlank(url)) {
            LOG.warn("The url is null or empty!!You must give it to me!OK?");
            return resultJson;
        }

        // 配置请求参数
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(CONNECT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(CONNECT_TIMEOUT).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

        HttpUriRequest request = null;
        switch (method) {
            case "GET":
                String getUrl = url;
                if (CommonUtils.isNotBlank(paramData)) {
                    getUrl += "?" + paramData;
                }
                LOG.info("-----------------请求地址:{}-----------------", getUrl);
                request = new HttpGet(getUrl);
                break;
            case "POST":
                LOG.info("-----------------请求地址:{}-----------------", url);
                LOG.info("请求入参:{}", paramData);
                request = new HttpPost(url);
                // 上传文件
                todoFileMethod(request, fileList, paramData);
                break;
            case "PUT":
            case "DELETE":
            default:
                LOG.warn("-----------------请求类型:{} 暂不支持-----------------", method.toString());
                break;
        }

        CloseableHttpResponse response = null;
        try {
            long start = System.currentTimeMillis();
            // 发起请求
            response = client.execute(request);
            long time = System.currentTimeMillis() - start;
            LOG.debug("本次请求'{}'耗时:{}ms", url.substring(url.lastIndexOf("/") + 1, url.length()), time);

            int resultCode = response.getStatusLine().getStatusCode();
            // 返回码200，请求成功；其他情况都为请求出现错误
            if (HttpStatus.SC_OK == resultCode) {
                LOG.debug("-----------------请求成功-----------------");
                HttpEntity entity = response.getEntity();
                // 此流不是操作系统资源，不用关闭，ByteArrayOutputStream源码里close也是个空方法
                // OutputStream os = new ByteArrayOutputStream();
                // entity.writeTo(os);
                // String resultJson = os.toString();
                resultJson = EntityUtils.toString(entity, UTF_8);
                LOG.debug("响应结果:{}", resultJson);
            } else {
                LOG.error("-----------------请求出现错误，错误码:{}-----------------", resultCode);
            }
        } catch (ClientProtocolException e) {
            LOG.error("-----------------请求出现异常:{}-----------------", e);
        } catch (IOException e) {
            LOG.error("-----------------请求出现IO异常:{}-----------------", e);
        } catch (Exception e) {
            LOG.error("-----------------请求出现其他异常:{}-----------------", e);
        } finally {
            // abort the request
            if (null != request && !request.isAborted()) {
                request.abort();
            }
            // close the connection
            HttpClientUtils.closeQuietly(client);
            HttpClientUtils.closeQuietly(response);
            return resultJson;
        }
    }

    /**
     * 上传文件
     *
     * @param request
     * @param fileList
     * @param paramData
     */
    private static void todoFileMethod(HttpUriRequest request, List<File> fileList, String paramData) {
        LOG.debug("上传文件...");
        if (CommonUtils.isCollectionNotEmpty(fileList)) {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            for (File file : fileList) {
                if (file.isFile()) {
                    FileBody fb = new FileBody(file);
                    builder.addPart("media", fb);
                } else {// 如果上传内容有不是文件的，则不发起本次请求
                    LOG.warn("The target '{}' not a file,please check and try again!", file.getPath());
                    return;
                }
            }
            if (CommonUtils.isNotBlank(paramData)) {
                builder.addPart("description", new StringBody(paramData, ContentType.APPLICATION_JSON));
            }
            ((HttpPost) request).setEntity(builder.build());
        } else {// 不上传文件的普通请求
            if (CommonUtils.isNotBlank(paramData)) {
                // 目前支持JSON格式的数据
                StringEntity jsonEntity = new StringEntity(paramData, ContentType.APPLICATION_JSON);
                ((HttpPost) request).setEntity(jsonEntity);
            }
        }
    }

    public static void main(String[] args) {
        String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
        Map<String ,String> map = new HashMap<>();
        map.put("grant_type","client_credential");
        map.put("appid","wx4070528d2e9eedf6");
        map.put("secret","3961ea18f8ffe727b00e250596bb21a4");
        String result = doGet(GET_ACCESSTOKEN_URL,map);
        System.out.println(result);

    }

}
