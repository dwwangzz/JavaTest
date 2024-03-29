package script;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wangzz
 * @date: 2021年11月08日 16:47
 */
public class ScriptDemo {

    Pattern pattern = Pattern.compile("function\\s+(\\w*)\\((.*)\\)");
    //Pattern pattern = Pattern.compile("(function\\s+main\\()(.*)(\\))");
    //Pattern pattern = Pattern.compile("(function\\s+main\\()(.*)(\\))");

    @Test
    public void test() {
        String js = "function main(var1) {\n" +
                "    var sum = (var1 + var2) / (score1 + score2);\n" +
                "    return sum;\n" +
                "}" +
                "function main(var11, var22, score11, score22) {\n" +
                "    var sum = (var1 + var2) / (score1 + score2);\n" +
                "    return sum;\n" +
                "}";


        Matcher matcher = pattern.matcher(js);
        //StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            //System.out.println(matcher.group(1));
            String group = matcher.group(1);
            System.out.println(group);
            String group1 = matcher.group(2);
            System.out.println(group1);
            break;
            //System.out.println(matcher.group(3));
            //buffer.append(matcher.group());
            //buffer.append("\r\n");
        }
        //System.out.println(buffer);

    }

    @Test
    public void test1() {

        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");

            String jsFileName = "expression.js"; // 读取js文件

            //String path = ScriptDemo.class.getClassLoader().getResource("").getPath();
            //System.out.println("path=" + path);
            //FileReader reader = new FileReader(path + jsFileName); // 执行指定脚本
            FileReader reader = new FileReader("D:\\develop\\IdeaProjects\\JavaTest\\src\\main\\java\\script\\expression.js"); // 执行指定脚本
            engine.eval(reader);

            if (engine instanceof Invocable) {

                Invocable invoke = (Invocable) engine; // 调用merge方法，并传入两个参数
                // c = merge(2, 3);
                Double c = (Double) invoke.invokeFunction("merge", 2, 3);

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

        }

    }

}
