package com.spring.in.depth.mastering.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.stream.Collectors;

public class JsonUtility<T> {


    public static Object getJsonObjectFromString(String inputString, Class objectClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Object jsonObject = objectMapper.readValue(inputString, objectClass);
            return jsonObject;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ObjectNode getObjectNodFromString(String input) {
        try {
            JSONObject obj = new JSONObject();
            ObjectNode node = new ObjectMapper().readValue(input, ObjectNode.class);
            return node;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getJsonStringFromObjectNode(ObjectNode jsonObjectNode) {
        String jsonString = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(jsonObjectNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String getJsonStringFromObjectNode(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        JsonNode jsonNode = null;
        try {
            json = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public static String setNodesValuesAndGetJsonString(String payLoad, String... nodes) {
        ObjectNode objectNode = getObjectNodFromString(payLoad);
        for (String node : nodes) {
            objectNode.put(node.split(":")[0], node.split(":")[1]);
        }
        return getJsonStringFromObjectNode(objectNode);
    }

    public static String getJsonNodeValue(ObjectNode objectNode, String... nodeName) {
        String nodeValue = "";
        JsonNode jsonNode = objectNode.deepCopy();
        for (String node : nodeName) {
            jsonNode = jsonNode.get(node);
            nodeValue = jsonNode.asText();

        }
        return nodeValue;
    }

    public static void fillJsonArraysNodes(ArrayNode arrayNode, String... indexKeysAndValues) {
        for (String s : indexKeysAndValues) {
            int index = Integer.parseInt(s.split(":")[0]);
            String key = s.split(":")[1];
            String value = s.split(":")[2];
            ((ObjectNode) arrayNode.get(index)).put(key, value);
        }
    }

    public Map<T, T> getFlattenJson(String jsonPlayload) {
        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(jsonPlayload);
        Map<T, T> result = flattenJson.entrySet().stream().filter(d -> d.getValue() != null).collect(Collectors.toMap(d -> (T) d.getKey(), d -> (T) d.getValue()));
        return result;
    }

    public Map<T, T> getFlattenJson(String apiName, String jsonPlayload) {
        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(jsonPlayload);
        Map<T, T> result = flattenJson.entrySet().stream().filter(d -> d.getValue() != null).collect(Collectors.toMap(d -> (T) (apiName + "." + d.getKey()), d -> (T) d.getValue()));
        return result;
    }

    public Map<T, T> setJsonValuesInMap(String apiName, String jsonPayload) {
        return getFlattenJson(apiName, jsonPayload);
    }

    //this is a try to loop through all nodes in JsonObject it was successfully to large degree just get the field name and it easy thing to do
    public void fillJsonNodesValuesRec(Object nodes) {
        if (!(nodes instanceof ArrayNode) && !(nodes instanceof ObjectNode)) {
            ((ObjectNode) nodes).get("value");
            return;
        }


        for (JsonNode js : (JsonNode) nodes) {
            if (js instanceof ObjectNode)
                nodes = js;
            else if (js instanceof ArrayNode)
                nodes = js;
            fillJsonNodesValuesRec(nodes);
        }
    }

    public static String getPrettyJsonText(String jsonText) {
        ObjectMapper mapper = new ObjectMapper();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return  gson.toJson(jsonText);
//            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonText);
    }
}
