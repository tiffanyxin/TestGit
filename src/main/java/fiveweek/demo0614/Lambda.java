package fiveweek.demo0614;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tiffany_xin
 * @time 2019/6/14  19:42
 */
public class Lambda {
    public static void main(String[] args) {

        //lambda表达式
//         new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Lambda1");
//            }
//        };

        Runnable r  = ()-> System.out.println("lamda");


        //stream API结合lambda表达式使用,流式编程
        List<String> wordList = Arrays.asList("regular", "expression", "specified", "as", "a", "string", "must");
//        int countByIterator = 0;
//        for (String word: wordList) {
//            if (word.length() > 7) {
//                countByIterator++;
//            }
//        }

        long countByStream= wordList.stream().filter(w -> w.length() > 7).count();
    }
}
