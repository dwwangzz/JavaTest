package string;



/**
 * 此文本文件的编码格式是GBK
 * @author wangzz-a
 * @version $Id: StringGBK.java, v 0.1 2015年11月10日 下午4:51:14 wangzz-a Exp $
 */
public class StringGBK {

	public static void main(String[] args) throws Exception {
		
		String str = "中国";
		
		byte[] b = str.getBytes();
		printArr(b);
		
		//utf-8的“中国”的字节码：[-28, -72, -83, -27, -101, -67]
		//GBK的“中国”的字节码：[-42, -48, -71, -6]
		
		byte[] z = {-42,-48};
		System.out.println(new String(z,"gbk"));
		
		byte[] z2 = {-28, -72, -83};
		System.out.println(new String(z2,"utf-8"));
		
		
		System.out.println("++++++++++++++++++++++++++");
		test();
		System.out.println("++++++++++++++++++++++++++");
		
	}
	
	/**
	 * 编码解码详解 by子正
	 * 
	 * 1.本文本(本java文件)是GBK编码格式的。
	 * 2.无论用哪种编码格式，编码"中国"这个字符串，只要按照编码的这个编码格式再解码，就不会出现乱码
	 * 如：str.getBytes("gbk"); //[-42, -48, -71, -6]
	 * 	 str.getBytes("utf-8"); //[-28, -72, -83, -27, -101, -67]
	 * 	 str.getBytes("iso8859-1");//[63, 63]
	 * 下面我们看这个例子：
	 * 	"中国"这个字符串用gbk编码为[-42, -48, -71, -6]
	 * 	"中国"这个字符串用utf-8编码为[-28, -72, -83, -27, -101, -67]
	 * 	"中国"这个字符串用iso8859-1编码为[63, 63] --> ??
	 * 	
	 * */
	public static void test() throws Exception{
		
		String str = "中国";
		
		//获取中国的GBK编码表的字节码
		//byte[] bb = {-42, -48, -71, -6};
		byte[] bb = str.getBytes("gbk");
		
		//使用iso8859-1重新解码 //出现乱码--> ???ú
		str = new String(bb,"iso8859-1");
		System.out.println(str);//???ú
		
		//下面我们获取此乱码的iso8859-1的字节码  
		//发现：第一个str.getBytes("iso8859-1")可以获取到正确的GBK编码
		//	      第二个"???ú".getBytes("iso8859-1")获取到的是错误GBK的编码
		printArr(str.getBytes("iso8859-1"));
		printArr("???ú".getBytes("iso8859-1"));
		
		str = new String(str.getBytes("iso8859-1"),"gbk");
		System.out.println(str);
		
		//打印"中国"gbk编码的字节码
		//printArr(str.getBytes("gbk"));//[-42, -48, -71, -6]
	}
	
	public static void printArr(byte[] bytes){

		if(bytes==null||bytes.length==0)
			return ;
		System.out.print("[");
		for (int i = 0; i < bytes.length; i++) {
			if(i+1==bytes.length){
				System.out.print(bytes[i]);
			}else{
				System.out.print(bytes[i]+", ");
			}
		}
		System.out.println("]");
	}
}
