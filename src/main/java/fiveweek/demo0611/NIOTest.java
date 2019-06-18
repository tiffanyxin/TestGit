package fiveweek.demo0611;

import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.concurrent.locks.Lock;

/**
 * @author Tiffany_xin
 * @time 2019/6/11  14:00
 */
public class NIOTest {
    public static void main(String[] args) {
//        ByteBuffer allocate = ByteBuffer.allocate(1024);
//
//        System.out.println("allocate.capacity() = " + allocate.capacity());
//        System.out.println("allocate.limit() = " + allocate.limit());
//        System.out.println("allocate.position() = " + allocate.position());
//
//        byte[] b = new byte[]{1,2,3,4,5};
//
//        allocate.put(b);
//        System.out.println("allocate.capacity() = " + allocate.capacity());
//        System.out.println("allocate.limit() = " + allocate.limit());
//        System.out.println("allocate.position() = " + allocate.position());
//
//        allocate.flip();
//        System.out.println("allocate.capacity() = " + allocate.capacity());
//        System.out.println("allocate.limit() = " + allocate.limit());
//        System.out.println("allocate.position() = " + allocate.position());
//        System.out.println("allocate.get() = " + allocate.get());


        File file = new File("D:/a/a.txt");
        System.out.println("file.getName() = " + file.getName());

        //编码
        Charset charset = Charset.forName("utf-8");
        CharBuffer allocate = CharBuffer.allocate(1024);
        allocate.put("张老师");

        allocate.flip();
        ByteBuffer byteEncode = charset.encode(allocate);
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
