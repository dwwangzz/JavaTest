package script;

import javax.script.*;
import java.io.FileReader;

/**
 * @author: wangzz
 * @date: 2022年03月29日 13:47
 */
public class ScriptUtil {


    public static void main(String[] args) {

        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");

            //Bindings bindings = new SimpleBindings();
            //bindings.put("var2", 123);

            FileReader reader = new FileReader("D:\\develop\\IdeaProjects\\JavaTest\\src\\main\\java\\script\\demo.js"); // 执行指定脚本
            engine.eval(reader);


            if (engine instanceof Invocable) {

                Invocable invoke = (Invocable) engine; // 调用merge方法，并传入两个参数

                Double c = (Double) invoke.invokeFunction("main", 2);

                System.out.println("c = " + c);

                // ok = isPrime(5);
                Integer[] nums = {1, 2, 3, 5, 12, 112, 100, 4351561};
                for (Integer num : nums) {
                    System.out.println(num + " --> " + invoke.invokeFunction("isPrime", num));
                }

                //hellp
                Object o = invoke.invokeFunction("hello1", "John");
                System.out.println(o);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("异常了 >>> \n\r" + e.getMessage());
        }

    }

}
