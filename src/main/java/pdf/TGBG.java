package pdf;

import java.io.*;
import java.util.concurrent.Callable;

public class TGBG implements Callable<Object> {
	
	private String companyId;
	private String companyName;
	
	public TGBG(String companyId, String companyName) {
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public Object call() throws Exception {
		try {
		String wkPath = "D:\\Program Files\\wkhtmltopdf\\bin\\wkhtmltopdf.exe";
		String url = "http://work.gldjc.com/exportPopularizeReportIndex?companyId=" + companyId;
		String exportPath = "D:\\宁夏分站导出文件\\";
		createFloder(exportPath);
		exportPath = exportPath + "\\" + companyName + ".pdf";
		File file = new File(exportPath);
		if(file.exists()) {
			return null;
		}
		String cmd = wkPath + " " + url + " " + exportPath;
		Process pro;
		try {
			pro = Runtime.getRuntime().exec(cmd);
			InputStream in = pro.getInputStream();
	        BufferedReader read = new BufferedReader(new InputStreamReader(in));
	        String line = null;
	        while((line = read.readLine())!=null){
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}  
		Thread.sleep(2000);
		
		} catch (Exception e) {
		}
		return null;
	}
	
	private void createFloder(String exportPath) {
		File file = new File(exportPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
}
