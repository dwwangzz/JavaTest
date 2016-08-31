package img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class CmykToRgb
{ 
 
    /** 
     * Creates new RGB images from all the CMYK images passed 
     * in on the command line. 
     * The new filename generated is, for example "GIF_original_filename.gif". 
     * @throws IOException 
     * 
     */ 
    public static void main(String[] args) throws IOException 
    { 
          String filename = "D:\\3.jpg";
          
          Image image = Toolkit.getDefaultToolkit().getImage(filename); 
          
          File src = new File(filename);  
          BufferedImage bi = (BufferedImage)ImageIO.read(src);  
          BufferedImage bi_scale = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB );  
          Graphics2D g = bi_scale.createGraphics();  
          g.drawImage( bi, 0, 0, bi.getWidth(), bi.getHeight(), null );  
          g.dispose();  
          FileOutputStream fos = new FileOutputStream("d:/3-c.jpg");  
          ImageIO.write(bi_scale, "jpg", fos);  
          fos.close();
          
           /* boolean cmyk = isCMYK(filename); 
            System.out.println(cmyk + ": " + filename); 
            if (cmyk) 
            { 
                try 
                { 
                    String rgbFile = cmyk2rgb(filename); 
                    System.out.println(isCMYK(rgbFile) + ": " + rgbFile); 
                } 
                catch (IOException e) 
                { 
                    System.out.println(e.getMessage()); 
                } 
            } */
        
    } 
 
    /** 
     * If 'filename' is a CMYK file, then convert the image into RGB, 
     * store it into a JPEG file, and return the new filename. 
     * 
     * @param filename 
     */ 
    @SuppressWarnings("unused")
	private static String cmyk2rgb(String filename) throws IOException 
    { 
        // Change this format into any ImageIO supported format. 
        String format = "jpg"; 
        File imageFile = new File(filename); 
        String rgbFilename = filename; 
        BufferedImage image = ImageIO.read(imageFile); 
        if (image != null) 
        { 
            int colorSpaceType = image.getColorModel().getColorSpace().getType(); 
            if (colorSpaceType == ColorSpace.TYPE_CMYK) 
            { 
                BufferedImage rgbImage = 
                    new BufferedImage( 
                        image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR); 
                ColorConvertOp op = new ColorConvertOp(null); 
                op.filter(image, rgbImage); 
 
                rgbFilename = changeExtension(imageFile.getName(), format); 
                //rgbFilename = new File(imageFile.getParent(), format + "_" + rgbFilename).getPath(); 
                rgbFilename = new File(imageFile.getParent(), format + "_" + rgbFilename).getPath(); 
                ImageIO.write(rgbImage, format, new File(rgbFilename)); 
            } 
        } 
        return rgbFilename; 
    } 
 
    /** 
     * Change the extension of 'filename' to 'newExtension'. 
     * 
     * @param filename 
     * @param newExtension 
     * @return filename with new extension 
     */ 
    private static String changeExtension(String filename, String newExtension) 
    { 
        String result = filename; 
        if (filename != null && newExtension != null && newExtension.length() != 0); 
        { 
            int dot = filename.lastIndexOf('.'); 
            if (dot != -1) 
            { 
                result = filename.substring(0, dot) + '.' + newExtension; 
            } 
        } 
        return result; 
    } 
 
    private static boolean isCMYK(String filename) 
    { 
        boolean result = false; 
        BufferedImage img = null; 
        Image image = null;
        try 
        { 
        	File file = new File(filename);
            //img = ImageIO.read(file); 
            image = Toolkit.getDefaultToolkit().getImage(filename);  
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage() + ": " + filename); 
        }
        if (img != null) 
        { 
            int colorSpaceType = img.getColorModel().getColorSpace().getType(); 
            result = colorSpaceType == ColorSpace.TYPE_CMYK; 
        } 
        return result; 
    } 
} 