package com.reza.fta.Functions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Requests
{


    //Get send get request function start
    public static String SendGetRequest(String Host,String head) throws Exception
    {
        //Convert url string to uri variable
        CloseableHttpClient http= HttpClients.createDefault();
        HttpGet request=new HttpGet(Host);

        //Heads start
        String []heads=head.split("\n\r");
        for(String SP_HEAD:heads)
        {
            String HEAD_DATA[]=SP_HEAD.split(":");
            request.addHeader(HEAD_DATA[0],HEAD_DATA[1]);
        }
        //Heads end

        //Response
        CloseableHttpResponse response=http.execute(request);
        HttpEntity entity=response.getEntity();

        String result=EntityUtils.toString(entity);
        return result;
    }
    //Get send get request function end



    //Get send post request function start
    public static String SendPostRequest(String Host,String parametrs,String head) throws Exception
    {
        //Convert url string to uri variable
        CloseableHttpClient http= HttpClients.createDefault();
        HttpPost request=new HttpPost(Host);

        //Heads start
        String []heads=head.split("\n\r");
        for(String SP_HEAD:heads)
        {
            String HEAD_DATA[]=SP_HEAD.split(":");
            request.addHeader(HEAD_DATA[0],HEAD_DATA[1]);
        }
        //Heads end

        //Append parameters start
        List<NameValuePair> PostParametrs=new ArrayList<>();
        String []parametrs_data=head.split("\n\r");
        for(String SP_PARA:parametrs_data)
        {
            String PARA_DATA[]=SP_PARA.split(":");
            PostParametrs.add(new BasicNameValuePair(PARA_DATA[0],PARA_DATA[1]));
        }
        request.setEntity(new UrlEncodedFormEntity(PostParametrs));
        //Append parameters end

        //Response
        CloseableHttpResponse response=http.execute(request);
        HttpEntity entity=response.getEntity();

        String result=EntityUtils.toString(entity);
        return result;
    }
    //Get send post request function end


}
