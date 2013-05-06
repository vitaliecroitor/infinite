package md.vcroitor.licenta.client.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import md.vcroitor.licenta.common.dto.Response;

import java.io.IOException;
import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 5/6/13
 * Time: 12:43 PM
 */
public class JsonSkipper {
    private static ObjectMapper _objectMapper = new ObjectMapper();

    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return _objectMapper.readValue(json, clazz);
    }

    public static <T> Response<Set<T>> fromJsonSet(String json, TypeReference typeReference) throws IOException {
        return _objectMapper.readValue(json, typeReference);
    }

    public static <T> String toJson(T object) throws JsonProcessingException {
        return _objectMapper.writeValueAsString(object);
    }

}
