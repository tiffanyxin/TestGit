package firstweek.com.qf.demo0515;

import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/5/16  11:48
 */
public class EqualSideWithTriangle {
    public static void main(String[] args) {
//        //等边三角形
         Triangle();
//        //正方形
         square();
        //空心菱形 diamond
        /**
         * 思路:  1.先外循环控制行,内循环控制列
         *        2.找图形行规律,整体图形规律
         *        3.实例化找规律,最后实例n化
         */
       diamond();

    }

    //菱形
    public static void diamond() {
        System.out.println("请输入长度多少的菱形: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
            for(int i=n;i>=1;i--){   //菱形的上半部分
                for(int j=1;j<2*n;j++){
                    if(i==j||j==2*n-i){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            for(int i=2;i<=n;i++){    //菱形的下半部分
                for(int j=1;j<=2*n;j++){
                    if(i==j||j==2*n-i){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

    }


    public static void square() {
        System.out.println("请输入多少边形的正方形:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("*" + " ");
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print("*" + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }

    }


    public static void Triangle() {
        System.out.println("请输入多少边形的等边三角形:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        //等边三角形
        //行数
        for (int i = 0; i < n; i++) {
            //列中的空格数
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            //列中的*数
            //k<i+1: 每行输出的*的个数跟行号保持一致     --->  优化的写法
            for (int k = 0; k < i + 1; k++) {
                if (k==0 || k==i || i==n-1){
                    System.out.print("*"+ " ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
