package pdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Company {
	
	public static void main(String[] args) throws Exception{
		File file = new File("D:\\新疆分站供应商.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = null;
		int taskSize = 20;  
		int num = 0;
		// 创建一个线程池  
		//ExecutorService pool = Executors.newFixedThreadPool(taskSize); 
		ThreadPoolExecutor pool = new ThreadPoolExecutor(taskSize, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS , new LinkedBlockingQueue<Runnable>());
		pool.allowCoreThreadTimeOut(true);
		while(null != (str = br.readLine())){
			String[] companyInfo = str.split("	");
			pool.submit(new TGBG(companyInfo[0], companyInfo[1]));
			num++;
			//System.out.println(">>>>>>>>>>>:序号："+num+" 供应商id："+companyInfo[0]+" 供应商名称："+companyInfo[1]+" >>>完成！");
		}
		pool.shutdown();
		System.out.println(num);
	}

}
