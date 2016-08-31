package io;

import org.junit.Test;

import java.io.*;
import java.text.ParseException;

/**
 * IO练习
 * @author wangzz
 *
 */
@SuppressWarnings("resource")
public class FileIODemo {
	
	public static void main(String[] args) throws IOException, ParseException {
		System.out.println("\u62A5\u4EF7\u6587\u4EF6\u8DEF\u5F84");
	}

	/**
	 * 
	 * @throws IOException
	 */
	@Test
	public void fileWriter() throws IOException {
		File file = new File("fileWriter.txt");
		// 创建一个FileWriter对象，该对象一被初始化，必须要明确被错左的文件
		FileWriter fw = new FileWriter(file);
		fw.write("HelloFileWirter,");
		fw.flush();
		fw.close();
	}
	/**
	 * @author wangzz
	 * @see 把123.txt文件复制到abc.txt文件中去
	 * @throws IOException
	 */
	public static void bufferWriter() throws IOException{
		FileWriter fw = new FileWriter("abc.txt");
		BufferedWriter bufw = new BufferedWriter(fw);
		FileReader fr = new FileReader("123.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//1.读字符数组的方式来复制
		/*char[] ch = new char[1024];
		int num = 0;
		while((num=br.read(ch))!=-1)
		{
			bufw.write(ch,0,num);
		}
		bufw.flush();
		bufw.close();*/
		//2.每次读一行的方式来复制  这是BufferedReader特有的方法
		String line;
		while((line=br.readLine())!=null){
			//需要手动加换行
			//bufw.write(line+"\r\n");
			bufw.write(line);
			bufw.newLine();
		}
		bufw.flush();
		bufw.close();
		
	}

	
	/**
	 * 用字节流来复制文件
	 * @throws IOException
	 */
	public static void fileCopy() throws IOException
	{
		//创建一个文件用于存放读取的数据
		File file = new File("8-copy.jpg");
		//创建一个文件读取流对象，并与fileWriter.txt文件相关联
		FileOutputStream fos = new FileOutputStream(file);
		//创建一个文件输入流对象（用来存放读取的流） 注：此流对象必须在一初始化的时候就得有文件

		FileInputStream fis = new FileInputStream("8.jpg");
		
		//新建一个byte类型的数组
		byte[] b = new byte[1024];
		int len = 0;
		while((len=fis.read(b))!=-1)
		{
			fos.write(b,0,len);
		}
		fos.flush();
		fos.close();
	}
	
	
}
