package compareUtils;

import lombok.Data;

/**
 * Created by wangzz on 2017/1/16.
 */
@Data
public class TestBean {

    private long id;

    private String name;

    TestBean() {
    }

    TestBean(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
