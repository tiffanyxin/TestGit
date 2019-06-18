package thirdweek.demo0528;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiffany_xin
 * @time 2019/5/28  21:31
 */
public class SceneException {

    public static void main(String[] args) {
        //OutOfMemoryError
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (true) {
            list.add(i++);
        }
    }

    @Test
    public void test3(){
        //StackOverflowError
        recursivePrint(1);
    }


    @Test
    public void test2(){
        //NullPointerException
        String nullString = null;
        System.out.println(nullString.length());
    }

    @Test
    public void test1(){
        //ClassCastException
        Object dog = new Dog();
        People people = (People) dog;
    }


    public void recursivePrint(int num) {
        recursivePrint(++num);
    }

}
