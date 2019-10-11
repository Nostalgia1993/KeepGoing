package com.nostalgia.http;

import java.io.*;
import java.nio.charset.Charset;

import com.nostalgia.rsa.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liunian
 * @createTime 2019/9/17
 * @description
 */
public class HttpFormDataRequest {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String uri = "http://127.0.0.1:8080/requrl";
//            uri="http://127.0.0.1:8080/";
            HttpPost httppost = new HttpPost(uri);

            String user="qy02";
            String pwd="a88888888";
            String cduuid="DB7C2ED2140C2A3D6A6F5801FFE0347F";
            String key="jinting";
            String time=(System.currentTimeMillis() / 1000)-50+"";//获取系统时间戳

//          这里的是有附件的情况的请求提交
//            String path="C:/Users/Administrator/Desktop/study/微服务/netflix/eureka.png";
//            File file = new File(path);
//            FileBody bin = new FileBody(file);
            StringBody user1 = new StringBody(user, ContentType.TEXT_PLAIN);
            StringBody pwd1 = new StringBody(pwd, ContentType.TEXT_PLAIN);
            StringBody cduuid1 = new StringBody(cduuid, ContentType.TEXT_PLAIN);
            StringBody key1 = new StringBody(key, ContentType.TEXT_PLAIN);
            StringBody time1 = new StringBody(time, ContentType.TEXT_PLAIN);


            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    // .addPart("bin", bin)
                    //  .addPart("comment", comment)
                    .addPart("user",user1)
                    .addPart("pwd",pwd1)
                    .addPart("cduuid",cduuid1)
                    .addPart("key",key1)
                    .addPart("time",time1)
                    .build();


            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                    System.out.println("Response content length: " + resEntity.getContent());
                    String a=EntityUtils.toString(resEntity);
                    //打印获取到的返回值
                    System.out.println("Response content: " + a);
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }


}
