package string;


/**
 * 本文本文件使用utf-8编码的
 * @author wangzz-a
 * @version $Id: StringTest.java, v 0.1 2015年11月10日 下午2:20:57 wangzz-a Exp $
 */
public class StringTest {

	public static void main(String[] args) throws Exception {

		String str = "中国";
		String str2 = "涓浗";
		String str3 = "�й�";
		
		//printArr(str.getBytes("gbk"));//[-42, -48, -71, -6]
		//printArr(str.getBytes("utf-8"));//[-28, -72, -83, -27, -101, -67]
		str = new String(str.getBytes("gbk"),"gbk");
		System.out.println(str);
		printArr(str.getBytes("utf-8"));//[-17, -65, -67, -48, -71, -17, -65, -67]
		System.out.println(new String(str.getBytes("utf-8")));	
		
		//=========================查看默认的解码格式=========================
		//注：默认的编码格式和此java文件使用的编码格式相同
		str = "中国";
		str = new String(str.getBytes(),"utf-8");
		System.out.println("查看默认的解码格式（utf-8）-1："+str);
		byte[] b = str.getBytes();
		System.out.print("中国的（utf-8）字节码：");
		printArr(b);
		
		str = "中国";
		str = new String(str.getBytes(),"gbk");
		System.out.println("查看默认的解码格式（gbk）-2："+str);
		
		str = "中国";
		str = new String(str.getBytes(),"gb2312");
		System.out.println("查看默认的解码格式（gb2312）-3："+str);
		
		str = "中国";
		str = new String(str.getBytes(),"ISO-8859-1");
		System.out.println("查看默认的解码格式（ISO-8859-1）-4："+str);
		
		str = "中国";
		str = new String(str.getBytes(),"ISO8859-1");
		System.out.println("查看默认的解码格式（ISO8859-1）-5："+str);
		
		str = "中国";
		str = new String(str.getBytes(),"iso8859-1");
		System.out.println("查看默认的解码格式（iso8859-1）-6："+str);
		//=========================查看默认的解码格式=========================
		
		
		
		//=========================查看默认的编码格式=========================
		String bianma = "中国";
		bianma = new String(bianma.getBytes("gbk"));
		System.out.println("查看默认的编码格式（gbk）-1："+bianma);	
		
		bianma = "中国";
		bianma = new String(bianma.getBytes("gb2312"));
		System.out.println("查看默认的编码格式（gb2312）-2："+bianma);
		
		bianma = "中国";
		bianma = new String(bianma.getBytes("utf-8"));
		System.out.println("查看默认的编码格式（utf-8）-3："+bianma);
		
		bianma = "中国";
		bianma = new String(bianma.getBytes("iso8859-1"));
		System.out.println("查看默认的编码格式（iso8859-1）-4："+bianma);
		
		//用默认的解码，再用默认的编码
		bianma = "中国";
		bianma = new String(bianma.getBytes());
		System.out.println("用默认的解码，再用默认的编码："+bianma);
		//=========================查看默认的编码格式=========================
		
		
		

		//=========================手动编码解码=========================
		//先gbk解码，再用utf-8编码
		str2 = new String(str2.getBytes("gbk"),"utf-8");
		System.out.println("先gbk解码，再用utf-8编码-1："+str2);
		
		//先gb2312解码，再用utf-8编码
		str3 = new String(str3.getBytes("gb2312"),"utf-8");
		System.out.println("先gb2312解码，再用utf-8编码-2："+str3);
		//=========================手动编码解码=========================
		
		
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
