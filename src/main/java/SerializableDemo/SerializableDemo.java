package SerializableDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/*
1、序列化是干什么的？
简单说就是为了保存在内存中的各种对象的状态（也就是实例变量，不是方法），并且可以把保存的对象状态再读出来。
虽然你可以用你自己的各种各样的方法来保存object states，但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化。

2、什么情况下需要序列化  
a）当你想把的内存中的对象状态保存到一个文件中或者数据库中时候；
b）当你想用套接字在网络上传送对象的时候；
c）当你想通过RMI传输对象的时候；

3、当对一个对象实现序列化时，究竟发生了什么？
在没有序列化前，每个保存在堆（Heap）中的对象都有相应的状态（state），即实例变量（instance ariable）比如：
当 通过下面的代码序列化之后，MyFoo对象中的width和Height实例变量的值（37，70）都被保存到foo.ser文件中，
这样以后又可以把它 从文件中读出来，重新在堆中创建原来的对象。当然保存时候不仅仅是保存对象的实例变量的值，JVM还要保存一些小量信息，比如类的类型等以便恢复原来的对 象。

4、实现序列化（保存到一个文件）的步骤
a）Make a FileOutputStream  
FileOutputStream fs = new FileOutputStream("foo.ser");     
b）Make a ObjectOutputStream  
ObjectOutputStream os =  new ObjectOutputStream(fs);  
c）write the object
os.writeObject(myObject1);  
os.writeObject(myObject2);  
os.writeObject(myObject3);  
*/
public class SerializableDemo {

	public static void main(String[] args) throws IOException {

		Foo myFoo = new Foo();
		myFoo.setWidth(35);
		myFoo.setHeight(70);

		FileOutputStream fs = new FileOutputStream("D:/foo.ser");
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(myFoo);
		os.close();
		System.out.println("success");

	}

}
