/**
 * glodon.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 * img
 */
package img;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 缩略图工具类
 * 
 * @author wangzz-a
 * @version $Id: ThumbUtils.java, v 0.1 2014年11月4日 上午10:11:58 wangzz-a Exp $
 */
public class ThumbUtils {

	public static void main(String[] args) throws Exception {

		long c = System.currentTimeMillis();
		// 1、指定大小进行缩放
		// 等比例压缩
		// Thumbnails.of("D:/1.jpg").size(150, 150).toFile("D:/1-c.jpg");
		// 不等比例
		// Thumbnails.of(oldfile).size(300,
		// 300).keepAspectRatio(false).toFile("D:/8-c.gif");

		// 2、按照比例进行缩放
		// Thumbnails.of(oldfile).scale(2.0f).toFile(newFile);

		// 3.生成缩略图手再裁剪为150*150
		imgThumb(150, 150, "jpg", "D:/1.jpg", "D:/1-c.jpg");

		System.out.println("elapse time:" + (System.currentTimeMillis() - c) / 1000.0f + "s");
	}

	public static void imgThumb(int width, int height, String type, String relativePath, String thumbnailsPath)
			throws Exception {

		BufferedImage image = ImageIO.read(new File(relativePath));

		Thumbnails.Builder<BufferedImage> builder = null;

		int imageWidth = image.getWidth();
		int imageHeitht = image.getHeight();
		if ((float) height / width != (float) imageWidth / imageHeitht) {
			if (imageWidth > imageHeitht) {
				image = Thumbnails.of(relativePath).height(height).asBufferedImage();
			} else {
				image = Thumbnails.of(relativePath).width(width).asBufferedImage();
			}
			builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height);
		} else {
			builder = Thumbnails.of(image).size(width, height);
			image.flush();
		}
		builder.outputFormat(type).toFile(thumbnailsPath);
	}

}
