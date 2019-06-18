package secondweek.demo0520;

import java.io.*;
import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  13:54
 */
public class Demo0520Practice {
    public static void main(String[] args) throws IOException {
        //等边三角形 Triangle
        //正方形 square
        //空心菱形 diamond  *
//        diamond();
        //去空8行的平行四边形
        //输出所有的小写字母
        //输出九九乘法表
        //打印万年历    *
//        printCalendar();
        //求数组中的最大值并输出数组下标值
        //阶乘
        //选择排序
        //冒泡
        //二分查找(给出的数组已经排好序)    *
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //小到大排序,减一
        //start = middle + 1;   end = middle - 1;  数组小到大的排序
        //end = middle - 1;     start = middle + 1;    数组大到小的排序
        binarySearch(array,10);

        //插入排序
        //将给定数组进行反转
        //10个评委打分,(去掉一个最高一个最低)求平均分  (可忽略)
        //数组成员10个,求该数组中第二大的数的下标
        //将给定的数组变成字符串  (可忽略)
        //拷贝文件及其子文件夹     *
        File src = new File("D:\\a");
        File dest = new File("D:\\b");
        floderCopyUtils(src,dest);
//        try {
//            copyFolderAndSub(new File("E:\\a.txt"),new File("E:\\b.txt"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //删除文件及其子文件夹     *
        File file = new File("F:\\a\\b");
        deleteFolder(file);

        //利用递归实现查找树的节点的所有子节点和所有的终结节点    *

    }

    //文件拷贝
    public static void floderCopyUtils(File src, File dest) throws IOException {
        if (src.exists()){
            if (src.isDirectory()) {
                if (!dest.exists()){
                    dest.mkdir();
                }
                String[] lists = src.list();
                for (String list: lists){
                    File srcFile = new File(src, list);
                    File destFile = new File(dest, list);
                    floderCopyUtils(srcFile,destFile);
                }
            }else{
                String fileName = src.getName();
                String[] split = fileName.split("\\.");
                for (String s: split){
                    System.out.println("s = " + s);
                }

                if (!split[1].equals("class")){
                    InputStream input = new FileInputStream(src);
                    OutputStream output = new FileOutputStream(dest);

                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = input.read(bytes)) != -1){
                        output.write(bytes,0,len);
                    }
                    output.close();
                    input.close();
                }
            }
        }else{
            System.out.println("指向的文件夹不存在,请重新输入!");
        }
    }

    //删除文件及其子文件夹
    public static void deleteFolder(File file){
        if (file.exists()){
            if(file.isDirectory()){
                //获取的是当前路径下的所有file
                File[] files = file.listFiles();
                for (File currFile:files){
                    deleteFolder(currFile);
                    if (currFile.length() == 0){
                        currFile.delete();
                    }
                }
                file.delete();
            }else {
                file.delete();
            }
        }

        System.out.println("输入的文件路径不存在!");
    }



    //拷贝文件及其子文件夹
    public static void copyFolderAndSub(File src,File dest) throws Exception {
        //是否目录,是就递归(获取文件名,创建文件)
        //否,就IO复制
        if (src.isDirectory()){
            if (!dest.exists()){
                dest.mkdir();
            }
            //当前路径下所有的文件名
            String[] lists = src.list();
            for (String file : lists){
                File srcFile = new File(src,file);
                File destFile = new File(dest,file);
                copyFolderAndSub(srcFile,destFile);
            }

        }else {

           InputStream fis = new FileInputStream(src);
            OutputStream fos = new FileOutputStream(dest);

            byte[] b = new byte[1024];

            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }
            fos.close();
            fis.close();
        }
    }

    //二分查找
    public static void binarySearch(int[] array,int search){
        int start=0;
        int end = array.length-1;
        int middle;
        boolean flag = false;
        while (start<=end){
            middle = (start+end)/2;
            if (search == array[middle]){
                System.out.println("找到了,下标值为: " + middle);
                flag = true;
                break;
            }else if(search > array[middle]){
                start = middle + 1;

            }else {
                end = middle - 1;

            }
        }
        if (!flag){
            System.out.println("没有找到!!!");
        }

    }

    //打印万年历
    public static void printCalendar(){
        System.out.println("请输入要打印的年份:");
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        System.out.println("请输入要打印的月份:");
        int month = scan.nextInt();

        //总天数
        int allDay = dayOfYear(year) + dayOfOne2Month(year,month) + 1;

        //星期几
        int week = allDay % 7;

        //输出万年历
        printCalFormat(week,year,month);

    }

    //判断闰年
    public static boolean isLeapYear(int year){
        if(year % 400 == 0 || (year%4==0 && year%100 != 0)){
            return true;
        }
        return false;
    }

    //输入月份得一月一号的天数
    public static int dayOfOne2Month(int year,int month){
        int dayOfMonth = 0;
        for (int i=1; i<month ;i++){
            dayOfMonth += dayOfMonth(year,i);
        }
        return dayOfMonth;
    }

    //月份对应天数
    public static int dayOfMonth(int year,int month){
        switch (month){
            case 2:
                return isLeapYear(year)? 29: 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    //输入年份得到天数
    public static int dayOfYear(int year){
        int dayOfYear = 0;
        for (int i=1900; i<year; i++){
            if (isLeapYear(i)){
                dayOfYear += 366;
            }else {
                dayOfYear += 365;
            }
        }
        return dayOfYear;
    }

    //输出格式
    public static void printCalFormat(int week,int year,int month){
        int k=0;
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t");
        for (int i=0; i< week; i++){
            System.out.print("\t\t");
            k++;
        }
        for (int j=1; j<=dayOfMonth(year,month); j++){
            System.out.print(j+"\t\t");
            k++;
            if (k%7==0){
                System.out.println();
            }
        }

    }


    //菱形
    public static void diamond(){
        for (int i=5; i>=1; i--){
            for (int j=1; j<=9; j++){
                if (i==j || j==10-i){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i=2; i<=5; i++){
            for (int j=1; j<=9; j++){
                if (i==j || j==10-i){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


}
