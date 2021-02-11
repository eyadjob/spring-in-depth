package com.spring.in.depth.mastering.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
