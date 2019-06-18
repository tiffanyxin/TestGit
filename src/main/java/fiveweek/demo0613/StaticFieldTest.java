package fiveweek.demo0613;

/**
 * @author Tiffany_xin
 * @time 2019/6/13  21:22
 */
public class StaticFieldTest {

    static int i = 0;

    static {
        i=10;
        System.out.println("这是静态代码块 i = " + i);
    }

    public static void updateStaticField(){
        i=20;
        System.out.println("这是静态方法 i = " + i);
    }
}


class TestTest{
    public static void main(String[] args) {

        System.out.println("StaticFieldTest.i = " + StaticFieldTest.i);
        //输出结果分别是:
//        这是静态代码块 i = 10
//        StaticFieldTest.i = 10
        //所以静态属性定义的执行顺序在静态代码块前;

        StaticFieldTest.updateStaticField();

        //输出结果分别是:
//        这是静态代码块 i = 10
//        StaticFieldTest.i = 10
//        这是静态方法 i = 20
        //所以静态代码块的执行顺序在静态方法前;

        //所以得出执行顺序:   静态属性定义 -> 静态代码块 -> 静态方法

    }
}