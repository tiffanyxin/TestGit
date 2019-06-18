package fiveweek.demo0612;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSocketUTP {
    //服务器
    @Test
    public void testFileServerSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7688);

        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = new FileOutputStream("D:/bb.txt");

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }

        //停止写入，切换
        accept.shutdownInput();

        OutputStream outputStreamSocket = accept.getOutputStream();
        outputStreamSocket.write("发送成功".getBytes());


        outputStreamSocket.close();
        outputStream.close();
        inputStream.close();

    }


    //客户端
    @Test
    public void testFileClientSocket() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 7688);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = new FileInputStream("D:/b.txt");

        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }

        //停止输出，切换
        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        inputStream.close();
        socket.close();



    }
}
