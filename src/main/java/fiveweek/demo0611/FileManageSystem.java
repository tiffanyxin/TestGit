package fiveweek.demo0611;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/6/11  21:41
 */
public class FileManageSystem {
    public static void main(String[] args) throws Exception {
        //默认根路径
        File root = new File("D:/");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintMenu();
        //请选择功能
        Scanner scanner = new Scanner(System.in);

        //根据用户选择操作文件方法
        boolean flag = false;
        while(!flag){
            System.out.println("请按需要输入相应的功能:");
            String number = scanner.next();
            flag = operatorFile(number,br,root);
        }

    }


    //根据用户选择操作文件
    public static boolean operatorFile(String number,BufferedReader br,File root) throws Exception {
        switch (number){
            case "1":
                //创建文件
                System.out.println("分别输入创建的文件名和内容：");
                String fileName = br.readLine();
                String fileContent = br.readLine();
                createFile(fileName,fileContent,root);
                break;
            case "2":
                //删除文件
                System.out.println("请输入要删除的文件名：");
                String deleteFileName = br.readLine();
                isDeleteFile(deleteFileName,root);
                break;
            case "3":
                //复制文件
                System.out.println("请输入要复制的文件名：");
                String copyFileName = br.readLine();
                copyFile(copyFileName,root);
                break;
            case "4":
                //输入要执行的文件名称
                System.out.println("请输入要执行的文件名称：");
                String executeFileName = br.readLine();
                executeFile(executeFileName,root,br);
                break;
            case "exit":
                //退出exit
                System.out.println("Y ? ：");
                String exit = br.readLine();
                if ("Y".equals(exit)){
                    System.exit(0);
                }
                break;
            default:
                System.out.println("请输入1-4的数字选项:");
                break;
        }
        return false;
    }


    ////输入要执行的文件名称
    public static void executeFile(String executeFileName, File root, BufferedReader br) {
        File srcFile = new File(root, executeFileName);
        if (!srcFile.exists()) {
            System.out.println("输入的文件名不存在！");
            return;
        }

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            //定义个字符缓存流，按行读取文件内容
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("");
                for (String num : split) {
                    //文件内容是1234的话，递归执行选项方法operatorFile
                    if ("1".equals(num) || "2".equals(num) ||
                            "3".equals(num) || "4".equals(num)) {
                        operatorFile(num, br, root);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //复制文件
    public static void copyFile(String copyFileName, File root) {
        File srcFile = new File(root, copyFileName);
        if (!srcFile.exists()) {
            System.out.println("输入的文件名不存在！");
            return;
        }

        String[] split = copyFileName.split("\\.");
        String spiltFile = split[0] + ".copy";
        File destFile = new File(root, spiltFile);

        //NIO版的文件拷贝
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(5);

            while ((inChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                outChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("复制成功！");
    }


    //删除文件
    public static void isDeleteFile(String deleteFileName, File root) {
        File[] files = root.listFiles();
        File delFile = new File(root,deleteFileName);
        for (File file : files ){
            if (file.equals(delFile)){
                file.delete();
                System.out.println("删除成功！");
                return ;
            }
        }
        System.out.println("删除的文件不存在！");
    }


    //创建文件
    public static void createFile(String fileName, String fileContent,File root){
        File newFile = new File(root, fileName);
        Writer fw =null;
        try {
            newFile.createNewFile();
            fw = new FileWriter(newFile);
            fw.write(fileContent);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("创建成功！");
    }


    //菜单
    public static void PrintMenu(){
        System.out.println("文件操作选项:");
        System.out.println("  "+"1.创建文件");
        System.out.println("  "+"2.删除文件");
        System.out.println("  "+"3.复制文件");
        System.out.println("  "+"4.输入要执行的文件名称");
        System.out.println("  "+"exit");
    }
}
