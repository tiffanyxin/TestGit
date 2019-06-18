package fiveweek.demo0614;

/**
 * @author Tiffany_xin
 * @time 2019/6/14  18:56
 */
public class Person implements  Eat{

    @Override
    public String eat() {
        System.out.println("原始的饭");
        return "fanhui";
    }
}
