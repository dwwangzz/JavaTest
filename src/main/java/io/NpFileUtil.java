package io;

import org.apache.commons.io.IOUtils;
import org.springframework.util.Assert;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * NP可以使用
 */
public class NpFileUtil {

    public static final String DEFAULT_WINDOWS_PATH = "D:/wangzz/download/";
    public static final String DEFAULT_LINUX_PATH = "/opt/wangzz/download/";

    public static void main(String[] args) throws Exception {
        readFile("D:/usercode.txt", System.out);
    }

    /**
     * 将字符串保存为文件
     * @param filePath
     * @param content
     * @author wangzz
     * @date 2015年5月20日 下午1:48:18
     */
    public static void saveFile(String filePath, String content) {
        File file = new File(filePath);
        FileWriter fw = null;
        //这里没有使用BufferWrite，是因为数据是一次性写入
        //BufferWrite的优势在于调用write方法时，使用缓冲区
        //而FileWriter每次调用write方法，都调用StreamEncoder的write方法
        try {
            fw = new FileWriter(file);//缓冲区1024字符
            fw.write(content);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fw);
        }
    }

    /**
     * 读取文本文件
     * @param path 文本文件路径
     * @return 文本文件内容
     * @throws IOException
     * @author wangzz
     * @date 2015年12月4日 下午4:04:22
     */
    public static String readFile(String path) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("The path must not be null");
        }
        String result = "";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            readFile(path, bos);
            result = bos.toString();
        } finally {
            IOUtils.closeQuietly(bos);
        }
        return result;
    }


    /**
     * 读取文件到字符输出流
     * 可用于response.getWriter()输出内容
     * 方法内不关闭字符输出流
     * @param path   文件路径
     * @param output 字符输出流
     * @throws IOException 读取失败，发生IO异常
     * @author wangzz
     * @date 2015年11月26日 下午8:11:54
     */
    public static void readFile(String path, Writer output) throws IOException {
        if (path == null || output == null) {
            throw new IllegalArgumentException("The path or output must not be null");
        }
        FileReader intput = null;
        try {
            intput = new FileReader(new File(path));
            IOUtils.copy(intput, output);
        } finally {
            IOUtils.closeQuietly(intput);
        }

    }

    /**
     * 读取文件到字节输出流<br/>
     * 可用于response.getOutPutStream()提供文件下载<br/>
     * 方法内不关闭字节输出流<br/>
     * @param path   文件路径
     * @param output 字符输出流
     * @throws IOException 读取失败，发生IO异常
     * @author wangzz
     * @date 2015年11月26日 下午8:11:52
     */
    public static void readFile(String path, OutputStream output) throws IOException {
        if (path == null || output == null) {
            throw new IllegalArgumentException("The path or output must not be null");
        }
        FileInputStream intput = null;
        try {
            intput = new FileInputStream(new File(path));
            IOUtils.copy(intput, output);
        } finally {
            IOUtils.closeQuietly(intput);
        }
    }

    /**
     * 创建文件夹
     * @param folderPath 文件夹路径
     * @return 创建文件夹是否成功
     * @author wangzz
     * @date 2015年11月26日 下午8:14:54
     */
    public static boolean createFolders(String folderPath) {
        if (folderPath == null) {
            throw new IllegalArgumentException("The folderPath must not be null");
        }
        File file = new File(folderPath);
        //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if (!file.exists()) {
            return file.mkdirs();
        }
        return false;
    }

    /**
     * 创建父文件夹
     * @param folderPath 文件路径
     * @return 创建父文件夹是否成功
     * @author wangzz
     * @date 2015年11月27日 下午4:00:23
     */
    public static boolean createParentFolders(String folderPath) {
        if (folderPath == null) {
            throw new IllegalArgumentException("The folderPath must not be null");
        }
        File file = new File(folderPath);
        return createFolders(file.getParent());
    }

    /**
     * 删除文件或文件夹
     * @param path 文件或文件夹路径
     * @return 是否删除成功
     * @author wangzz
     * @date 2015年11月26日 下午8:11:29
     */
    public static boolean deleteFile(String path) {
        if (path == null) {
            throw new IllegalArgumentException("The path must not be null");
        }
        File file = new File(path);
        return deleteFile(file);
    }

    /**
     * 删除文件或文件夹
     * @param file 文件或文件夹对象
     * @return 是否删除成功
     * @author wangzz
     * @date 2015年11月26日 下午8:11:29
     */
    public static boolean deleteFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("The file must not be null");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] childrens = file.list();
                for (String children : childrens) {
                    deleteFile(new File(file, children));
                }
            }
            return file.delete();
        } else {
            return false;
        }
    }

    /**
     * 获取文件夹中所有文件
     * @param folderPath 文件夹路径
     * @return 文件夹中所有文件
     * @author wangzz
     * @date 2015年11月26日 下午8:11:29
     */
    public static List<File> getFilesInFolder(String folderPath) {
        return getFilesInFolder(new File(folderPath));
    }

    /**
     * @param folder 文件夹
     * @return 文件夹中所有文件
     * @Description 获取文件夹中所有文件
     * @author wangzz
     * @date 2015年12月1日 下午3:11:54
     */
    public static List<File> getFilesInFolder(File folder) {
        if (folder == null) {
            throw new IllegalArgumentException("The folder must not be null");
        }
        List<File> filesPath = new ArrayList<File>();
        if (folder.isDirectory()) {
            File[] fileList = folder.listFiles();
            for (File file : fileList) {
                if (file.isDirectory()) {
                    //是文件夹，递归遍历
                    filesPath.addAll(getFilesInFolder(file.getPath()));
                } else {
                    //是文件，加入文件列表
                    filesPath.add(file);
                }
            }
        }
        return filesPath;
    }

    /**
     * @param filePath 文件路径及文件名
     * @return 创建的File文件
     * @throws IOException
     * @Description 根据路径创建一个文件，如果已有则删除原文件，创建并返回新的文件
     * @author wangzz
     * @date 2015年12月8日 上午10:42:54
     */
    public static File getNewValidateFile(String filePath) throws IOException {
        File file = new File(filePath);
        createParentFolders(filePath);
        if (file.exists()) {
            deleteFile(file);
        }
        file.createNewFile();
        return file;
    }

    /**
     * 文件转成对象
     * @param filePath
     * @param fileName
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T extends Object> T writeFileToObject(String filePath, String fileName) {

        File file = new File(filePath + fileName);
        if (!file.exists()) {
            return null;
        }

        ObjectInputStream fis = null;
        Object object = null;
        try {
            fis = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            object = fis.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 删除资源
        //file.delete();
        //file = new File(filePath + fileName + ".zip");
        //file.delete();
        return (T) object;
    }


    /**
     * 移动文件或目录<br>
     * 当目标是目录时，会将源文件或文件夹整体移动至目标目录下
     * @param src        源文件或目录路径
     * @param target     目标路径，如果为目录，则移动到此目录下
     * @param isOverride 是否覆盖目标文件
     * @return 目标文件Path
     * @since 5.5.1
     */
    public static Path move(Path src, Path target, boolean isOverride) {
        Assert.notNull(src, "Src path must be not null !");
        Assert.notNull(target, "Target path must be not null !");
        final CopyOption[] options = isOverride ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{};
        if (isDirectory(target)) {
            target = target.resolve(src.getFileName());
        }
        // 自动创建目标的父目录
        mkParentDirs(target);
        try {
            return Files.move(src, target, options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否为目录，如果file为null，则返回false<br>
     * 此方法不会追踪到软链对应的真实地址，即软链被当作文件
     * @param path {@link Path}
     * @return 如果为目录true
     * @since 5.5.1
     */
    public static boolean isDirectory(Path path) {
        return isDirectory(path, false);
    }

    /**
     * 判断是否为目录，如果file为null，则返回false
     * @param path          {@link Path}
     * @param isFollowLinks 是否追踪到软链对应的真实地址
     * @return 如果为目录true
     * @since 3.1.0
     */
    public static boolean isDirectory(Path path, boolean isFollowLinks) {
        if (null == path) {
            return false;
        }
        final LinkOption[] options = isFollowLinks ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        return Files.isDirectory(path, options);
    }

    /**
     * 获得文件的MimeType
     * @param file 文件
     * @return MimeType
     * @see Files#probeContentType(Path)
     * @since 5.5.5
     */
    public static String getMimeType(Path file) {
        try {
            return Files.probeContentType(file);
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * 创建所给目录及其父目录
     * @param dir 目录
     * @return 目录
     * @since 5.5.7
     */
    public static Path mkdir(Path dir) {
        if (null != dir && false == exists(dir, false)) {
            try {
                Files.createDirectories(dir);
            } catch (IOException e) {
            }
        }
        return dir;
    }

    /**
     * 创建所给文件或目录的父目录
     * @param path 文件或目录
     * @return 父目录
     * @since 5.5.7
     */
    public static Path mkParentDirs(Path path) {
        return mkdir(path.getParent());
    }

    /**
     * 判断文件或目录是否存在
     * @param path          文件
     * @param isFollowLinks 是否跟踪软链（快捷方式）
     * @return 是否存在
     * @since 5.5.3
     */
    public static boolean exists(Path path, boolean isFollowLinks) {
        final LinkOption[] options = isFollowLinks ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        return Files.exists(path, options);
    }

}
