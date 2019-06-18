package fiveweek.demo0613;


import java.lang.reflect.Field;

/**
 * @author Tiffany_xin
 * @time 2019/6/13  14:50
 */
public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class priClass = Class.forName("fiveweek.demo0613.PrivateTest");
            Object o = priClass.newInstance();

            Field name = priClass.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println("name.get(o) = " + name.get(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
