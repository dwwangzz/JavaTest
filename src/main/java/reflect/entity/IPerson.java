package reflect.entity;

import java.io.Serializable;

/**
 * Created by wangzz on 2016/9/29.
 */
public interface IPerson extends Serializable{

    void eat();

    void setName(String name);

    String getName();
}
