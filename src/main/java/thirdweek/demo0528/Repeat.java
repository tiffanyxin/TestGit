package thirdweek.demo0528;

import org.junit.Test;

/**
 * @author Tiffany_xin
 * @time 2019/5/29  8:45
 */
public class Repeat {

    //正常情况
//    输出：  3
//            我是try的代码
//            我是finally的代码
//   正常情况下，没有异常，try块代码从上往下执行，输出"3"和"我是try的代码"，然后return；结束方法体，
//   最后执行finally块输出"我是finally的代码"
    @Test
    public void ExceptionTest1() {
        String stringNull = "abc";
        try {
            System.out.println(stringNull.length());
            System.out.println("我是try的代码");
            return;
        } catch (Exception e) {
            System.out.println("我是catch的代码");
            e.printStackTrace();
        } finally {
            System.out.println("我是finally的代码");
        }
    }

    //异常情况
//  输出： java.lang.NullPointerException
//	       at com.dvte.sparkproject.test.HomeWork.ExceptionTest2(HomeWork.java:183)
//         我是catch的代码
//         我是finally的代码
    //异常情况下，执行try块代码的stringNull.length()，然后报空指针异常，stringNull.length()后的代码不会执行，而来到catch模块
    //中匹配到对应的异常类型，然后执行对应的catch模块，输出”我是catch的代码“，最后执行finally块输出”我是finally的代码“
    @Test
    public void ExceptionTest2() {
        String stringNull = null;
        try {
            System.out.println(stringNull.length());
            System.out.println("我是try的代码");
            return;
        } catch (Exception e) {
            System.out.println("我是catch的代码");
            e.printStackTrace();
        } finally {
            System.out.println("我是finally的代码");
        }
    }
}
