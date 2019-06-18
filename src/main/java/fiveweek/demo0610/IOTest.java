package fiveweek.demo0610;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Tiffany_xin
 * @time 2019/6/10  9:23
 */
public class IOTest {
    public static void main(String[] args) throws Exception {
        //装饰设计模式
        PC pc = new PC();
        Mp3Decorator mp3Decorator = new Mp3Decorator(pc);
        mp3Decorator.add();

        //适配器设计模式(对象适配器,类适配器)
        China chinaAdapter = new ChinaAdapter();
        chinaAdapter.execute();

        //序列化
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("D:/cat.obj"));
        ous.writeObject("STRING");
        ous.writeObject(new Cat(10));


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/cat.obj"));
        Object o = ois.readObject();
        Cat cat = (Cat) o;
        System.out.println(cat.getAge());
    }
}
