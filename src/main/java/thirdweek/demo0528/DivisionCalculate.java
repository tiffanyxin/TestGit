package thirdweek.demo0528;

import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/5/28  21:01
 */
public class DivisionCalculate {
    public static void main(String[] args) {
        System.out.println("请输入一个正数:");
        Scanner param = new Scanner(System.in);
        String paramEd = param.next();

        System.out.println("请输入第二个正数:");
        String paramDi = param.next();

        int intEd = Integer.valueOf(paramEd);
        int intDi = Integer.valueOf(paramDi);

        if (intEd <0 || intDi<0){
            throw new NegativeException("输入的数字不能为负数!!!");
        }

        try{
            System.out.println(intEd / intDi);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
}
