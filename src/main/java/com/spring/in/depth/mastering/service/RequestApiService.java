package com.spring.in.depth.mastering.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spring.in.depth.mastering.utility.JsonUtility;
import com.spring.in.depth.mastering.utility.PropManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class RequestApiService {

    public Map<String, String> jsonNodesCache = new HashMap<>();

    private RequestApiService() {

    }


    public HttpHeaders buildDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        for (Map.Entry<String, Properties> p : PropManager.getInstance().getPropertiesValues().entrySet()) {
            if (p.getKey().contains("default.headers")) {
                p.getValue().entrySet().forEach(prop -> headers.set((String) prop.getKey(), (String) prop.getValue()));
            }
        }
        return headers;
    }

    public HttpEntity<String> buildHttpEntity(String jsonPayload, HttpHeaders headers) {
        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);
        return entity;

    }

    public HttpEntity<String> buildHttpEntity(HttpHeaders headers) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;

    }

    public ObjectNode requestPostAPI(String apiNameKey, HttpEntity<String> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), httpEntity, String.class);
        ObjectNode objectNode = new JsonUtility().getObjectNodFromString(response.getBody());
        return objectNode;
    }

    public String getJsonNodeValue(ObjectNode objectNode, String... nodeName) {
        String nodeValue = "", nodeToCache = "";
        JsonNode jsonNode = objectNode.deepCopy();
        if (jsonNodesCache.get(nodeName[nodeName.length - 1]) == null)
            for (String node : nodeName) {
                jsonNode = jsonNode.get(node);
                nodeValue = jsonNode.asText();
                nodeToCache = node;
            }
        else
            return jsonNodesCache.get(nodeName[nodeName.length - 1]);
        jsonNodesCache.put(nodeToCache, nodeValue);
        return nodeValue;
    }

    public ObjectNode requestGetAPI(String apiNameKey, HttpEntity<String> httpEntity, String... queryParams) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = buildGetUri(PropManager.getInstance().getProperty("env.url") + PropManager.getInstance().getProperty(apiNameKey), queryParams);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        ObjectNode objectNode = new JsonUtility().getObjectNodFromString(response.getBody());
        return objectNode;
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
}


//        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(payload);
//        Map<Object, Object> result = flattenJson.entrySet().stream().collect(Collectors.toMap(d -> d.getKey(), d -> d.getValue()));
