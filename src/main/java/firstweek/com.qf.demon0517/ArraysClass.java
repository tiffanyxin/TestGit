package firstweek.com.qf.demon0517;

import java.util.Arrays;

/**
 * @author Tiffany_xin
 * @time 2019/5/17  20:20
 */
public class ArraysClass {
    public static void main(String[] args) {
        int[] array = {2,3,543,78,3,5,4,21,3,7};
//        Arrays.sort(array);
//        for (int i=0; i<array.length; i++){
//            System.out.print(array[i]+" ");
//        }
        int[] b = Arrays.copyOf(array,10);
        for (int i=0; i<b.length; i++){
            System.out.print(b[i]+" ");
        }

        Arrays.fill(b,100);
        for (int i=0; i<b.length; i++){
            System.out.print(b[i]+" ");
        }

    }
}
