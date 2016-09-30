package reflect;


import ListUtils.EmptyUtil;
import org.junit.Test;
import reflect.entity.IPerson;
import reflect.entity.Person;
import reflect.entity.PointImpl;
import reflect.entity.Student;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wangzz on 2016/9/29.
 */
public class ReflectStudy {

    public static void main(String[] args) throws Exception {
        //Animal animal = new Animal();
        //animal.setName("cat");
        //System.out.println(animal);
    }

    //==========================夯实JAVA基本之二 —— 反射（1）：基本类周边信息获取====================================
    //==================== http://blog.csdn.net/harvic880925/article/details/50072739 ============================
    @Test
    public void test1() {
        //1、泛型隐藏填充类型默认填充为无界通配符？
        //使用方法一 //在泛型中，如果把泛型的填充给省略掉，那就会默认填充为无界通配符
        Class class1 = Animal.class;
        System.out.println(class1.getName());
        //使用方法二
        Class<?> class2 = Animal.class;
        System.out.println(class2.getName());
        //使用方法三
        Class<Animal> class3 = Animal.class;
        System.out.println(class3.getName());
    }

    @Test
    public void test2() throws Exception {
        //2、获取类类型的方法
        //方法一：
        Person person = new Person();
        Class a = person.getClass();
        //方法二：
        Class b = Person.class;
        //方法三：
        Class c = Class.forName("reflect.entity.Person");
        //方法四：（不建议使用）
        //Class d = context.getClassLoader().loadClass(String ClassName);
    }

    @Test
    public void test3() {
        //1、类名，包名获取
        Class<?> class1 = Animal.class;
        Package package1 = class1.getPackage();
        System.out.println("完整的类名：" + class1.getName());
        System.out.println("仅获取类名：" + class1.getSimpleName());
        System.out.println("包名：" + package1.getName());
    }

    @Test
    public void test4() {
        //2.获取超类Class对象
        Class<?> clazz = Student.class;
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("父类：" + parentClass.getName());
    }

    @Test
    public void test5() {
        //3.获取类所直接继承的接口的Class对象
        //获取Person类的接口列表
        Class<?> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class interItem : interfaces) {
            System.out.println(clazz.getSimpleName() + "实现的接口：" + interItem.getName());
        }

        //获取Student的接口列表
        clazz = ReflectDemo.class;
        interfaces = clazz.getInterfaces();
        if (EmptyUtil.isNotEmpty(interfaces)) {
            for (Class interItem : interfaces) {
                System.out.println(clazz.getSimpleName() + "实现的接口：" + interItem.getName());
            }
        } else {
            System.out.println(clazz.getSimpleName() + "无实现的接口");
        }
    }

    @Test
    public void test6() {
        //4.获取所传类类型的所有实现的接口、继承的类列表
        Class<?>[] allInterface = getAllInterface(Student.class);
        if (EmptyUtil.isNotEmpty(allInterface)) {
            for (Class<?> aClass : allInterface) {
                System.out.println(aClass.getName());
            }
        }
    }

    @Test
    public void test7() {
        //5.获取类的访问修饰符
        Class<?> clazz = Animal.class;
        int modifiers = clazz.getModifiers();
        System.out.println(modifiers);
        String retval = Modifier.toString(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);
        System.out.println("Animal的定义修饰符:" + retval);
        System.out.println("is Final:" + isFinal);
        //6.获取接口的访问修饰符
        Class<?> iPersonClass = IPerson.class;
        int modifiers2 = iPersonClass.getModifiers();
        String retval2 = Modifier.toString(modifiers2);
        boolean isInteface = Modifier.isInterface(modifiers2);
        System.out.println("IPerson的定义修饰符:" + retval2);
        System.out.println("isInteface:" + isInteface);
        //注
        /**
         //根据整型变量来生成对应的修饰符字符串
         String Modifier.toString(int modifiers)
         //以下这些方法来检查特定的修饰符是否存在
         boolean Modifier.isAbstract(int modifiers)
         boolean Modifier.isFinal(int modifiers)
         boolean Modifier.isInterface(int modifiers)
         boolean Modifier.isNative(int modifiers)
         boolean Modifier.isPrivate(int modifiers)
         boolean Modifier.isProtected(int modifiers)
         boolean Modifier.isPublic(int modifiers)
         boolean Modifier.isStatic(int modifiers)
         boolean Modifier.isStrict(int modifiers)
         boolean Modifier.isSynchronized(int modifiers)
         boolean Modifier.isTransient(int modifiers)
         boolean Modifier.isVolatile(int modifiers)
         */

    }

    //==========================夯实JAVA基本之二 —— 反射（2）：泛型相关周边信息获取====================================
    //==================== http://blog.csdn.net/harvic880925/article/details/50085595 ============================
    @Test
    public void test8() {
        //1.获取泛型超类相信信息
        Class<?> clazz = PointImpl.class;
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type parameterArgType : actualTypeArguments) {
                Class parameterArgClass = (Class) parameterArgType;
                System.out.println("填充类型为：" + parameterArgClass.getName());
            }

            //返回 Type 对象，表示声明此类型的类或接口。
            Type type1 = parameterizedType.getRawType();
            Class class22 = (Class) type1;
            System.out.println("PointImpl的父类类型为：" + class22.getName());

        }
    }

    @Test
    public void test9() {
        //（1）、获取泛型超类
        Class<?> clazz = PointImpl.class;
        Type type = clazz.getGenericSuperclass();
    }


    //==========================夯实JAVA基本之二 —— 反射（3）：类内部信息获取====================================
    //==================== http://blog.csdn.net/harvic880925/article/details/50107951 ============================


    /**
     * 获取所传类类型的所有继承的接口列表
     * @param clazz
     * @return
     */
    public Class<?>[] getAllInterface(Class<?> clazz) {

        //获取自身的所有接口
        Class<?>[] interSelf = clazz.getInterfaces();
        //递规调用getAllInterface获取超类的所有接口
        Class<?> superClazz = clazz.getSuperclass();
        Class<?>[] interParent = null;
        if (null != superClazz) {
            interParent = getAllInterface(superClazz);
        }

        //返回值
        if (interParent == null && interSelf != null) {
            return interSelf;
        } else if (interParent == null && interSelf == null) {
            return null;
        } else if (interParent != null && interSelf == null) {
            return interParent;
        } else {
            final int length = interParent.length + interSelf.length;
            Class<?>[] result = new Class[length];
            System.arraycopy(interSelf, 0, result, 0, interSelf.length);
            System.arraycopy(interParent, 0, result, interSelf.length, interParent.length);
            return result;
        }
    }

    //=========================================================================//
    public static final class Animal {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    //=========================================================================//
}
