package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcel2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		File file = new File("d:/积分测试500行.xlsx");
		
		@SuppressWarnings("resource")
		InputStream is = new FileInputStream(file);

	}

}
