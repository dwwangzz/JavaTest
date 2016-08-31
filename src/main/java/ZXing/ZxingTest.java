package ZXing;

import ZXing.util.BufferedImageLuminanceSource;
import ZXing.util.MatrixToImageWriter;
import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 编码解码工具类
 * @author wangzz-a
 * @version $Id: ZxingTest.java, v 0.1 2014年12月8日 下午1:40:30 wangzz-a Exp $
 */
public class ZxingTest {
    public static void main(String[] args) throws Exception{  
        //File logo = new File("D:/1.jpg");
    	/* String content = "http://172.16.231.50:8080/wShop/loginInit";
        QRCodeUtil.encode(content, "d:/2--.jpg");*/
        String content = "别人笑我太疯癫，我笑他人看不穿。不见五陵豪杰墓，无花无酒锄做田。";
        //QRCodeUtil.encode(content, "d:/baby.jpg", "d:/微店铺首页.jpg", true);
        QRCodeUtil.encode(content,"d:/1.jpg");
        System.out.println("success!");
        
    }

    /**
     * 
     * @author wangzz-a
     * @throws UnsupportedEncodingException
     * @date 2014年12月8日 下午2:10:37
     */
	@SuppressWarnings("unused")
	public  static void test1() throws UnsupportedEncodingException {
		String content = "http://172.16.231.71:8080";  
        content = new String(content.getBytes("GBK"),"iso-8859-1");  
        String imagePath = "D://code.png";  
        File file = new File(imagePath);  
          
        QRCodeWriter writer = new QRCodeWriter();  
        try {  
            //生成二维码  
            BitMatrix matrix = writer.encode(content, BarcodeFormat.QR_CODE,200, 200);  
            MatrixToImageWriter.writeToFile(matrix, "png", file);
            //读取二维码  
            QRCodeReader reader = new QRCodeReader();  
            BufferedImage image = ImageIO.read(file);  
            LuminanceSource source = new BufferedImageLuminanceSource(image );
            Binarizer binarizer = new HybridBinarizer(source );  
            BinaryBitmap imageBinaryBitmap = new BinaryBitmap(binarizer  );  
            Result result = reader.decode(imageBinaryBitmap);  
            System.out.println("result = "+ result.toString());  
            System.out.println("resultFormat = "+ result.getBarcodeFormat());  
            System.out.println("resultText = "+ result.getText());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	} 
}
