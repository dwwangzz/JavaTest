package guava;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
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


}
