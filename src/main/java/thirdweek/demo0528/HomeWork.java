package thirdweek.demo0528;

import org.junit.Test;

import java.math.BigDecimal;


/**
 * @author Tiffany_xin
 * @time 2019/5/28  21:09
 */
public class HomeWork {

    //第四题

    @Test
    public void testArea1() throws Exception {
        int r = 3;
        double result = 0;
        try {
            result = Math.PI * r * r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal bd = new BigDecimal(result);
        System.out.println(bd.setScale(5, BigDecimal.ROUND_HALF_UP));
    }


    @Test
    public void testProgramTime() throws Exception {
        long start = System.currentTimeMillis();
        int sum = 0;
        try {
            for (int i = 2; i <= 100000; i++) {
                if (i % 2 == 0) {
                    sum += i;
                    if (sum % 200 == 0) {
                        System.err.println(sum);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    //第五题
//  try :  try块包含可能会发生异常的代码，并且捕获异常
//  catch：try块跟catch块一起使用，try块捕获到的异常，如果跟catch中的异常类型一致，则执行catch块的方法体
//  finally： finally跟try，catch块一起用，无论什么情况，finally的方法体都会执行，除非系统退出；
//            finally方法体一般写些必须执行的代码，比如第三方资源的关闭，I/O流关闭，数据库连接关闭等；
//  throws： 如果当前方法的代码存在异常，当前方法无法处理，或者不想处理抛给上级处理，则在方法参数（）后使用该关键字throws 接异常类型
//  throw： 用于手动抛异常，使用格式 throw new 后接异常类型；




}

