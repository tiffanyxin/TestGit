package thirdweek.demo0601;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Tiffany_xin
 * @time 2019/6/1  13:51
 */
public class StreamTest {
    @Test
    public void test(){
        List<String> wordList = Arrays.asList("regular", "expression", "specified", "as", "a", "string", "must");
//        int countByIterator = 0;
//        for (String word: wordList) {
//            if (word.length() > 7) {
//                countByIterator++;
//            }
//        }
//        System.out.println(countByIterator);

//        System.out.println(wordList.stream().filter(word -> word.length() > 7).count());

        //stream很容易实现并发操作
        System.out.println(wordList.parallelStream().filter(word -> word.length() > 7).count());


    }


}
