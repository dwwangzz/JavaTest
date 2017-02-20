package domain;

import lombok.Data;

import java.util.List;

/**
 * Created by wangzz on 2017/2/20.
 */
@Data
public class Demo {

    private Long id;

    private String name;

    private List<String> codes;

}
