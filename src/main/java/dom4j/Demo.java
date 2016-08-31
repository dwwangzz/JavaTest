package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Demo
{

	// 读取xml文档第一个学生的<name>
	@Test
	public void read() throws Exception 
	{
		//创建一个解析器
		SAXReader reader = new SAXReader();
		//把xml文档解析成document
		Document document = reader.read(new File("src/student.xml"));
		//获取根节点的元素
		Element root = document.getRootElement(); 
		//获取根结点中的所有的第一个student元素
		Element student = (Element) root.elements("student").get(0);
		//获取studnt元素中的name的值
		String value = student.element("name").getText();
		//获取studnet元素中name标签的class属性的值
		String value1 = student.element("name").attributeValue("class");
		
		System.out.println("name=" + value + "\n" + "name的class属性是：" + value1);
	}

	// 在第第二个学生的信息添加一个<age>
	@Test
	public void add() throws Exception 
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/student.xml"));
		Element student = (Element) document.getRootElement().elements("student")
				.get(1);
		student.addElement("age").setText("19");

		// FilterWriter默认查GB2312码表 写数据
		// XMLWriter writer = new XMLWriter(new FileWriter("src.student.xml"));

		// 写完之后xml中的encoding属性就被改为UTF-8了
		// OutputStreamWriter流可以指定查哪个码表
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(
				new FileOutputStream("src/student.xml"), "UTF-8"));

		// 定义一个格式化输出器 *****格式化输出器的编码类型和xml文档的编码类型得相同
		/*
		 * OutputFormat format = OutputFormat.createPrettyPrint();
		 * format.setEncoding("utf-8"); XMLWriter writer = new XMLWriter(new
		 * OutputStreamWriter( new FileOutputStream("src/student.xml"),
		 * "UTF-8"), format);
		 */

		writer.write(document);
		writer.close();

	}

	// 在第第二个学生的信息的指定位置上添加一个<age>
	//原理就是更改保存了所有list集合的顺序
	@Test
	public void add2() throws Exception 
	{
		//创建一个解析器 用来解析xml文档
		SAXReader reader = new SAXReader();
		//解析xml文档
		Document document = reader.read(new File("src/student.xml"));
		
		Element student = document.getRootElement().element("student");
		List list = student.elements(); //student [code,name,langunge,age]
		
		//创建一个age元素并且返回
		Element age = DocumentHelper.createElement("age");
		//把age的值设置为27
		age.setText("27");
		//将age元素加在list集合的第三个位置上去
		list.add(2, age);
		
		//把document写在xml文档上
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(
				new FileOutputStream("src/student.xml"), "UTF-8"));
		writer.write(document);
		writer.close();
	}
	
	@Test
	public void delete() throws Exception
	{
		//创建一个解析器 用来解析xml文档
		SAXReader reader = new SAXReader();
		//解析xml文档
		Document document = reader.read(new File("src/student.xml"));
		
		Element age = document.getRootElement().element("student").element("age");
		//删除
		age.getParent().remove(age);
		
		//把document写在xml文档上
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(
				new FileOutputStream("src/student.xml"), "UTF-8"));
		writer.write(document);
		writer.close();
		
	}
	
	//修改第二个人的name值为"刁总"
	@Test
	public void update() throws Exception
	{
		//创建一个解析器 用来解析xml文档
		SAXReader reader = new SAXReader();
		//解析xml文档
		Document document = reader.read(new File("src/student.xml"));
		
		Element student = (Element) document.getRootElement().elements("student").get(1);
		student.element("name").setText("刁总");
		
		//把document写在xml文档上
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(
				new FileOutputStream("src/student.xml"), "UTF-8"));
		writer.write(document);
		writer.close();
		
	}
}


























