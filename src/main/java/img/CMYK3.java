package img;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CMYK3 {
	public static void main(String[] args) throws IOException{
        Image img = Toolkit.getDefaultToolkit().getImage("d:\\2.jpg");
        BufferedImage bi_scale = toBufferedImage(img);
        
        ImageIO.write(bi_scale, "jpg",new File("d:\\22.jpg"));
    }
     
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
         }
         image = new ImageIcon(image).getImage();
         
         BufferedImage bimage = null;
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
           /* if (hasAlpha) {
                 transparency = Transparency.BITMASK;
             }*/
     
            // Create the buffered image
             GraphicsDevice gs = ge.getDefaultScreenDevice();
             GraphicsConfiguration gc = gs.getDefaultConfiguration();
             bimage = gc.createCompatibleImage(
                 image.getWidth(null), image.getHeight(null), transparency);
         } catch (HeadlessException e) {
            // The system does not have a screen
         }
     
        if (bimage == null) {
            int type = BufferedImage.TYPE_INT_RGB;
             bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
         }
         Graphics g = bimage.createGraphics();
         g.drawImage(image, 0, 0, null);
         g.dispose();
        return bimage;
     }
}
