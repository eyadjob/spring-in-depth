package com.spring.in.depth.mastering.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Test {

    public static void main(String[] args) {


        try {

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httppost = new HttpGet("http://ejar-jor-qa.iyelo.com:5900/api/services/app/RentalVehicle/GetAllBranchVehicles?Request=page%3D1%26pageSize%3D15%26sort%3DlastModificationTime-desc%26filter%3D(countryId~eq~1~and~currentLocationId~eq~26~and~plateNo~contains~%27n%2520p%2520i%25201153%27)");
            httppost.addHeader("Connection","keep-alive");
            httppost.addHeader("Referer","http://172.16.30.17:4851/app/rental/branches-vehicles");
            httppost.addHeader("Host","ejar-jor-qa.iyelo.com:5900");
            httppost.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0");
            httppost.addHeader("Accept","application/json");
            httppost.addHeader("Accept-Language","en");
            httppost.addHeader("Accept-Encoding","gzip, deflate");
            httppost.addHeader("Content-Type","application/json");
            httppost.addHeader("Pragma","no-cache");
            httppost.addHeader("Cache-Control","no-cache");
            httppost.addHeader("Expires","Sat, 01 Jan 2000 00:00:00 GMT");
            httppost.addHeader("X-Requested","-With: XMLHttpRequest");
            httppost.addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEwMDA1MzYiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoicGVyZlRlc3QyNjUzMDUyMTMyIiwiQXNwTmV0LklkZW50aXR5LlNlY3VyaXR5U3RhbXAiOiJKSlhRNU9ERUJTQlBRVllPQ1NYUkFRWEFOQVhQVEs0TyIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IjE3Y2U2NWM2ZWFhYjRjNjlhNzg3ZjM3Y2M5ZDZiNjVkIiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsImxvY2F0aW9uSWQiOiIyNiIsImNvdW50cnlJZCI6IjEiLCJjb3VudHJ5SXNvIjoiU0EiLCJMb2NhdGlvbiI6IjI2LDUxLDU3LDE0MSwxNDksMTg4LDEwNjMsMTAwOCIsIkFjY2Vzc0FsbExvY2F0aW9ucyI6IkZhbHNlIiwic3ViIjoiMTAwMDUzNiIsImp0aSI6ImZjOTEwYTlkLTdlNzktNDczNi05OGM0LTFjNWNmN2U5MjQ1NiIsImlhdCI6MTYyNjUzMDMwOCwidG9rZW5fdmFsaWRpdHlfa2V5IjoiYzZjNzFhMDItOTlkMS00YzY3LTlmYjUtNmFkMTVkNWU2MTFlIiwidXNlcl9pZGVudGlmaWVyIjoiMTAwMDUzNkAxIiwibmJmIjoxNjI2NTMwMzA4LCJleHAiOjE2MjY2MTY3MDgsImlzcyI6ImVKYXIiLCJhdWQiOiJlSmFyIn0.bC6MYxQBY3PwgI5qa4uJrKykZiMtKnFa6BHBj4cIBcg");
            httppost.addHeader(".AspNetCore.Culture","en");
            httppost.addHeader("Origin","http://172.16.30.17:4851");
            httppost.addHeader("Connection","keep-alive");
            httppost.addHeader("Content-Length","0");
 
// Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<NameValuePair>(2);

//Execute and get the response.
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            String output = convertStreamToString(entity.getContent());
            System.out.println(output);
            if (entity != null) {
                try (InputStream instream = entity.getContent()) {
                    // do something useful
                }
            }
        } catch (Exception e) {

        }

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
