package com.spring.in.depth.mastering.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
            ObjectNode node = new ObjectMapper().readValue(input, ObjectNode.class);
            return node;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
