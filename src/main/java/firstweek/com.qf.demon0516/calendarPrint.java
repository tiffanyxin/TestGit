package firstweek.com.qf.demon0516;

import java.util.*;

/**
 * @author Tiffany_xin
 * @time 2019/5/16  16:00
 *
 * 输出格式问题?                ---   被输出图形,内外for循环限制了思路
 * 2020年的输出怎么是错的呢?    ---   写错了参数: 把i写成了year;
 * 1900.1.1;   ---   非1990
 *
 * 优化地方:
 * 星期一到星期日的输出
 * mian方法中只写方法名
 * switch优化 --  相同的可以写到一起,return可代替break
 */
public class calendarPrint {
    public static void main(String[] args) {
        System.out.println("请输入年份: ");
        Scanner scanY = new Scanner(System.in);
        int year = scanY.nextInt();

        System.out.println("请输入月份: ");
        Scanner scanM = new Scanner(System.in);
        int mon = scanM.nextInt();

        //总天数
        int allDay = totalDay(year) + monTotalDay(mon, year);
        System.out.println(allDay);
        System.out.println(totalDay(year));
        System.out.println(monTotalDay(mon, year));


        //得出输入月份的第一天是星期几
        int week = allDay % 7;

        //日历输出
        printCalendat( week, mon, year);

    }

    public static void printCalendat(int week,int mon,int year){
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
        int i = 0;
        for(int j=0; j<week; j++){
            System.out.print("\t\t");
            i++;
        }
        for (int k=1; k<totalDayOfMon(mon,year); k++){
            System.out.print(k+"\t\t");
            i++;

            if(i%7 == 0){
                System.out.println();
            }
        }
    }

    //拿到年份统计到1900.1.1有多少天
    public static int totalDay(int year) {
        int sumDay = 0;
        for (int i = 1900; i < year; i++) {
//            if (isLeapYear(i)) {         //写错了参数: 把i写成了year;
//                sumDay += 366;
//            } else {
//                sumDay += 365;
//            }
            sumDay += isLeapYear(i) ? 366: 365;
        }
        return sumDay;
    }

    //拿到输入的月份1号到该年.1.1有多少天
    public static int monTotalDay(int mon, int year) {
        int monDay = 0;
        for (int i = 1; i < mon; i++) {
            monDay += totalDayOfMon(i, year);
        }
        return monDay + 1;
    }

    //判断是否为闰年
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    //根据输入的月判断月的天数
    public static int totalDayOfMon(int mon, int year) {
        switch (mon) {
            case 2:
                return isLeapYear(year)? 29: 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
