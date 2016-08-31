package img;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.IOException;

public class CMYKTest {
	
	ICC_Profile ICC_pf;
	ICC_ColorSpace ICC_CLSpace;
	//以下变量存储CMYK颜色值，取值为0到100
	int C = 9;
	int M = 9;
	int Y = 9;
	int K = 9;
	
	public static void main(String[] args) throws IOException {
		
		
//		ICC_Profile ICC_pf = ICC_Profile.getInstance(fileName);
//		ICC_ColorSpace ICC_CLSpace = new ICC_ColorSpace(ICC_pf);

	}
	
	//初始化ICC_Profile和ICC_ColorSpace类对象
	public CMYKTest(){
		String fileName = "d:/2.jpg";
		
	}
	public void GetlCCFrompfFile(String fileName){
		try {
			ICC_pf = ICC_Profile.getInstance(fileName);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "can't create ICC_Profile");
		}
		ICC_CLSpace = new ICC_ColorSpace(ICC_pf);
	}
	//由RGB色彩空间转变到CMYK
	float[] RGBtoCMYK(Color RGBColor){
		float[] CMYKfloat = ICC_CLSpace.fromRGB(RGBColor.getRGBComponents(null));
		C = (int)(CMYKfloat[0]*100);
		M = (int)(CMYKfloat[1]*100);
		Y = (int)(CMYKfloat[2]*100);
		K = (int)(CMYKfloat[3]*100);
		return CMYKfloat;
	}
	//由CMYK色彩空间转变到RGB
	Color RGBtoCMYK(float[] CMYKfloat){
		Color RGBColor = new Color(ICC_CLSpace,CMYKfloat,1.0f);
		return RGBColor;
	}
	Color CMYKtoRGB(){
		float[] CMYKfloat = new float[4];
		CMYKfloat[0] = 0.01f*(float)C;
		CMYKfloat[1] = 0.01f*(float)M;
		CMYKfloat[2] = 0.01f*(float)Y;
		CMYKfloat[3] = 0.01f*(float)K;
		Color RGBColor = new Color(ICC_CLSpace,CMYKfloat,1.0f);
		return RGBColor;
	}

}
