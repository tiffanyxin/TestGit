package fiveweek.demo0610;

import java.io.*;
import java.util.Properties;


/**
 * @author Tiffany_xin
 * @time 2019/6/10  21:16
 */
public class SchoolWorkIO {
    public static void main(String[] args) throws Exception {
        //1
//        totalCount();

        //2
//        getStuScore();



    }


    //2
    public static void getStuScore() throws IOException {
        PrintWriter pw = new PrintWriter("D:/stud.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0 ; i<4; i++){
            String line = br.readLine();
            String[] split = line.split(",");

            int sum = Integer.valueOf(split[1])+Integer.valueOf(split[2])+Integer.valueOf(split[3]);
            pw.println(split[0]+"="+sum);
            pw.flush();
        }
        pw.close();
    }


    //1
    public static void totalCount() throws IOException {
        PrintWriter pw = new PrintWriter("D:/b.txt");

        //读
        Reader fr = new FileReader("D:/a.properties");

        Properties pro = new Properties();
        pro.load(fr);
        int count = Integer.valueOf(pro.getProperty("count"));

        //判断
        if (count <= 5){
            System.out.println("使用次数为:"+ count);
        }else{
            pw.print("该程序的使用次数已超过5次,请注册后再使用");
            pw.close();
            fr.close();
            return;
        }

        count++;
        String stringCount = String.valueOf(count);
        //写
        pro.setProperty("count",stringCount);
        pro.store(new FileWriter("D:/a.properties"),"count次数加一");

        pw.close();
        fr.close();
    }
}
