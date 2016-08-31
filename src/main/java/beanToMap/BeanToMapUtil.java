package beanToMap;

import kryo.User;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体转map
 * Created by wangzz on 2016-2-18.
 */
public class BeanToMapUtil {

    public static Map getMap(Object thisObj) {
        Map map = new HashMap();
        Class c;
        try {
            c = Class.forName(thisObj.getClass().getName());
            Method[] m = c.getMethods();
            for (int i = 0; i < m.length; i++) {
                String method = m[i].getName();
                if (method.startsWith("get")) {
                    try {
                        Object value = m[i].invoke(thisObj);
                        if (value != null) {
                            String key = method.substring(3);
                            key = key.substring(0, 1).toUpperCase() + key.substring(1);
                            map.put(method, value);
                        }
                    } catch (Exception e) {
                        System.out.println("error:" + method);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        Map map = getMap(user);
        System.out.println(map);
    }
}
