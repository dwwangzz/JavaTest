package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseXml<T> {
	
	private Class<T> entity ;
	private static ParseXml parseXml = null;
	
	/**
	 * 构造函数
	 * */
	public ParseXml(Class<T> type){
		entity = type;
	}
	
//	/**
//	 * 得到ParseXml的一个对象
//	 * @return 该类的一个实例
//	 * */
//	public ParseXml getInstance(Class<T> type){
//		entity = type;
//		if(parseXml == null){
//			parseXml = new ParseXml();
//		}
//		return parseXml;
//	}
	
	/**
	 * 读取XML文档
	 * @param xmlPath xml物理路径
	 * @return XML文档
	 * */
	public Document ReadXml(String xmlPath){
		Document doc = null;
		SAXReader reader = new SAXReader();
		
		try {
			doc = reader.read(new File(xmlPath));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return doc;
	}
	
	/**
	 * 读取XML文档所有元素
	 * @param doc XML文档
	 * @return 以对象的形式返回XML文档所有元素
	 * */
	public List<T> getElements(Document doc){
		List<T> result = new ArrayList<T>();
		
		Element root = doc.getRootElement();//根节点
		Iterator iter = root.elementIterator();//获取根节点下的子节点,即实体的列表
		while(iter.hasNext()){
			Element element = (Element)iter.next();//一个实体
			List<Node> nodes = element.elements();//实体的所有属性
			Iterator nodesIter = nodes.iterator();
			
			T obj = null ;
			try {
				obj = entity.newInstance();//生成模板类的对象
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			while(nodesIter.hasNext()){
				Element node = (Element)nodesIter.next();//一个属性
				String name = node.getName();//属性名称
				String content = node.getText();//属性内容
				//构建set方法名
				String methodname="set"  + Character.toUpperCase(name.charAt(0)) + name.substring(1);
				try {
					//获取模板类中的set方法
					Method method = entity.getDeclaredMethod(methodname, String.class);
					//取消 Java检查访问权限,提高反射速度
					method.setAccessible(true);
					try {
						//调用模板类对象的该方法
						method.invoke(obj, content);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			result.add(obj);
		}
		return result;
	}
	
	public static void main(String[] args){
		/*ParseXml parseXml = new ParseXml(Student.class);
		Document doc = parseXml.ReadXml("C:/person.xml");
		List<Student> students = parseXml.getElements(doc);
		for(int i = 0; i < students.size();i++){
			System.out.println(students.get(i).getLanguage());
		}*/
	}

}
