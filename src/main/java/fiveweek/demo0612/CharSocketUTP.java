package fiveweek.demo0612;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CharSocketUTP {
    //服务器
    @Test
    public void testServerSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        //全部转换成大写打印到控制台
        System.out.println(byteArrayOutputStream.toString().toUpperCase());

        accept.shutdownInput();

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("You are crazy,man!".getBytes());

        outputStream.close();
        byteArrayOutputStream.close();
        inputStream.close();
    }

    //客户端
    @Test
    public void testClientSocket() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(),7777);
//        Socket socket = new Socket("10.36.142.2",3939);

        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("This is programming world!".getBytes());
        outputStream.write("2dsfdsfs".getBytes());

        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        socket.close();
    }

}
