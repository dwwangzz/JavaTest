package ZXing;

import ZXing.util.BufferedImageLuminanceSource;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * 解码工具类
 * @author wangzz-a
 * @version $Id: Decoder.java, v 0.1 2014年12月8日 下午1:39:13 wangzz-a Exp $
 */
public class Decoder {
	public static void main(String[] args) {

		File file = new File("D://1.jpg");
		System.out.println(file.length());
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
		hints.put(DecodeHintType.CHARACTER_SET, "GBK");
		Result result = null;
		try {
			result = new MultiFormatReader().decode(bitmap, hints);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());
	}
}
