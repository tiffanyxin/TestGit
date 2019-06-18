package thirdweek.demo0529;

import java.util.Arrays;

/**
 * @author Tiffany_xin
 * @time 2019/5/29  19:03
 */
public class HomeWork {
    public static void main(String[] args) {
        //1.模拟trim()方法
        System.out.println(copyTrim("   abc de  "));

        //2.将字符串中指定部分进行反转
        System.out.println(reverseString("abcdefg", 2, 5));

        //3.将字符串中的字符进行自然排序(自然顺序12345)
        System.out.println(natureSort("15784028"));

        //4.校验13条形码
        identifyCode("6921168509256");

        //5.正则表达式验证电话号码
        System.out.println(regexPhoneNumber("0775-12345443"));
    }


    //5.正则表达式验证电话号码
    public static  Boolean regexPhoneNumber(String phoneNum){
        return phoneNum.matches("0[0-9]{3}-[1-9][0-9]{7}");
    }


    //4.校验13条形码
    public static void identifyCode(String code){
        String substring = code.substring(0, code.length()-1);
        String lastString = code.substring(code.length()-1);

        //把字符串改为字符串数组
        String[] splitString = substring.split("");

        int oddNumberSum=0;
        int evenNumberSum=0;
        for (int i=0; i<splitString.length; i++){
            int castNumber = Integer.valueOf(splitString[i]);
            if ( castNumber%2 == 0){
                evenNumberSum += castNumber;
            }else {
                oddNumberSum+=castNumber;
            }
        }

        //取出个位数
        String sumString = String.valueOf((oddNumberSum + 3*evenNumberSum));
        String[] split = sumString.split("");
        int lastNumber = Integer.valueOf(split[split.length-1]);

        //该字符串的最后一位数
        int lastInt = Integer.valueOf(lastString);

        if ((10-lastNumber) == lastInt){
            System.out.println("验证码正确");
            return;
        }
        System.out.println("验证码不正确!");
    }



    //3.将字符串中的字符进行自然排序(自然顺序12345)
    public static String natureSort(String temp){
        char[] chars = temp.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }


    //2.将字符串中指定部分进行反转
    public static String reverseString(String temp,int start,int end){
        char[] chars = temp.toCharArray();
        int middle = (end+start)/2;
        //以middle下标为界限,反转赋值
        for (int i = start; i <= middle; i++) {
            char param = chars[i];
            chars[i] = chars[end];
            chars[end] = param;
            end--;
        }
        return new String(chars);
    }


    //1.模拟trim()方法
    public static String copyTrim(String temp){
        int startIndex=0;
        int endIndex=0;
        //获取第一个不为空的开始下标
        for (int i = 0; i < temp.length(); i++) {
            if ( temp.charAt(i) != ' '){
                startIndex = i;
                break;
            }
        }

        //获取最后一个不为空的字符下标
        for (int k=temp.length()-1; k>=0; k--){
            if ( temp.charAt(k) != ' '){
                endIndex = k;
                break;
            }
        }

        //去除两端空格后的字符串
        return temp.substring(startIndex,endIndex+1);

    }


}
