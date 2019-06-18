package firstweek.com.qf.demon0516;

import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/5/16  20:15
 *
 * 输出格式为: f(5)=5*4*3*2*1  ??  不做要求,没什么意义
 *  System.out.printf("%d" , fac);   格式化输出%d, printf
 */
public class Page3 {
    public static void main(String[] args) {
        System.out.println("一个整数: ");
        Scanner scan = new Scanner(System.in);
        int fac = scan.nextInt();

        //阶乘
        System.out.println(fact(fac));

    }

    public static int fact(int a){
        if (a==1 || a==0){
            return 1;
        }
        return a*fact(a-1);
    }
}
