package fiveweek.demo0614;

import java.io.*;
import java.util.*;

public class UtilsTest {
    public static void main(String[] args) throws Exception {

        TreeMap map = new TreeMap(new OrderComparator());

        map.put(new Order(10),"sdfs");
        map.put(new Order(19),"sdfs");
        map.put(new Order(5),"sdfs");

        System.out.println(map);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
        oos.writeObject(map);

    }

    private static class OrderComparator implements Comparator<Order>,Serializable {
        private static final long serialVersionUID = 5609003949865444669L;

        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}