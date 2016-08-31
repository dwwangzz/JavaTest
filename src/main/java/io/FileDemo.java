package io;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo 
{
	/**
	 * @author wangzz
	 * File类的构造函数和字段
	 *
	 */
	@Test
	public void consMethod(){
		//将a.txt封装成file对象，可以将已有的和未出现的文件或者文件夹封装成对象。
		//File f1 = new File("c:\\abc\\a.txt");//绝对路径
		File f1 = new File("a.txt");//相对路径
		
		//在c:\\abc目录下创建b.txt文件
		File f2 = new File("c:\\abc","b.txt");
		
		//先创建一个c:\abc文件夹目录对象d，在d中创建c.txt
		File d = new File("c:\\abc");
		File f3 = new File(d,"c.txt");
		
		//File.separator为跨平台目录分隔符，在window中相当于c:\\abc\\d.txt
		File f4 = new File("c:"+File.separator+"abc"+File.separator+"d.txt");
		
		System.out.println("f1="+f1);
		System.out.println("f2="+f2);
		System.out.println("f3="+f3);
		System.out.println("f4="+f4);

	}
	
	
	/**
	 * File类常见的方法：
	 * 1.创建
	 * 	boolean createNewFile():在指定位置创建文件，如果该文件已经存在，则不创建，返回false。如果不存在就会创建文件并返回true。
	 * 							和输出流不一样，输出流对象一建立就会创建文件。如果文件存在，会覆盖。
	 * 	boolean mkdir(): 创建文件夹，如果文件夹存在返回false 注：mkdir()只能创建一级目录
	 * 	boolean mkdirs(): 创建多级文件夹,如果文件夹存在返回false
	 * 
	 * 2.删除
	 * 	boolean delete():删除失败返回false（不能删除正在执行的文件）
	 * 	void deleteOnExit():在程序退出时删除指定文件。
	 * 
	 * 3.判断
	 * 	boolean exists(): 文件是否存在。
	 * 	boolean canExecute(): 文件是否能被执行。
	 *  boolean isHidden(): 此路径名表示的文件是否是一个隐藏文件
	 *  注意：java在取文件的时候不管是不是隐藏都获取，但是有一些系统的文件会获取失败，所以我们获取文件的时候先判断一下文件是否隐藏(我们只获取非隐藏的文件)
	 *  boolean isDirectory(): 此路径名表示的文件是否是一个路径(目录)
	 *  boolean isFile(): 此路径名表示的文件是否是一个文件
	 *  注意：判断文件是否是文件或者目录的时候，必须要先判断该文件对象封装的内容是否存在.通过exists()判断。
	 *  boolean isAbsolute(): 是不是绝对路径d:\\1.txt是绝对的(返回true)，1.txt是相对的(返回false)
	 *  
	 * 4.获取信息
	 * 	String getName(): 
	 *  long length():
	 *  long lastModified():返回此抽象路径名表示的文件最后一次被修改的时间
	 *  String getPath():获得相对路径，如果创建的文件就是用绝对路径创建的话也会获得绝对路径。如：new File("d:\\1.txt").getPath()会返回d:\\1.txt
	 * 	String getAbsolutePath():返回此文件对象的绝对
	 * 	File getAbsoluteFile():返回此文件
	 * 	注意：字符串和文件对象之间是可以相互转换的
	 * 	如：new File(file.getAbsolutePath())===file.getAbsoluteFile();
	 * 	   file.getAbsoluteFile().toString()===file.getAbsolutePath();
	 * 	String getParent():该方法返回的是绝对路径中的父目录，
	 * 					如果new File("1.txt")使用的是相对路径的话，该方法返回空
	 * 					如果new File("abc\\1.txt")，返回abc
	 * 
	 * 
	 * 5.重命名文件(可以利用此方法实现文件的移动)
	 * 	boolean renameTo(File disc) 
	 *  注:1).被重命名的文件会消失，是保存重命名之后的文件，我们可以用这个方法来实现文件的移动
	 *    2).被重命名之后的文件即使之前创建的文件使用了f.deleteOnExit()也不会被删除(也就是我们原来创建的文件f(1.txt),重命名为f2(2.txt)，2.txt不会因为f.deleteOnExit()而被删除)
	 *  例：把c:\\1.txt重命名为2.txt
	 *  	file.renameTo("c:\\2.txt");
	 *  
	 */
	@Test
	public void method_1() throws IOException{
		//创建文件对象
		//注：对象创建完毕之后，本地路径中文件还不存在
		//File f = new File("d:\\fileDemo.txt");
		//File f = new File("abc\\fileDemo.txt");//这么创建文件，如果abc目录不存在的话就会报错
		File f = new File("fileDemo.txt");
		
		//1.创建
		//在本地磁盘上创建文件
		System.out.println("createFile:"+f.createNewFile());
		//创建文件夹
		//File path = new File("D:\\abc\\kkk");
		//System.out.println("createPath:"+path.mkdirs());
		
		f.getAbsoluteFile().toString();
		//2.删除
		//System.out.println("create:"+f.delete());
		//虚拟机执行完程序之后删除文件，无论发声不发生异常，deleteOnExit()最好直接放在创建文件之后(File f = new File("")后面)
		f.deleteOnExit();
		
		//3.判断
		System.out.println("exists:"+f.exists());
		if(f.exists()){
			System.out.println("isFile="+f.isFile());
			System.out.println("isDirectory="+f.isDirectory());
		}
		
		//4.获取信息
		System.out.println("=============================================");
		System.out.println("getName="+f.getName());
		System.out.println("getPath="+f.getPath());
		System.out.println("length="+f.length());
		System.out.println("lastModified="+f.lastModified());
		System.out.println("getCanonicalPath="+f.getCanonicalPath());
		System.out.println("getAbsoluteFile="+f.getAbsoluteFile());
		System.out.println("getParent="+f.getParent());
		System.out.println("getParentFile="+f.getParentFile());
		
		//5.文件的重命名 
		//File f2 = new File("rename.txt");
		//System.out.println("renameTo="+f.renameTo(f2));
		
	}
	
	/**
	 * 
	 * 	1.File[] listRoots():列出电脑中有效的盘符
	 * 
	 *	2.String[] list(): 列出指定目录下文件或者文件夹的名称(所有的文件，包括隐藏文件)
	 *		注：调用list()的File对象必须是封装了一个目录。该目录必须存在
	 *	3.String[] list(FilenameFilter filter): 文件名的过滤
	 *
	 *	4.File[] listFiles():返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
	 *	5.File[] listFiles(FileNameFilter filter):返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
	 *	6.
	 */
	@Test
	public void method_2 ()throws IOException
	{
		//1.listRoots列出电脑中有效的盘符
		File[] files = File.listRoots();
		for(File ff : files)
		{
			System.out.println(ff);
		}
		System.out.println("=====================================分行");
		
		
		//2.list()列出文件夹下所有的文件和文件夹的名称
		File file = new File("D:\\DTD");
		String[] arr = file.list();
		for(String name : arr){
			System.out.println(name);
		}
		System.out.println("=====================================分行");
		
		//3.list(FilenameFilter filter) 文件名的过滤
		File dir = new File("D:\\DTD");
		String[] arr2 = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				//System.out.println("dir="+dir+" name="+name);
				//dir是需要过滤的文件夹，name是需要过滤的文件，我们对需要过滤的文件进行判断，
				//当返回false的时候就过滤，true的时候就不过滤
				/*if(name.endsWith(".xsd")){
					return true;
				}else{
					return false;
				}*/
				return name.endsWith(".xsd")||name.endsWith(".rar");//我只要后缀名为.xsd和.rar的文件其他的都给过滤掉
			}
		});
		
		for(String name : arr2){
			System.out.println(name);
		}
	}
	
	
}





















