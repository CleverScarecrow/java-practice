package com.scarecrow.serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wangbo
 * @since 2023/6/16 13:37
 */
public class TestJacksonSerializable {


    public static void main(String[] args) throws JsonProcessingException {
        JacksonUser user = new JacksonUser();
        user.setUsername("scarecrow");
        user.setPassword(123456);
        user.setAddress("China");
        String serializeData = serialize(user);
        System.out.println(serializeData);
        Object deserializeData = deserialize(serializeData);
        System.out.println(deserializeData);
    }

    public static <T> String serialize(T obj) throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(obj);
    }

    public static Object deserialize(String serializeData) throws JsonProcessingException {
        return getObjectMapper().readValue(serializeData, Object.class);
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }
}
