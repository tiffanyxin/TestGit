package firstweek.com.qf.demon0517;

/**
 * @author Tiffany_xin
 * @time 2019/5/17  9:51
 */
public class ArraysSort {

    public static void main(String[] args) {
        int[] array = {2,3,543,78,3,5,4,21,3,7};

        //选择排序
//        selectSort(array);

        System.out.println();

        //冒泡
         int[] arraySort = bubble(array);

        System.out.println();
        System.out.println();


        //二分查找
//        int[] arrayS = {78,22,11,9,7,5,3,1};
//        int[] arrayS = {1,2,3,4,5,6,7,8,9,10};
        int find = 543;
        binarySearch(arraySort,find);

       //插入排序
        int[] insertArray = {1,2,3,4};
//        insertSort(insertArray);

    }


    //插入排序
    public static void insertSort(int[] array){
        for (int i=1; i<array.length; i++){
            for (int j=0; j<i; j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int k=0; k<array.length; k++){
            System.out.print(array[k] + " ");
        }
    }

    //选择排序(提示:每一次遍历找下最大值,并把最大值放在最右边)
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

    //二分查找
    public static void binarySearch(int[] arraySort,int find){
        int start=0;
        int end=arraySort.length-1;
        int middle;
        boolean flag = false;
        while (start<=end){
            middle = (start+end)/2;
            if (find == arraySort[middle]){
                System.out.println("找到了,下标值为: " + middle);
                flag = true;
                break;
            }else if(find >arraySort[middle]){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        if (!flag){
            System.out.println("没有找到");
        }

    }

    //冒泡排序
    public static int[] bubble(int[] array) {
        //冒泡
        int length = array.length-1;

        for (int i=0; i<length; i++){
            for (int j=0; j<length-i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;           //写错变量
                }

            }
        }
        for (int k = 0; k<array.length; k++){
            System.out.print(array[k]+ "\t");
        }

        return array;
    }
}
