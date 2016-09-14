此包中为泛型相关方法
=====================

### 1. 概述
在引入范型之前，Java类型分为原始类型、复杂类型，其中复杂类型分为数组和类。引入范型后，一个复杂类型
就可以在细分成更多的类型。
例如原先的类型List，现在在细分成`List<Object>, List<String>`等更多的类型。
注意，现在`List<Object>, List<String>`是两种不同的类型，
他们之间没有继承关系，即使String继承了Object。下面的代码是非法的
```
List<String> ls = new ArrayList<String>();
List<Object> lo = ls;
```
这样设计的原因在于，根据lo的声明，编译器允许你向lo中添加任意对象（例如Integer），但是此对象是
List<String>，破坏了数据类型的完整性。
在引入范型之前，要在类中的方法支持多个数据类型，就需要对方法进行重载，在引入范型后，可以解决此问题
（多态），更进一步可以定义多个参数以及返回值之间的关系。
例如

```
public void write(Integer i, Integer[] ia);
public void write(Double  d, Double[] da);
//范型版本为
public <T> void write(T t, T[] ta);
```
