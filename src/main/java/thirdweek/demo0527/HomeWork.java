package thirdweek.demo0527;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/5/27  21:09
 */
public class HomeWork {
           @Test
        public void testValueCompare(){
            /**
             *    *.parseInt(参数) , *.valueOf(参数): 不一定会创建对象,如果结果符合-128~127范围,
             *    直接从缓存中取,不会创建新的对象;如果超出范围,则创建一个新的对象!
             */
            Integer i = Integer.parseInt("30");
            Integer j = Integer.parseInt("300");

            //String --> Integer 两种方式
            Integer k = Integer.valueOf("30");
            Integer l = Integer.valueOf("300");

            //true
            System.out.println(i==k);
            //false
            System.out.println(j==l);

        }


    @Test
    public void testTypeConvert(){
        //基本数据类型-->包装类
        int i = 10;
        Integer integer = new Integer(i);
        //包装类-->基本数据类型
        int i1 = integer.intValue();

        //基本数据类型-->String类
        int j = 10;
        String s = String.valueOf(j);
        //String类-->基本数据类型
        int j2 = Integer.parseInt(s);

        //包装类-->String类
        Integer integer1 = 100;
        String s1 = String.valueOf(integer1);
        //String类-->包装类
        Integer integer2 = Integer.valueOf(s1);
    }


    @Test
    public void testCalendar() throws Exception {
        System.out.println("请输入一个年月日的日期: ");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();

        SimpleDateFormat parseFormat;
        SimpleDateFormat format1Format;
        SimpleDateFormat format2Format;

        parseFormat = new SimpleDateFormat("yyyyMMdd");
        //输入的与解析的格式基本一致
        Date parseDate = parseFormat.parse(date);
        format1Format = new SimpleDateFormat("yyyy/MM/dd");
        format2Format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(format1Format.format(parseDate));

        Calendar calendar = Calendar.getInstance();
        //Calendar的setTime(),add,getTime,get()
        calendar.setTime(parseDate);
        calendar.add(Calendar.DAY_OF_MONTH,5);

        System.out.println(format2Format.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)-1);

    }


    @Test
    public  void testRandom() {
        Random random = new Random();
        int sum=0;
        int count=0;
        for (int i=2; i<=32; i++){
            //随机获取2~32之间的偶数
            int j = random.nextInt(33);
            //去掉0
            if (j!=0 && j%2==0){
                sum+=j;
                count++;
            }
            if (count==6){
                break;
            }
        }
        System.out.println(sum);
    }


    @Test
    public  void testArea() {
        int r=3;
        double result = Math.PI*r*r;
        //小数输出BigDecimal
        BigDecimal bd = new BigDecimal(result);
        System.out.println(bd.setScale(5, BigDecimal.ROUND_HALF_UP));
    }


    @Test
    public  void testProgramTime() {
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i = 2; i<=100000; i++){
            if (i%2 ==0){
                sum+=i;
                //没得到sum就要判断下,不要放到if之外,会重复输出
                if (sum%200 == 0){
                    System.err.println(sum);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
