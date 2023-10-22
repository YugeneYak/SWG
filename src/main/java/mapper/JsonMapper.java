package mapper;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class JsonMapper {

    private static final Logger LOGGER = Logger.getLogger(JsonMapper.class.getName());

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonMapper(){}

    /**
     * Метод для преобразования строки json в объект
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return Возвращает объект со значениями из json
     */
    public static <T> T jsonToObject(String jsonString, Class<T> clazz) {
        T obj = null;
        try {
            obj = mapper.readValue(jsonString, clazz);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return obj;
    }
}