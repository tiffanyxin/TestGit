package thirdweek.demo0530;

import java.util.*;

/**
 * @author Tiffany_xin
 * @time 2019/5/30  20:58
 */
public class HomeWork {
    public static void main(String[] args) {
        //第一题
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = reverseOrder(array);
        for (Integer integer:list){
            System.out.print(integer + " ");
        }


        System.out.println();
        //第二题
//        List<String> stringList = new ArrayList<String>();
        List<String> stringList = Arrays.asList("a","ab","ac","ad","aa","a","ad","adf","aa","add");
        System.out.println("总共包含字符a:"+ wordNumber(stringList, 'a') + "个");


        //第三题
        List<Student> studentLists = new ArrayList<Student>();
        studentLists.add(new Student("张三",3,99));
        studentLists.add(new Student("李四",3,90));
        studentLists.add(new Student("王五",3,68));
        studentLists.add(new Student("赵六",3,78));
        studentLists.add(new Student("乔七",3,88));

        for (Student studentList:studentLists){
            System.out.println(studentList);
        }

        System.out.println(studentLists.contains(new Student("乔七", 3, 99)));


        //第四题
        List<Integer> listRandoms = new ArrayList<Integer>();
        Random random = new Random();
        int sum=0;
        //存20个随机数到list集合中
        for (int i=0; i<20; i++){
            listRandoms.add(random.nextInt(21) + 10);
        }
        //遍历list求各元素之和
        for (Integer listRandom:listRandoms){
            sum+=listRandom;
        }
        System.out.println(sum);

    }



    //第二题
    public static int wordNumber(List<String> stringList, char a) {
        int sum=0;
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            String nextString = iterator.next();
            for (int i=0; i<nextString.length(); i++){
                if (nextString.charAt(i) == a){
                    sum++;
                }
            }
        }
        return sum;
    }


    //第一题
    public static List<Integer> reverseOrder(int[] array){
        List<Integer> list = new ArrayList<Integer>();
        for (int i=array.length-1; i>=0; i--){
            list.add(array[i]);
        }
        return list;
    }


}
