package ZXing;

import ZXing.util.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.util.Hashtable;

/**
 * 生成二维码
 * @author wangzz-a
 * @version $Id: Encoder.java, v 0.1 2014年12月8日 下午1:33:53 wangzz-a Exp $
 */
public class Encoder {
	public static void main(String[] args) {
		long c = System.currentTimeMillis();
		String contents = "今天，我们来简单聊聊google开源项目——ZXing（二维条码编解码）";
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "GBK");
		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, 300, 300, hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		File file = new File("D://qrcodeImage.jpg");
		try {
			MatrixToImageWriter.writeToFile(matrix, "jpg", file);
			System.out.println("二维码已生成！\n用时："+(System.currentTimeMillis() - c) / 1000.0f+"s \n路径："+file.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
