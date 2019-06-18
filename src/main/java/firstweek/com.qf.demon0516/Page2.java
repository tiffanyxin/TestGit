package firstweek.com.qf.demon0516;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tiffany_xin
 * @time 2019/5/16  20:03
 * <p>
 * 最大值相同的话,会输出两个
 */
public class Page2 {
    public static void main(String[] args) {
        //求数组中的最大值并输出数组下标值
        int[] maxArray = {1, 9, 9, 6, 4, 2, 4, 21, 6, 84};

        int max = 0;
        for (int i = 0; i < maxArray.length; i++) {
            if (maxArray[i] > max) {
                max = maxArray[i];
            }
        }

        List index = new ArrayList();

        for (int i = 0; i < maxArray.length; i++) {
                    if (maxArray[i] == max) {
                    index.add(i);
                }
        }
        System.out.println("数组最大值为:" + max);

//        for (Integer din: index) {
//            System.out.println("最大值的下标为:" + din);
////        }

//        Iterator<Integer> iterator = index.iterator();
//        while (iterator.hasNext()){
//            int din = iterator.next();
//            System.out.println("最大值的下标为:" + din);
//        }

        for (int i=0; i<index.size(); i++){
            System.out.println("最大值的下标为:" + index.get(i));
        }
    }
}
