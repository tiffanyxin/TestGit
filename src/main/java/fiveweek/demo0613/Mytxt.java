package fiveweek.demo0613;

import java.io.File;
import java.io.IOException;

/**
 * @author Tiffany_xin
 * @time 2019/6/13  21:03
 */
public class Mytxt {
    public void myCreate(){
        File file = new File("D:/myhello.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
