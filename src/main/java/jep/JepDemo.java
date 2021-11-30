package jep;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;
import com.singularsys.jep.bigdecimal.BigDecComponents;
import com.singularsys.jep.parser.Node;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * Java自定义公式Demo
 * 地址：http://www.singularsys.com/jep/download-trial.php
 * @author: wangzz
 * @date: 2021年11月08日 14:19
 */
public class JepDemo {


    @Test
    public void test1() {
        Jep jep = new Jep();
        try {
            jep.addVariable("x", 10);
            jep.parse("x+1");
            jep.parse("2*x-3");
            Object result = jep.evaluate();

            System.out.println("x + 1 = " + result);
        } catch (JepException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @Test
    public void test2() {
        Jep jep = new Jep();
        try {
            Node n1 = jep.parse("y=x^2");
            Node n2 = jep.parse("z=x+y");
            jep.addVariable("x", 2);
            Object value1 = jep.evaluate(n1);
            Object value2 = jep.evaluate(n2);
            System.out.println(value1);
            System.out.println(value2);

            //for (double x=0.0; x<=1.0; x+=0.1) {
            //    jep.addVariable("x", x);
            //    Object value1 = jep.evaluate(n1);
            //    Object value2 = jep.evaluate(n2);
            //    System.out.println(value1);
            //    System.out.println(value2);
            //}
        }
        catch(JepException e) { }

    }


    @Test
    @SneakyThrows
    public void test3() {
        Jep jep = new Jep();
        jep = new Jep(new BigDecComponents());
        jep.addVariable("x", 10);
        jep.parse("x*0.09");
        Object evaluate = jep.evaluate();
        System.out.println(Math.PI);
    }

    @Test
    @SneakyThrows
    public void test4() {
        Jep jep = new Jep();
        jep.parse("1e3");
        Object evaluate = jep.evaluate();
        System.out.println(evaluate);
    }

}
