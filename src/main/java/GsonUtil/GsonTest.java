package GsonUtil;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.*;

public class GsonTest {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        /*String jsonStr = "{\"code\":200,\"data\":[{\"account\":\"ssss\",\"infos\":[{\"rightType\":12,\"beginDate\":\"2013-05-20\"},{\"rightType\":12}]},{\"account\":\"ddd\",\"infos\":[{\"rightType\":22},{\"rightType\":22}]}]}";

        JsonObject jsonObj = gson.fromJson(jsonStr, JsonObject.class);

        //gson转数组
        //Integer[] ids = gson.fromJson(jsonObj, Integer[].class);

        JsonArray data = jsonObj.getAsJsonArray("data");
        for (JsonElement je : data) {
            JsonObject obj = je.getAsJsonObject();
            String account = obj.getAsJsonObject("account").getAsString();
            JsonArray jsonArray = je.getAsJsonArray();
            System.out.println(obj);
        }

        Type type = new TypeToken<Test>() {
        }.getType();
        Object obj = gson.fromJson(data, type);
        System.out.println(obj);*/

        //test1();
        //test2();

    }

    private static void test2() {
        LinkedHashMap<String, String> sort;

        String json = "{\"id\":\"asc\",\"name\":\"desc\"}";
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
        sort = gson.fromJson(jsonObject,LinkedHashMap.class);
    }


    private static void test1() {
        String json = "{'id':'com.mlgh.dao.PricesReleasedMapper','methods':'method1:value1;method2:value2,value3;'}";
        Map<String, String> map = gson.fromJson(json, HashMap.class);
        String id = map.get("id");
        String methods = map.get("methods");
        System.out.println(map);

        MapperEntity mapperEntity = MapperEntityMap.map.get(id);
        if (mapperEntity == null) {
            mapperEntity = new MapperEntity();
        }
        mapperEntity.setId(id);
        if (methods != null && methods.length() > 0) {
            // 所有方法的键值对
            Map<String, List<String>> method = mapperEntity.getMethods();
            if (method == null) {
                method = new HashMap<String, List<String>>();
            }
            String[] methodsList = methods.split(";");
            if (methodsList != null && methodsList.length > 0) {
                for (String entityStr : methodsList) {
                    String[] entity = entityStr.split(":");
                    String key = null;
                    String value = null;
                    try {
                        key = entity[0];
                        value = entity[1];
                    } catch (Exception e) {
                        // throw new ArrayIndexOutOfBoundsException(e.getMessage());
                    }
                    if (key != null && value != null) {
                        method.put(key, Arrays.asList(value.split(",")));
                    }
                }
            }
            mapperEntity.setMethods(method);
        }
        MapperEntityMap.map.put(id, mapperEntity);

        System.out.println(mapperEntity.toString());
    }
}
