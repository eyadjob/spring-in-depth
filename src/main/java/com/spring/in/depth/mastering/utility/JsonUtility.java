package com.spring.in.depth.mastering.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.wnameless.json.flattener.JsonFlattener;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JsonUtility {


    public Object getJsonFromString(String inputString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Object jsonObject = objectMapper.readValue(inputString, Object.class);
            return jsonObject;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObjectNode getObjectNodFromString(String input) {
        try {
            JSONObject obj = new JSONObject();
            ObjectNode node = new ObjectMapper().readValue(input, ObjectNode.class);
            return node;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getJsonStringFromObjectNode(ObjectNode jsonObjectNode) {
        String jsonString = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(jsonObjectNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public String setNodesValuesAndGetJsonString(String payLoad, String... nodes) {
        ObjectNode objectNode = getObjectNodFromString(payLoad);
        for (String node : nodes) {
            objectNode.put(node.split(":")[0], node.split(":")[1]);
        }
        return getJsonStringFromObjectNode(objectNode);
    }

    public String getJsonNodeValue(ObjectNode objectNode, String... nodeName) {
        String nodeValue = "";
        JsonNode jsonNode = objectNode.deepCopy();
        for (String node : nodeName) {
            jsonNode = jsonNode.get(node);
            nodeValue = jsonNode.asText();

        }
        return nodeValue;
    }

    public Map<Object, Object> getFlattenJson(String jsonPlayload) {
        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(jsonPlayload);
        Map<Object, Object> result = flattenJson.entrySet().stream().collect(Collectors.toMap(d -> d.getKey(), d -> d.getValue()));
        return result;
    }

    public static void fillJsonArraysNodes(ArrayNode arrayNode, String... indexKeysAndValues) {
        for (String s : indexKeysAndValues) {
            int index = Integer.parseInt(s.split(":")[0]);
            String key = s.split(":")[1];
            String value = s.split(":")[2];
            ((ObjectNode) arrayNode.get(index)).put(key,value);
        }
    }
}
