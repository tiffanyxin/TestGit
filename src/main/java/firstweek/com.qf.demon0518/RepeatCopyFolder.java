package firstweek.com.qf.demon0518;

import java.io.*;

/**
 * @author Tiffany_xin
 * @time 2019/5/18  11:58
 *
 * 拷贝之后默认会生成一个temp??
 */
public class RepeatCopyFolder {
    //拷贝文件及其子文件夹
    public static void main(String[] args) throws IOException {
        File src = new File("F:\\a");
        File dest = new File("F:\\bb");
        copyFolder(src, dest);
    }

    public static void copyFolder(File src, File dest) throws IOException {
        //先判断,文件不存在直接返回
        if (!src.exists()) {
            System.out.println("指向的文件夹不存在,请重新输入!");
            return;
        }

        //是目录的情况
        if (src.isDirectory()) {
            //dest不存在则创建文件夹
            if (!dest.exists()) {
                dest.mkdir();
            }

            File[] files = src.listFiles();
            for (File file : files) {
                File destFile = new File(dest, file.getName());
                copyFolder(file, destFile);
            }
            return;
        }

        //是文件夹直接拷贝
        String fileName = src.getName();
        if (!fileName.endsWith("class")) {
            InputStream input = null;
            OutputStream output = null;
            try {
                input = new FileInputStream(src);
                output = new FileOutputStream(dest);

                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = input.read(bytes)) != -1) {
                    output.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    output.close();
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //考虑性能优化代码:
//        if (src.isDirectory()) {
//            if (!dest.exists()) {
//                dest.mkdir();
//            }
//            String files[] = src.list();
//            for (String file : files) {
//                File srcFile = new File(src, file);
//                File destFile = new File(dest, file);
//                // 递归复制
//                copyFolder(srcFile, destFile);
//            }
//        } else {
//            InputStream in = new FileInputStream(src);
//            OutputStream out = new FileOutputStream(dest);
//
//            byte[] buffer = new byte[1024];
//
//            int length;
//            while ((length = in.read(buffer)) != -1) {
//                out.write(buffer, 0, length);
//            }
//            in.close();
//            out.close();
//        }
//    }


    }
}
