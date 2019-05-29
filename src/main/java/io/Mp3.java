package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 获得MP3文件的信息
 * Mp3 最后128字节存储信息格式：
 * 字节     长度 (字节)  说       明
 * 1-3     3       存放“TAG”字符，表示ID3 V1.0标准，紧接其后的是歌曲信息。
 * 4-33    30      歌名
 * 34-63   30      作者
 * 64-93   30      专辑名
 * 94-97   4       年份
 * 98-127  30      附注
 * 128     1       MP3音乐类别，共147种。
 * @author wangzz
 */
public class Mp3 {
    /**
     * 解析MP3信息时用的字符编码
     */
    private String charset = "utf-8";
    /**
     * MP3的标签信息的byte数组
     */
    private byte[] buf;

    /**
     * 构造函数
     * @param file
     */
    public Mp3(File file) {
        buf = new byte[128];//初始化标签信息的byte数组
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "r");//随机读写方式打开MP3文件
            raf.seek(raf.length() - 128);//移动到文件MP3末尾

            //读取标签信息
            raf.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (buf.length != 128) {//数据是否合法
            throw new RuntimeException("MP3标签信息数据长度不合法!");
        }
    }




    /**
     * 获得目前解析时用的字符编码
     * @return 目前解析时用的字符编码
     */
    public String getCharset() {
        return charset;
    }

    /**
     * 设置解析时用的字符编码
     * @param charset 解析时用的字符编码
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSongName() {
        try {
            return new String(buf, 3, 30, charset).trim();
        } catch (UnsupportedEncodingException e) {
            return new String(buf, 3, 30).trim();
        }
    }

    public String getArtist() {
        try {
            return new String(buf, 33, 30, charset).trim();
        } catch (UnsupportedEncodingException e) {
            return new String(buf, 33, 30).trim();
        }
    }

    public String getAlbum() {
        try {
            return new String(buf, 63, 30, charset).trim();
        } catch (UnsupportedEncodingException e) {
            return new String(buf, 63, 30).trim();
        }
    }

    public String getYear() {
        try {
            return new String(buf, 93, 4, charset).trim();
        } catch (UnsupportedEncodingException e) {
            return new String(buf, 93, 4).trim();
        }
    }

    public String getComment() {
        try {
            return new String(buf, 97, 28, charset).trim();
        } catch (UnsupportedEncodingException e) {
            return new String(buf, 97, 28).trim();
        }
    }


}
