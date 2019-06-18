package fiveweek.demo0612;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadSocketUTP {
    //服务器
    @Test
    public void testThreadServerSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7999);

        while (true){
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();

            byte[] bytes = new byte[1024];
            int len = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,len);
            }
            String string = byteArrayOutputStream.toString();
            int number = string.charAt(0)-'0';
            String substring = string.substring(2);

            //客户端请求操作
            NumberSwitch(number, substring);

            byteArrayOutputStream.close();
            inputStream.close();
        }
    }


    //根据对应的选项执行相应操作
    public void NumberSwitch(int number, String substring) {
        switch (number){
            case 2:
                //开启线程删除文件
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File(substring);
                        file.delete();
                    }
                }).start();
                break;
            case 3:
                //开启线程创建文件
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File(substring);
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            default:
                break;
        }
    }


    //客户端1
    @Test
    public void testThreadClientSocket1() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 7999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("2 d:/hello.txt".getBytes());

        socket.close();
    }

    //客户端2
    @Test
    public void testThreadClientSocket2() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 7999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("3 d:/hello.txt".getBytes());

        socket.close();

    }

}
