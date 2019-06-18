package firstweek.com.qf.demo0515;

public class Work0515 {
    public static void main(String[] args) {
        //8行的平行四边形
//        for(int i=1; i<=8; i++){
//            for (int j=1; j<=8-i; j++){
//                System.out.print(" ");
//            }
//            for (int k =1; k<=8; k++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        //去空8行的平行四边形
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 8; k++) {
                //去空
                if (i == 1 || i == 8) {
                    System.out.print("*");
                } else {
                    if (k == 1 || k == 8) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }


        //输出所有的小写字母
        for (int i = 97; i >= 97 && i <= 122; i++) {
            System.out.print((char) i + "\t");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        //输出九九乘法表
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }

//        int i=0;
//        for(i++; i++ < 10; i++){
//            System.out.println(++i);
//        }
        /**
         * for循环的执行顺序是先执行初始化语句 i++后i的值为1,然后执行判断语句 i < 10满足条件后i自增1后值变为2,接着执行方法体i先自增1值变为3后输出,所以
         * 第一个值输出为3,然后执行重复式i++后i的值为4,然后又执行判断语句i++<10,以此类推,得出后两个输出值为6和9.
         */

//        int a=10,b=11;
//        if(a++ >= --b && a++ >= --b || a++ >= --b){
//            a = b++;
//            b = a++;
//            System.out.println(a + "--" + b);
//        }
        // a=10,b=9
        /**
         *  按照优先级,if条件判断 a++ >= --b中,a先与b的值进行比较后自增,b自减后值为10,a与b的值相等都为10,所以返回true,a的值自增1变为11,b为10;
         *  以此类推第二个判读语句, a++ >= --b中,11>=9也返回true,a的值变为12,b为9; 由于逻辑与两边表达式都为true,所以返回true,后面是短路或,后半部分
         *  a++ >= --b不用计算,接着计算方法体 a=b++后,b赋值给a后, a的值为9,b自加1变为10;  再往后b=a++,a赋值给b后,b的值为9,a自加1变为10. 所以最后
         *  结果a=10,b=9
         */

    }
}
