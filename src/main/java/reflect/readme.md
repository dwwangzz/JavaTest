前言 java的生命周期
------------------
- 装载
> 类的装载是通过类加载器完成的，加载器将.class文件的二进制文件装入JVM的方法区，并且在堆区创建描述这个类的java.lang.Class对象。用来封装数据。 但是同一个类只会被类装载器装载一次，记住：只装载一次！

- 链接
> 链接就是把二进制数据组装为可以运行的状态。链接分为校验，准备，解析这3个阶段。校验一般用来确认此二进制文件是否适合当前的JVM
（版本），准备就是为静态成员分配内存空间，并设置默认值。解析指的是转换常量池中的代码作为直接引用的过程，直到所有的符号引用都可以被运行程序使用（建立完整的对应关系）。

- 初始化
> 初始化就是对类中的变量进行初始化值；完成之后，类型也就完成了初始化，初始化之后类的对象就可以正常使用了，直到一个对象不再使用之后，将被垃圾回收。释放空间。
当没有任何引用指向Class对象时就会被卸载，结束类的生命周期。如果再次用到就再重新开始装载、链接和初始化的过程。

上面这一大段有关类生命周期有讲解，可能会有些难度，毕竟有关JVM的东东不是三言两语能讲透彻的，通过上面的这一段只想告诉大家一点：类只会被装载一次！！！！利用装载的类可以实例化出各种不同的对象！

test8
-----------------
#####Class.forName(String className)与ClassLoader.loadClass(String ClassName)的区别
我们通过源码来看看他们的区别：

先看Class.forName：
```
public static Class<?> forName(String className) throws ClassNotFoundException {
    return forName(className, true, VMStack.getCallingClassLoader());
}

public static Class<?> forName(String className, boolean initializeBoolean,
        ClassLoader classLoader) throws ClassNotFoundException {

    Class<?> result;
    try {
        result = classForName(className, initializeBoolean,
                classLoader);
    } catch (ClassNotFoundException e) {
        Throwable cause = e.getCause();
        if (cause instanceof ExceptionInInitializerError) {
            throw (ExceptionInInitializerError) cause;
        }
        throw e;
    }
    return result;
}
```
从源中可以看到Class.forName(String className),最终调用的是forName(String className, boolean initializeBoolean,ClassLoader classLoader)
其中：
- className:类名
- initializeBoolean：表示是否需要初始化；如果设为true，表示在加载以后，还会进入链接阶段
- classLoader：ClassLoader加载器

我们知道源文件在编译后，在运行时，分为三个阶段，加载，链接和初始化。这里的initializeBoolean就是定义是否进行链接和初始化。而Class.forName默认是设置的为true,所以利用Class.forName（）得到的类类型，除了加载进来以外，还进行了链接和初始化操作。
下面再来看看ClassLoader.loadClass()
```
public Class<?> loadClass(String className) throws ClassNotFoundException {
    return loadClass(className, false);
}
protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
    Class<?> clazz = findLoadedClass(className);

    if (clazz == null) {
        try {
            clazz = parent.loadClass(className, false);
        } catch (ClassNotFoundException e) {
            // Don't want to see this.
        }

        if (clazz == null) {
            clazz = findClass(className);
        }
    }

    return clazz;
}
```
`loadClass（String className）`最终是调用递规函数`loadClass(String className, boolean resolve)`来将类加载出来。
通过代码也可以看出来`ClassLoader的loadClass（String className）`只是将类加载出来，并没有链接与初始化的步骤。所以这就是它们的区别


> ####***基本类周边信息获取-总结 :***
```
//获取类类型对象的几种方式：
Person person = new Person();
Class a = person.getClass() //方法一：
Class b = Persion.class;//方法二：
Class c = Class.forName(String ClassName); //方法三：
Class d = context.getClassLoader().loadClass(String ClassName);//方法四：（不建议使用）

//获取包名类名
public String getName();//获取完整的类名（包含包名）
public String getSimpleName();//仅获取类名
public Package getPackage()//获取类类型所对应的package对象

//获取超类Class对象
public Class<?> getSuperclass();//获取普通函数的父类Class对象
public Type getGenericSuperclass();//针对泛型父类而设计（下篇讲解）

//获取接口Class对象
public Class<?>[] getInterfaces();//获取普通接口的方法
public Type[] getGenericInterfaces();//获取泛型接口的方法

//类访问修饰符
int modifiers = clazz.getModifiers();//获取类访问修饰符对应的int变量
String Modifier.toString(int modifiers) //根据整型变量来生成对应的修饰符字符串
boolean Modifier.isAbstract(int modifiers)//isXXX()系列函数用以检查特定的修饰符是否存在
```



