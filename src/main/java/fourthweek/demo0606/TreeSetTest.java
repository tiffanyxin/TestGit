package fourthweek.demo0606;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * @author Tiffany_xin
 * @time 2019/6/6  11:26
 */
public class TreeSetTest {
    public static void main(String[] args) throws IOException {

        TreeSet treeSet = new TreeSet();
        treeSet.add(new Employee(22,34,75));
        treeSet.add(new Employee(19,84,55));
        treeSet.add(new Employee(42,34,35));
        treeSet.add(new Employee(22,34,25));
        treeSet.add(new Employee(23,14,95));
        System.out.println(treeSet);

    }
}
