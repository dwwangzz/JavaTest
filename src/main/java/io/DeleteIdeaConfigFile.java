package io;
/**
 * 删除文件夹中的文件
 * @author wangzz
 * @date 2021年02月03日 10:35
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @author: wangzz
 * @date: 2021年02月03日 10:35
 */
public class DeleteIdeaConfigFile {

    public static void main(String[] args) throws IOException {
        String ideaProjectPath = "D:\\develop\\IdeaProjects\\iep-platform-basic";
        File file = new File(ideaProjectPath);
        deleteByDir(file, ".iml");
        deleteByDir(file, ".flattened-pom.xml");
        //deleteByDir(file, "target");
        //deleteByDir(file, ".idea");
    }

    /**
     * 递归删除以suffix结尾的文件
     * @param rootFile
     * @param suffix
     */
    public static void deleteByDir(File rootFile, String suffix) {
        if (!rootFile.exists()) {
            return;
        }
        if (deleteBySuffix(rootFile, suffix)) {
            return;
        }
        for (File file : rootFile.listFiles()) {
            if (file.isDirectory()) {
                if (deleteBySuffix(file, suffix)) {
                    continue;
                }
                deleteByDir(file, suffix);
            } else {
                deleteBySuffix(file, suffix);
            }
        }
    }

    /**
     * 根据后缀名删除文件
     * @param file
     * @param suffix
     * @return
     */
    public static boolean deleteBySuffix(File file, String suffix) {
        if (!file.exists()) {
            System.out.println("删除【" + file.getAbsolutePath() + "】不存在！");
            return true;
        }
        if (file.getName().endsWith(suffix)) {
            System.out.println("删除【" + file.getAbsolutePath() + "】成功！");
            file.delete();
            return true;
        }
        return false;
    }


}
