package firstweek.com.qf.demon0517;

/**
 * @author Tiffany_xin
 * @time 2019/5/17  15:27
 */


/**
 *  1.写一个方法,将给定数组进行反转
 *
 * 2.B哥去参加青年歌手大奖赛,有10个评委打分,(去掉一个最高一个最低)求平均分?
 *
 * 3.给定一个整型数组，数组成员10个,求该数组中第二大的数的下标
 *java.lang.ArrayIndexOutOfBoundsException: 10:   用二分查找的前提是数组排好序!!!!
 *
 * 4.将给定的数组变成字符串，[元素1,元素2…]
 * {34,12,65} —> “[34,12,65]”
 *
 * 5.写一个选择排序(提示:每一次遍历找下最大值,并把最大值放在最右边)
 *
 * 6.讲下result的结果: result=3^8+~4+3&5+2|1+3>>3;
 */

public class WorkStudy {
    public static void main(String[] args) {
       // 1.写一个方法,将给定数组进行反转
        int[] array = {1,2,3,4,5,6};
        reverseArray(array);

        //2.B哥去参加青年歌手大奖赛,有10个评委打分,(去掉一个最高一个最低)求平均分?
        double[] avg10Array = {9.5,9,5,7,6,8,9.5,8,9,4};
        getAvg(avg10Array);

        //3.给定一个整型数组，数组成员10个,求该数组中第二大的数的下标
        int[] arrayInt = {5,13,81,23,3,4,5,6,9,6};
        getSecond(arrayInt);

        //4.将给定的数组变成字符串
        int[] convertArray = {1,2,3,4,5,6};
        convertString(convertArray);

        //5.写一个选择排序
        int[] selectArray = {5,13,81,23,3,4,5,6,9,6};
       selectSort(selectArray);

        //6.讲下result的结果: result=3^8+~4+3&5+2|1+3>>3;
        //结果为5,执行顺序为: ~ ,+,>>,&,^,|
    }

    //5.写一个选择排序(提示:每一次遍历找下最大值,并把最大值放在最右边)
    public static void selectSort(int[] array){
        System.out.print("选择排序前的数组: " +"  ");
        for (int k=0; k<array.length; k++){
            System.out.print(array[k] + " ");
        }
        System.out.println();

        for (int i=array.length-1; i>0; i--){
            for (int j=i-1; j>=0; j--){
                if(array[i] < array[j]){
                    int temp=array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.print("选择排序后的数组: " + "  ");
        for (int k=0; k<array.length; k++){
            System.out.print(array[k] + " ");
        }

    }

    //4.将给定的数组变成字符串
    //{34,12,65} —> “[34,12,65]”
    public static void convertString(int[] array){

        StringBuffer sbff = new StringBuffer();
        sbff.append("[");
        for (int i=0; i<array.length; i++){
            sbff.append(array[i]);
            if (i < array.length-1){
                sbff.append(",");
            }
        }
        sbff.append("]");
        System.out.println(sbff.toString());
    }


    //3.求第二大数的下标
    public static void getSecond(int[] arrayInt){
        //获取第二大的值
        int second;
        int[] array = new int[10];
        int k=0;
        for (int i=0; i<arrayInt.length; i++){
            array[k] = arrayInt[i];
            k++;
        }
        int n = array.length-1;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
        }

        second = array[array.length-2];

        //获取第二大数的下标
        for (int j = 0; j<arrayInt.length; j++){
            if (arrayInt[j] == second){
                System.out.println("第二大的数的下标为:" + j);
            }
        }
    }


    //2.计算平均分
    public static double getAvg(double[] array){
        double sum = 0.0;
        double avg=0.0;
        int n = array.length-1;
        for (int i=0; i<n; i++){
            for (int j=0; j<n-i; j++){
                if (array[j] > array[j+1]){
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
        }
        //去掉第一和最后一个,计算平均分
        for(int i=1; i<array.length-1; i++){
            sum += array[i];
        }
        avg = sum / 8;
        return avg;
    }


    //1.数组反转方法
    public static void reverseArray(int[] array){
        System.out.print("反转前的数组: " +"  ");
        for (int k=0; k<array.length; k++){
            System.out.print(array[k] + " ");
        }
        System.out.println();
        int j=0;
        for (int i=array.length-1; i>=j; i--){
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j++;
        }
        System.out.print("反转后的数组: " +"  ");
        for (int k=0; k<array.length; k++){
            System.out.print(array[k] + " ");
        }
    }
}
