package guava;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import org.apache.commons.collections.map.MultiKeyMap;
import org.junit.Test;

import java.util.Date;
import java.util.Objects;

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
        System.out.println(multiKey);
        System.out.println(multiKey.get("a", "b"));

        Table<String, String, String> table = HashBasedTable.create();
        table.put("key1", "key2", "value");
    }


}
