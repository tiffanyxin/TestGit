package firstweek.com.qf.demon0518;

import java.io.File;

/**
 * @author Tiffany_xin
 * @time 2019/5/18  11:26
 */
public class RepeatDeletefolder {

        public static void main(String[] args) {
            File file = new File("F:\\a");

            //编写一个递归删除方法，传入文件夹，删除该文件夹和下面的所有子文件
            delFroder(file);

        }

        //删除文件夹的优化
    public static String delFroder(File file) {
            //判断路径是否存在
            if (!file.exists()) {
                return "路径不存在";
            }

            //判断首路径是否是文件夹,是就将所以的文件夹和文件放入一个File数组
            if (!file.isDirectory()) {
                file.delete();
                return null;
            }
            //把所以文件夹和文件路径放入一个 File数组
            File[] fileList = file.listFiles();
            //文件夹有多少,就遍历多少次,不然删不完
            for (File filePath : fileList) {
                //System.out.println(filePath);
                delFroder(filePath);
                //把文件全部删完,再删文件夹
                if (filePath.length() == 0) {
                    filePath.delete();
                }
            }
            //当上面的for循环结束后,表示该文件夹已经全部删除
            file.delete();

            return "已经被全部干掉了!!!";
        }

//        //判断路径是否存在
//        if (file.exists()) {
//            //判断首路径是否是文件夹,是就将所以的文件夹和文件放入一个File数组
//            if (file.isDirectory()) {
//                //把所以文件夹和文件路径放入一个 File数组
//                File fileList[] = file.listFiles();
//                //文件夹有多少,就遍历多少次,不然删不完
//                for (File filePath : fileList) {
//                    //System.out.println(filePath);
//                    delFroder(filePath);
//                    //把文件全部删完,再删文件夹
//                    if (filePath.length() == 0) {
//                        filePath.delete();
//                    }
//                }
//                //当上面的for循环结束后,表示该文件夹已经全部删除
//                file.delete();
//            } else {
//                file.delete();
//            }
//        } else {
//            return "路径不存在";
//        }
//        return "已经被全部干掉了!!!";

}

