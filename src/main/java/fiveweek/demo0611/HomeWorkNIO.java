package fiveweek.demo0611;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author Tiffany_xin
 * @time 2019/6/11  19:20
 */
public class HomeWorkNIO {
    public static void main(String[] args) throws Exception {
        //1.编码与解码
//        EncodeAndDecode();

        //2. NIO版的文件拷贝
        long start = System.currentTimeMillis();
//        fileCopyNIO();
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        //4.文件夹拷贝
        File src = new File("D:\\a");
        File dest = new File("D:\\b");
//        floderCopyUtils(src, dest);

    }


    //4.文件夹拷贝
    public static void floderCopyUtils(File src, File dest) {
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
            for (File file : files){
                File destFile = new File(dest, file.getName());
                floderCopyUtils(file, destFile);
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
    }

    //2. NIO版的文件拷贝
    public static void fileCopyNIO() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("D:/a.txt");
            fos = new FileOutputStream("D:/b.txt");

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            while ((inChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //1.编码与解码
    public static void EncodeAndDecode() {
        //编码
        Charset charset = Charset.forName("utf-8");
        CharBuffer charBuffer = CharBuffer.allocate(30);
        charBuffer.put("Hello,我在深圳,");

        charBuffer.flip();
        ByteBuffer byteEncode = charset.encode(charBuffer);
        byte[] b = new byte[byteEncode.limit()];
        byteEncode.get(b);
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[i] = " + b[i]);
        }

        //解码
        byteEncode.flip();
        CharBuffer charDecode = charset.decode(byteEncode);
        char[] c = new char[charDecode.limit()];
        charDecode.get(c);
        for (int i = 0; i < c.length; i++) {
            System.out.println("c[i] = " + c[i]);
        }
    }
}
