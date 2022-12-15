package guava;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.eclipse.jetty.util.ajax.JSON;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by wangzz on 2017/5/12.
 */
public class GuavaDemo {

    @Test
    public void test1() {
        //Optional.of(T) 创建指定引用的Optional实例，若引用为null则快速失败
        //Optional.absent() 创建引用缺失的Optional实例
        //Optional.fromNullable(T) 创建指定引用的Optional实例，若引用为null则表示缺失

        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // returns true
        possible.get(); // returns 5

        Optional<Integer> possible2 = Optional.of(1);

        System.out.println(Objects.equals(new Date(), new Date()));
        ImmutableList<Object> of = ImmutableList.of();

    }

    /**
     * 多值map
     */
    @Test
    public void test2() {
        ListMultimap<String, String> listMultimap = ArrayListMultimap.create();
        listMultimap.put("1", "1");
        listMultimap.put("1", "2");
        listMultimap.put("1", "3");
        listMultimap.put("2", "4");
        listMultimap.put("2", "5");
        listMultimap.put("2", "6");
        System.out.println(listMultimap);

    }

    /**
     * 多keymap
     */
    @Test
    public void test3() {

        MultiKeyMap multiKey = new MultiKeyMap();
        multiKey.put("a", "b", 1);
        multiKey.put("a", "b", 2);
        multiKey.put("a", "c", 3);
        multiKey.put("a", null, 4);
        multiKey.put("a", null, 5);
        String x = JSON.toString(multiKey); 
        System.out.println(x);
        System.out.println(multiKey.get("a", "b"));
        System.out.println(multiKey.get("a","c"));

        Set set = multiKey.keySet();
        System.out.println(set);

        Set set1 = multiKey.entrySet();
        for (Object o : set1) {
            System.out.println(o);
        }

        MultiKeyMap multiKey2 = new MultiKeyMap();
        multiKey2.putAll(multiKey);
        System.out.println(multiKey2);


        Table<String, String, String> table = HashBasedTable.create();
        table.put("key1", "key2", "value");
        table.put("key1", "key3", "value2");
        table.put("key2", "key4", "value23");
        table.put("key3", "key5", "value24");
        System.out.println(table);
    }

    @Test
    public void test4() {
        MultiValueMap multiValueMap = new MultiValueMap();
        multiValueMap.put("1", 1);
        multiValueMap.put("1", 2);
        multiValueMap.put("1", 3);
        multiValueMap.put("2", 3);
        multiValueMap.put("2", 4);
        multiValueMap.put("2", 5);
        System.out.println(multiValueMap);

    }


}
