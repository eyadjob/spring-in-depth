package com.spring.in.depth.mastering.service;

import com.spring.in.depth.mastering.bean.post.BookingCalculateBillingInformation;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestApiService {

    public Map<String, String> jsonNodesCache = new HashMap<>();
    RestTemplate restTemplate;
    RetryTemplate retryTemplate;

    private RequestApiService() {
        restTemplate = new RestTemplate();
        retryTemplate = new RetryTemplate();

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(Integer.parseInt(PropManager.getInstance().getProperty("max.attempts")));

        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(Integer.parseInt(PropManager.getInstance().getProperty("backoff.period")));
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);


    }

    public static String buildGetUri(String url, String... params) {
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


//    public ResponseEntity<Object> requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity, Class className) {
//
//        System.out.println("Begin /POST request!");
//        String postUrl = "http://ejar-jor-st.iyelo.com:5600/api/FileUpload/UploadBase64File";
//        String name = "te.jpg";
//        String imagePath = "D:\\te.jpg";
//        String data = UtilBase64Image.encoder(imagePath);
//
//        System.out.println("Post Image'info: name = " + name + " ,data = " + data);
//        Image customer = new Image(name, data);
//        
////        ResponseEntity postResponse = restTemplate.postForEntity(postUrl, customer, String.class);
//
//        restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), new HttpEntity<>("\"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/wAARCAD6APoDAREAAhEBAxEB/8QAFQABAQAAAAAAAAAAAAAAAAAAAAv/xAAUEAEAAAAAAAAAAAAAAAAAAAAA/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJ/4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP/9k=\"", httpEntity.getHeaders()), String.class);
////        System.out.println("Response for Post Request: " + postResponse.getBody());
//
//
//        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, className);
//    }

    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public ResponseEntity<String> requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity) {
        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, String.class);

    }

    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public ResponseEntity requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity, Class className) {

        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, className);
    }
    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public ResponseEntity<Object> requestPostAPI1(String apiNameKey, HttpEntity<Object> httpEntity, Class className) {

        return restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, className);
    }


    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public ResponseEntity<String> requestGetAPI(String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return restTemplate.getForEntity(uri, String.class);
    }

    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public ResponseEntity<Object> requestGetAPI(Class className, String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return restTemplate.getForEntity(uri, className);
    }

    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public ResponseEntity<Object> requestExchangeAPI(Class className, HttpEntity<String> httpEntity, String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        return new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, className);
    }

    @Retryable(maxAttempts = 20,
            backoff = @Backoff(delay = 3, multiplier = 2))
    public Object requestGetByJava(Class className, HttpEntity<String> httpEntity, String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        buildHeaderForNormalJavaRequest(httpGet, httpEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            org.apache.http.HttpEntity entity = response.getEntity();
            String output = convertStreamToString(entity.getContent());
            return JsonUtility.getJsonObjectFromString(output, className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object requestPostByJava(Class className,Object object, HttpEntity<String> httpEntity, String apiNameKey, String... queryParams) {
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpGet = new HttpPost(uri);
        buildHeaderForNormalJavaRequest(httpGet, httpEntity);
        HttpResponse response = null;
        StringEntity requestEntity = new StringEntity(
                JsonUtility.getJsonStringFromObjectNode(object),
                ContentType.APPLICATION_JSON);
        try {
            for (Map.Entry<String,List<String>> v : httpEntity.getHeaders().entrySet()) {
                httpGet.setHeader(v.getKey(),v.getValue().get(0));
            }
            httpGet.setEntity(requestEntity);
            response = httpclient.execute(httpGet);
            org.apache.http.HttpEntity entity = response.getEntity();
            String output = convertStreamToString(entity.getContent());
            return JsonUtility.getJsonObjectFromString(output, className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object requestPostEncode64ByJava(Class className, HttpEntity<String> httpEntity, String apiNameKey, String... queryParams) {

        try {
            String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpGet = new HttpPost(uri);
            buildHeaderForNormalJavaRequest(httpGet, httpEntity);
            CloseableHttpResponse response = null;
            MultipartEntity mpEntity = new MultipartEntity();
            File file = new File("D:\\te.txt");

            ContentBody cbFile = new StringBody("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA2sAAADaCAYAAAA4y9rdAAAbSElEQVR4Xu3dz2sdVRsH8JOdomCDILixzcaNYFOXbpou3LhpBN0JSReKPxZJRJeSZuOqmAaqIAhJcKGC0OQ/aATpSkiXBRfJHyAYN9qVL8+8TLi9vUlvJnfuPTPzGQjxx70z53yes8iXM/PM1H///fdfchAgQIAAAQIECBAgQIBAVgJTwlpW9TAYAgQIECBAgAABAgQIFALCmoVAgAABAgQIECBAgACBDAWEtQyLYkgECBAgQIAAAQIECBAQ1qwBAgQIECBAgAABAgQIZCggrGVYFEMiQIAAAQIECBAgQICAsGYNECBAgAABAgQIECBAIEMBYS3DohgSAQIECBAgQIAAAQIEhDVrgAABAgQIECBAgAABAhkKCGsZFsWQCBAgQIAAAQIECBAgIKxZAwQIECBAgAABAgQIEMhQQFjLsCiGRIAAAQIECBAgQIAAAWHNGiBAgAABAgQIECBAgECGAsJahkUxJAIECBAgQIAAAQIECAhr1gABAgQIECBAgAABAgQyFBDWMiyKIREgQIAAAQIECBAgQEBYswYIECBAgAABAgQIECCQoYCwlmFRDIkAAQIECBAgQIAAAQLCmjVAgAABAgQIECBAgACBDAWEtQyLYkgECBAgQIAAAQIECBAQ1qwBAgQIECBAgAABAgQIZCggrGVYFEMiQIAAAQIECBAgQICAsGYNECBAgAABAgQIECBAIEMBYS3DohgSAQIECBAgQIAAAQIEhDVrgAABAgQIECBAgAABAhkKCGsZFsWQCBAgQIAAAQIECBAgIKxZAwQIECBAgAABAgQIEMhQQFjLsCiGRIAAAQIECBAgQIAAAWHNGiBAgAABAgQIECBAgECGAsJahkUxJAIECBAgQIAAAQIECAhr1gABAgQIECBAgAABAgQyFBDWMiyKIREgQIAAAQIECBAgQEBYswYIECBAgAABAgQIECCQoYCwlmFRDIkAAQIECBAgQIAAAQLCmjVAgAABAgQIECBAgACBDAWEtQyLYkgECBAgQIAAAQIECBAQ1qwBAgQIECBAgAABAgQIZCggrGVYFEMiQIAAAQIECBAgQICAsGYNECBAgAABAgQIECBAIEMBYS3DohgSAQIECBAgQIAAAQIEhDVrgAABAgQIECBAgAABAhkKCGsZFsWQCBAgQIAAAQIECBAgIKxZAwQIECBAgAABAgQIEMhQQFjLsCiGRIAAAQIECBAgQIAAAWHNGiBAgAABAgQIECBAgECGAsJahkUxJAIECBAgQIAAAQIECAhr1gABAgQIECBAgAABAgQyFBDWMiyKIREgQIAAAQIECBAgQEBYswYIECBAgAABAgQIECCQoYCwlmFRDIkAAQIECBAgQIAAAQLCmjVAgAABAgQIECBAgACBDAWEtQyLYkgECBAgQIAAAQIECBAQ1qwBAgQIECBAgAABAgQIZCggrGVYFEMiQIAAAQIECBAgQICAsGYNECBAgAABAgQIECBAIEMBYS3DohgSAQIECBAgQIAAAQIEhDVrgAABAgQIECBAgAABAhkKCGsZFsWQCBAgQIAAAQIECBAgIKxZAwQIECBAgAABAgQIEMhQQFjLsCiGRIAAAQIECBAgQIAAAWHNGiBAgAABAgQIECBAgECGAsJahkUxJAIECBAgQIAAAQIECAhr1gABAgQIECBAgAABAgQyFBDWMiyKIREgQIAAAQIECBAgQEBYswYIECBAgAABAgQIECCQoYCwlmFRDIkAAQIECBAgQIAAAQLCmjVAgACBEQs8fPgw/fLLL+m5555Ly8vLIz670xEgQIAAAQJdERDWulJp8yRAoBaBg4OD9OOPP6YXX3yx+P3o0aN0//7942v98MMP6f3336/l2k5KgAABAgQItFtAWGt3fc2OAIGaBHZ2dtLa2lra398/9Qrfffdd+vDDD2sahdMSIECAAAECbRYQ1tpcXXMjQGDkArGTFiFta2vrxHO//vrr6aWXXkrvvfeeoDbyCjghAQIECBDojoCw1p1amykBAucQ+Ouvv9LGxka6fft2in8+6bh582ZaXV09x5V8lQABAgQIECDwfwFhzUogQIDAKQLDhrTXXnst3blzJ83NzfEkQIAAAQIECIxEQFgbCaOTECDQNoFhQ9rFixdT7KYtLi62jcB8CBAgQIAAgQkLCGsTLoDLEyCQl8CwIe2FF14o2vLHz4ULF/KahNEQIECAAAECrRAQ1lpRRpMgQOC8AsOGtLhOPJMmpJ1X3PcJECBAgACBpwkIa08T8v8JEGi9QHR2XFlZObVxSOykxa2OEdIuXbrUehMTJECAAAECBCYvIKxNvgZGQIDAhATu3btXtOGP3ycdly9fLkJa/LjdcUKFclkCBAgQINBRAWGto4U3bQJdFihveYzGIIOO2EWbn58vdtFmZ2e7TGXuBAgQIECAwAQFhLUJ4rs0AQLjF/j+++/TrVu30sOHD5+4+PXr14sdtAhqDgIECBAgQIDApAWEtUlXwPUJEBiLQOym3bhxI+3s7Dx2vWi9Xz6L5jbHsZTCRQgQIECAAIEhBYS1IaF8jACBZgqcdMvjW2+9lT755BO7aM0sq1ETIECAAIFOCAhrnSizSRLopsD29nbx3FkEtvK4evVqun37tmfRurkkzJoAAQIECDRKQFhrVLkMlgCBYQTiVsdoxX9wcHD88bjdMRqKxC2PDgIECBAgQIBAEwSEtSZUyRgJEBhKYFAr/ujsGLtrXmI9FKEPESBAgAABAhkJCGsZFcNQCBCoJhC3O8auWe9OWpxpYWGhuOVR45Bqrr5FgAABAgQITFZAWJusv6sTIFBRoGwcsrW1NTCkRXi7dOlSxbP7GgECBAgQIEBg8gLC2uRrYAQECJxBYHd3t2i/HyGt9yhfZC2knQHTRwkQIECAAIGsBYS1rMtjcAQIxA5aBLR4Hi1CWm9nx9CJxiHxPFo0DnG7o/VCgAABAgQItElAWGtTNc2FQEsE9vb2jsPZ/v7+E7Mqd9EioM3NzbVk1qZBgAABAgQIEHhcQFizIggQmLhABLLegDZoQLGDNj8/X4Sz+O0gQIAAAQIECLRdQFhre4XNj0CmAuWzZ3F7Y38XxxhyhLMIZuWPZiGZFtKwCBAgQIAAgdoEhLXaaJ2YAIFegfLZs3juLAJa/7NnV69ePQ5ms7Oznj+zfAgQIECAAIHOCwhrNS+B8g/UuMz169f9AVqzt9PnJdAb0CKklUc8c9a7axbhzEGAAAECBAgQIPC4gLBW84q4detW+uKLL4qrxB+k0VY8QpuDQJsEIpTFc2dHR0fF7/LfYwetPHp3zjQFaVP1zYUAAQIECBCoS0BYq0s2peJWrw8++CD98ccfT1wlGiQsLS3pZFejv1OPViBC2OHhYfF8Wf9P/y2NsXNW7pZFW/0IZ9rqj7YezkaAAAECBAi0X0BYq7HGn332WVpfXz/1ChHaNjc3/SFbYx2cejiBCFwPHjx4IoiVO2X9Z7l8+XKxbsvny+J3NAGJH8FsOHOfIkCAAAECBAicJiCs1bg+Pv300/Ttt9+mr7/+Or3zzjtpa2ur+Indid4j/si9e/du8Ueug0CdAv2BrLxNsfd2xd7rx62LcZQ7Y72BrM5xOjcBAgQIECBAgEBKwlrNq2BmZia9/fbb6Ztvvjm+UjRaiPDWe8RtYxsbG2lhYaHmETl92wXKQFbuiJ0WyMrbFcsdsd5dMrtjbV8p5keAAAECBAjkLiCs1Vyha9euFbeV3b59+7HGIvGHdOxWREOG3iP+2+rqqmfZaq5L00/f38xjmEDWf7uiDoxNXwXGT4AAAQIECLRdQFirucKff/55unPnTnr06FHxHM/i4mKxexZ/KEeIi9/9gS2GJLTVXJjMTx9rI26XLbsqlr+HfX6s97bFzKdqeAQIECBAgAABAicICGtjWhpx62P5E+EsQloEtzfeeCN9+eWXaW9vb+BI4o/uaFJiF2RMhRrTZcp6l+Gr7K5YhrJBw/D82JiK4zIECBAgQIAAgUwEhLUJFKI/uEVHyFdeeSX9/vvv6bfffjsxtLk9cgLFGvKS5W2J8fEyePX/80m7YvG53lb3/bti3kk2ZBF8jAABAgQIECDQMgFhbcIFjWeNIrzF72ibHg1J/vzzz/T3338PHFnsxkVo0zlyNIXrDVnlGXvD1kn/bdBn+kd08eLF4zqVLe7jM2Uzj/jn8jmy0czGWQgQIECAAAECBNokIKxlVM24BS5CWwSIX3/9Nd2/fz/9+++/A0cYf/C/+eab6dVXXy3+/z///JNefvnlJ95xVb4LK6NpDj2U8Iif3lcdlCEp5vvss88enys+F/+v/+XM8YH4772/TxpAhKsIVYO6IA4KVb0BLM4Z/+4dY0OX1wcJECBAgAABAgSeIiCsZb5E4r1sN2/efOLdbDHs559/Pr377rtFYIvn4J555pkirJTBJT5T/nPZxKQME72BpD+IlIFlVLt3g3ahBj2b1fu5/pBZPrNXjjtuG5yeni7m97Tn+cr5lJ+N39rSZ77wDY8AAQIECBAgQMB71pqyBqL1f4S2QZ0jI1TF/xv2HW394ak/4JUm5U7VoN2qYdz6A1a5+1TuQJXn6N+hGubcPkOAAAECBAgQIECg7QJ21hpU4QhNEdri56TQFp0jo2GJgwABAgQIECBAgACBZgsIaw2sX4S25eXltL29PXD03tHWwKIaMgECBAgQIECAAIE+AWGtwUsiblOM2x9PCm0R6KJzpOezGlxkQydAgAABAgQIEOisgLDWgtJHB8kIbYNerB1BLf7f0tJSC2ZqCgQIECBAgAABAgS6IyCstajW8b622E3rbXVfTi+akGxubiYvWG5RwU2FAAECBAgQIECg1QLCWgvLe1rnyGg+Ek1IRtWWv4V8pkSAAAECBAgQIEAgCwFhLYsyjH4Q0YQkbn+M97T1d450a+TovZ2RAAECBAgQIECAwKgFhLVRi2Z2vmhCErdG7u7uPjGyeA9a7LK5NTKzohkOAQIECBAgQIAAgZS8FLsrq+C0JiRlAxJdI7uyGsyTAAECBAgQIECgCQJ21ppQpRGO8aQmJBHUogGJF2qPENupCBAgQIAAAQIECJxDQFg7B16Tvxq7adGIpP95tsXFxeLWSLtsTa6usRMgQIAAAQIECLRBQFhrQxUrziGakERgW1tbe+wMGpBUBPU1AgQIECBAgAABAiMUENZGiNnUU0UTkthp297efmwKGpA0taLGTYAAAQIECBAg0AYBYa0NVRzRHE5qQhLdJFdXV90aOSJnpyFAgAABAgQIECAwjICwNoxSxz4ToS0C2oMHD45nHi/RjgYk2vx3bDGYLgECBAgQIECAwMQEhLWJ0ed/4XihdtweeXh4eDzYCGsR2iK8OQgQIECAAAECBAgQqE9AWKvPtjVn7u8cqQFJa0prIgQIECBAgAABAhkLCGsZFyenoZWdI3vb/WtAklOFjIUAAQIECBAgQKBtAsJa2ypa83wGhTbvZqsZ3ekJECBAgAABAgQ6KSCsdbLs5590hLa4PTKea4sXa8etkbHrtrCwcP6TOwMBAgQIECBAgAABAklYswjOJVCGto2NjeI80YBkfX09xS2SDgIECBAgQIAAAQIEqgsIa9XtfLNHoLw9cm1trfivH3/8cfrqq6+8m80qIUCAAAECBAgQIFBRQFirCOdrgwUitH300Ufp559/Ltr7xy7b/Pw8LgIECBAgQIAAAQIEziggrJ0RzMeHE9jf30/ReCRerB0v2F5dXbXLNhydTxEgQIAAAQIECBAoBIQ1C6E2gdhliwYkKysrGpDUpuzEBAgQIECAAAECbRUQ1tpa2YzmFbtssbu2t7dX7LbFrZHRPdJBgAABAgQIECBAgMDJAsKa1TE2gWj1H+39p6eni9siI7g5CBAgQIAAAQIECBAYLCCsWRljFTg4OCgajsSzbNr8j5XexQgQIECAAAECBBomIKw1rGBtGW48yxa3Rk5NTR03IGnL3MyDAAECBAgQIECAwCgEhLVRKDpHJYHYZYvAtru7W+yybW5uFu3+HQQIECBAgAABAgQI6AZpDWQgEM+xxfNsR0dHRXiLBiQOAgQIECBAgAABAl0XsLPW9RWQyfyjzX8Ete3t7TQ7O1vsssVvBwECBAgQIECAAIGuCghrXa18pvPe2dkpQtvh4aGXaWdaI8MiQIAAAQIECBAYj4CwNh5nVzmDQOyyxW2RGxsbxfvYYpctOkg6CBAgQIAAAQIECHRJQFjrUrUbNtd4mXa8iy3a/EdYi2fZNCBpWBENlwABAgQIECBAoLKAsFaZzhfHJVC+TFub/3GJuw4BAgQIECBAgEAOAsJaDlUwhqcKRJv/2GXb29srGo/ELlu0+3cQIECAAAECBAgQaKuAsNbWyrZ0XtGAJEJb2eZ/dXW1eK7NQYAAAQIECBAgQKBtAsJa2yragflEA5J4N9va2poGJB2otykSIECAAAECBLoqIKx1tfItmPe9e/eKrpFxa2TcEhm3Rno3WwsKawoECBAgQIAAAQKFgLBmITReQAOSxpfQBAgQIECAAAECBAYICGuWRSsEogFJhLbt7W0NSFpRUZMgQIAAAQIECBAQ1qyBVglEA5Ll5eV0eHhY/NaApFXlNRkCBAgQIECAQKcEhLVOlbsbk+1tQBIv0d7c3NTmvxulN0sCBAgQIECAQKsEhLVWldNkegX29/eL3bVoQDI/P1+ENm3+rRECBAgQIECAAIGmCAhrTamUcVYWiDb/8Tzb1NRUEdgiuDkIECBAgAABAgQI5C4grOVeIeMbiUBvA5Jo8x+hLW6RdBAgQIAAAQIECBDIVUBYy7UyxlWLQLybLXbWYpctdtuWlpZquY6TEiBAgAABAgQIEDivgLB2XkHfb5xANCCJoLaxsVE0HrHL1rgSGjABAgQIECBAoBMCwlonymySgwRil21xcTEdHR15ls0SIUCAAAECBAgQyE5AWMuuJAY0ToHeNv9xe+T6+rpn2cZZANciQIAAAQIECBA4UUBYszgIpJSizX/sssXLtO/eveu9bFYFAQIECBAgQIDAxAWEtYmXwAByESh32aLV/5UrV4rQ5r1suVTHOAgQIECAAAEC3RMQ1rpXczN+ikDvLpv3slkuBAgQIECAAAECkxIQ1iYl77rZCywvLxcdI+N3PMvmIECAAAECBAgQIDBOAWFtnNqu1TiB2GUr38sWt0XOzs42bg4GTIAAAQIECBAg0EwBYa2ZdTPqMQvEe9niWbaVlZXiRdqeZRtzAVyOAAECBAgQINBBAWGtg0U35WoC5bNs09PTXqRdjdC3CBAgQIAAAQIEziAgrJ0By0cJ9L6XLXbaYpfNQYAAAQIECBAgQKAOAWGtDlXnbL1Aucs2MzNT7LK5LbL1JTdBAgQIECBAgMDYBYS1sZO7YFsEYpctnmX76aefip+5ubm2TM08CBAgQIAAAQIEMhAQ1jIogiE0W+DevXtFx0jNR5pdR6MnQIAAAQIECOQmIKzlVhHjaaRA7LKVLf7jtshLly41ch4GTYAAAQIECBAgkI+AsJZPLYykBQJxW2S8SDsCW4Q3BwECBAgQIECAAIGqAsJaVTnfI3CCQHlb5I0bN9L6+jonAgQIECBAgAABApUEhLVKbL5E4HSBg4ODtLi4mI6OjtLdu3fdFmnBECBAgAABAgQInFlAWDszmS8QGF4g3sUWjUe8k214M58kQIAAAQIECBD4v4CwZiUQqFkg3skWz69duXLFO9lqtnZ6AgQIECBAgECbBIS1NlXTXLIWiNsid3d3NR/JukoGR4AAAQIECBDIR0BYy6cWRtIBgZ2dnbS8vJyuXbtWNB+5cOFCB2ZtigQIECBAgAABAlUEhLUqar5D4BwC8U62CGx7e3tFYNPi/xyYvkqAAAECBAgQaLGAsNbi4ppa3gLlLls8yxahzYu0866X0REgQIAAAQIExi0grI1b3PUI9AjELlu8SHt7e7v4vbS0xIcAAQIECBAgQIBAISCsWQgEMhCIF2nHrZFTU1PFLtvc3FwGozIEAgQIECBAgACBSQoIa5PUd20CfQKxuxbvZCsbkLg10hIhQIAAAQIECHRXQFjrbu3NPFOBg4OD4pbIaPMfu21xa6SukZkWy7AIECBAgAABAjUKCGs14jo1gfMIxK2REdoODw+L3wsLC+c5ne8SIECAAAECBAg0TEBYa1jBDLd7AmXXyHiebXNz0/Ns3VsCZkyAAAECBAh0VEBY62jhTbt5AuXzbNHqP0Kb59maV0MjJkCAAAECBAicRUBYO4uWzxKYsEDZ6n9jYyMtLi6m1dVVoW3CNXF5AgQIECBAgEBdAsJaXbLOS6BGAU1IasR1agIECBAgQIBAJgLCWiaFMAwCVQT29/eLjpGakFTR8x0CBAgQIECAQN4Cwlre9TE6AkMJlE1IZmZmPM82lJgPESBAgAABAgTyFxDW8q+RERIYSqD/ebb19XXvZxtKzocIECBAgAABAnkKCGt51sWoCFQWiOfZ4tbIBw8eeD9bZUVfJECAAAECBAhMXkBYm3wNjIBALQLxUu0IbdPT0yl22WZnZ2u5jpMSIECAAAECBAjUIyCs1ePqrASyEIhbI7e2ttLKykoR3KLV/4ULF7IYm0EQIECAAAECBAicLiCsWSEEOiAQt0bGe9kivEUHSQcBAgQIECBAgED+AsJa/jUyQgIjE4iwZmdtZJxORIAAAQIECBCoVUBYq5XXyQkQIECAAAECBAgQIFBNQFir5uZbBAgQIECAAAECBAgQqFVAWKuV18kJECBAgAABAgQIECBQTUBYq+bmWwQIECBAgAABAgQIEKhVQFirldfJCRAgQIAAAQIECBAgUE1AWKvm5lsECBAgQIAAAQIECBCoVUBYq5XXyQkQIECAAAECBAgQIFBNQFir5uZbBAgQIECAAAECBAgQqFVAWKuV18kJECBAgAABAgQIECBQTUBYq+bmWwQIECBAgAABAgQIEKhVQFirldfJCRAgQIAAAQIECBAgUE1AWKvm5lsECBAgQIAAAQIECBCoVUBYq5XXyQkQIECAAAECBAgQIFBNQFir5uZbBAgQIECAAAECBAgQqFVAWKuV18kJECBAgAABAgQIECBQTUBYq+bmWwQIECBAgAABAgQIEKhVQFirldfJCRAgQIAAAQIECBAgUE1AWKvm5lsECBAgQIAAAQIECBCoVUBYq5XXyQkQIECAAAECBAgQIFBNQFir5uZbBAgQIECAAAECBAgQqFVAWKuV18kJECBAgAABAgQIECBQTUBYq+bmWwQIECBAgAABAgQIEKhVQFirldfJCRAgQIAAAQIECBAgUE3gfzi3U/qcEHaEAAAAAElFTkSuQmCC", ContentType.IMAGE_JPEG);
            mpEntity.addPart("userfile", cbFile);

            httpGet.setEntity(mpEntity);
            response = httpclient.execute(httpGet);
            org.apache.http.HttpEntity entity = response.getEntity();
            String output = convertStreamToString(entity.getContent());
            return JsonUtility.getJsonObjectFromString(output, className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpRequestBase buildHeaderForNormalJavaRequest(HttpRequestBase httpRequestBase, HttpEntity<String> httpEntity) {
        for (Map.Entry<String, List<String>> v : httpEntity.getHeaders().entrySet()) {
            httpRequestBase.addHeader(v.getKey(), v.getValue().get(0));
        }
        return httpRequestBase;
    }
}

