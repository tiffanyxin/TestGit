package fiveweek.demo0610;

import java.io.*;

public class HomeWorkIO {
    public static void main(String[] args) {

        //1
        String inputPath = "src/main/java/com/dvte/sparkproject/Pie.java";
        int i = inputPath.lastIndexOf('/');
        int j = inputPath.lastIndexOf('.');
        String substring = inputPath.substring(i+1,j);
        String classSubstring = "class "+substring;
        String replaceClassSubstring = "class Qf"+substring;

//        updateIO(inputPath,"D:/QfPie.java","utf-8",classSubstring,replaceClassSubstring);

        //2
         String fileInputString = "D:/并发编程视频/2018年最新Java并发编程原理与实战附代码讲义 63课/62final域的内存语义.mp4";
        String fileOutputString = "D:/62final域的内存语义.mp4";
        String bufferedOutputString = "E:/62final域的内存语义.mp4";
         long outputStreamStartTime = System.currentTimeMillis();
//        outputStreamTime(fileInputString,fileOutputString);
        long outputStreamEndTime = System.currentTimeMillis();
        System.out.println("字节流拷贝所需时间： " + (outputStreamEndTime-outputStreamStartTime));

        long bufferedStreamStartTime = System.currentTimeMillis();
//        bufferedStreamTime(fileInputString,bufferedOutputString);
        long bufferedoutputStreamEndTime = System.currentTimeMillis();
        System.out.println("缓冲流拷贝所需时间： " + (bufferedoutputStreamEndTime-bufferedStreamStartTime));

        //3
        String output = "D:/a.txt";
        charWriterLocal(output);

        //4
        File[] files = new File("src/main/java/com/dvte/sparkproject/util").listFiles();
        String outputFile = "D:/b.txt";
//        mergeFile(files,outputFile);
    }


    //4
    public static void  mergeFile(File[] files,String output){
        InputStream fis = null;
        OutputStream fos = null;

            try {
                for (File file : files) {
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(output,true);
                    byte[] bytes = new byte[1024 * 4];
                    int len = 0;
                    while ((len = fis.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                        fos.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }


    //3
    public static void charWriterLocal(String output){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(output));
            StringBuffer sbf = new StringBuffer();
            for(int i=0; i<=65535; i++){
                sbf.append((char)i);
                if (sbf.length() == 100){
                    bw.write(sbf.toString());
                    bw.newLine();
                    bw.flush();
                    sbf = new StringBuffer();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //2
    public static void bufferedStreamTime(String input,String output){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
             bis = new BufferedInputStream(new FileInputStream(input));
             bos = new BufferedOutputStream(new FileOutputStream(output));
            byte[] bytes = new byte[1024*4];
            int len=0;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void outputStreamTime(String input,String output){
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(input);
            fos = new FileOutputStream(output);
            byte[] bytes = new byte[1024*4];
            int len=0;
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
                fos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //1
    public static void updateIO(String input,String output,String coding,String target, String replace){
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream(input);
            fos = new FileOutputStream(output);
            byte[] bytes = new byte[1024];
            int len=0;
            while ((len = fis.read(bytes)) != -1){
                for (int i=0; i<bytes.length; i++){
                    System.out.print((char)bytes[i]);
                }
                String string = new String(bytes, coding);
                String replaceString = string.replace(target, replace);
                byte[] stringBytes = replaceString.getBytes(coding);
                fos.write(stringBytes,0,stringBytes.length);
                fos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
