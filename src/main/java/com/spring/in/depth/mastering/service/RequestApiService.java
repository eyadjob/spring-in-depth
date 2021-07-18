package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestApiService {

    public Map<String, String> jsonNodesCache = new HashMap<>();

    private RequestApiService() {

    }


    public ResponseEntity<String> requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, String.class);
    }

    public ResponseEntity<Object> requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity, Class className) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, className);
    }

    public ResponseEntity<String> requestGetAPI(String apiNameKey, String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return restTemplate.getForEntity(uri, String.class);
    }

    public ResponseEntity<Object> requestGetAPI(Class className, String apiNameKey, String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return restTemplate.getForEntity(uri, className);
    }


    public  ResponseEntity<Object>  requestExchangeAPI(Class className, HttpEntity<String> httpEntity, String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return new RestTemplate().exchange( uri, HttpMethod.GET, httpEntity, className);
    }


    public Object requestGetByJava(Class className, HttpEntity<String> httpEntity, String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        buildHeaderForNormalJavaRequest(httpGet,httpEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            org.apache.http.HttpEntity entity = response.getEntity();
            String output = convertStreamToString(entity.getContent());
         return JsonUtility.getJsonObjectFromString(output,className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpRequestBase buildHeaderForNormalJavaRequest(HttpRequestBase httpRequestBase, HttpEntity<String> httpEntity) {
        for (Map.Entry<String, List<String>> v : httpEntity.getHeaders().entrySet()) {
            httpRequestBase.addHeader(v.getKey(),v.getValue().get(0));
        }
        return httpRequestBase;
    }
    public String buildGetUri(String url, String... params) {
        StringBuilder getUri = new StringBuilder(url);
        for (int i = 0; i < params.length; i++) {
            if (i == 0)
                getUri.append("?").append(params[i]);
            else
                getUri.append("&").append(params[i]);
        }
        return getUri.toString();
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

