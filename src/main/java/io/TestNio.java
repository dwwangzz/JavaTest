package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java大文件读取
 * @author wangzz-a
 * @version $Id: TestNio.java, v 0.1 2015年7月7日 上午10:57:09 wangzz-a Exp $
 */
public class TestNio {

	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception {
		
		int bufSize = 100;
		File fin = new File("D:\\15.log");
		File fout = new File("D:\\15_1.log");

		FileChannel fcin = new RandomAccessFile(fin, "r").getChannel();
		ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);

		FileChannel fcout = new RandomAccessFile(fout, "rws").getChannel();
		ByteBuffer wBuffer = ByteBuffer.allocateDirect(bufSize);

		readFileByLine(bufSize, fcin, rBuffer, fcout, wBuffer);

		System.out.print("OK!!!");
	}

	/* 读文件同时写文件 */
	@SuppressWarnings("unused")
	public static void readFileByLine(int bufSize, FileChannel fcin, ByteBuffer rBuffer, FileChannel fcout,
			ByteBuffer wBuffer) {
		String enterStr = "\n";
		try {
			byte[] bs = new byte[bufSize];

			int size = 0;
			StringBuffer strBuf = new StringBuffer("");
			// while((size = fcin.read(buffer)) != -1){
			while (fcin.read(rBuffer) != -1) {
				int rSize = rBuffer.position();
				rBuffer.rewind();
				rBuffer.get(bs);
				rBuffer.clear();
				String tempString = new String(bs, 0, rSize);
				// System.out.print(tempString);
				// System.out.print("<200>");

				int fromIndex = 0;
				int endIndex = 0;
				while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {
					String line = tempString.substring(fromIndex, endIndex);
					line = new String(strBuf.toString() + line);
					// System.out.print(line);
					// System.out.print("</over/>");
					// write to anthone file
					writeFileByLine(fcout, wBuffer, line);

					strBuf.delete(0, strBuf.length());
					fromIndex = endIndex + 1;
				}
				if (rSize > tempString.length()) {
					strBuf.append(tempString.substring(fromIndex, tempString.length()));
				} else {
					strBuf.append(tempString.substring(fromIndex, rSize));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* 写文件 */
	@SuppressWarnings("static-access")
	public static void writeFileByLine(FileChannel fcout, ByteBuffer wBuffer, String line) {
		try {
			// write on file head
			// fcout.write(wBuffer.wrap(line.getBytes()));
			// wirte append file on foot
			fcout.write(wBuffer.wrap(line.getBytes()), fcout.size());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
