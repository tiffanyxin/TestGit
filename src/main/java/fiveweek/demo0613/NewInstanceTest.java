package fiveweek.demo0613;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Tiffany_xin
 * @time 2019/6/13  20:51
 */
public class NewInstanceTest {
    public static void main(String[] args) {
        //第一题
        try {
            Class  stuClass = Class.forName("fiveweek.demo0613.Student");
            Constructor constructor = stuClass.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Constructor constructorParam = stuClass.getDeclaredConstructor(String.class,int.class);
            Object cp = constructorParam.newInstance("乔七", 18);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //第二题
        try {
            Class methodClass = Class.forName("fiveweek.demo0613.Mytxt");
            Object o = methodClass.newInstance();
            Method myCreate = methodClass.getDeclaredMethod("myCreate");

            myCreate.invoke(o);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}