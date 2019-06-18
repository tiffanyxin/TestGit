package thirdweek.demo0531;

import java.util.*;

/**
 * @author Tiffany_xin
 * @time 2019/5/31  9:36
 */
public class ObjectSortTest {
    public static void main(String[] args) {

        //sort,sublist
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(04,"dha",29));
        students.add(new Student(02,"bisiiii",30));
        students.add(new Student(01,"c五f",31));
        students.add(new Student(10,"a六ffffff",32));

        //定制排序的使用
        students.sort(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
//                if(o1.getNumber() > o2.getNumber()){
//                    return -1;
//                }
//                if(o1.getNumber() == o2.getNumber()){
//                    return 0;
//                }
//                if(o1.getNumber() < o2.getNumber()){
//                    return 1;
//                }
//                return 0;
                //Integer.compare
//                return  Integer.compare(o1.getNumber(),o2.getNumber());

                //o1.getName().compareTo
                int i = o1.getName().compareTo(o2.getName());
                if (i > 0){
                    return 1;
                }
                if (i == 0){
                    return 0;
                }
                if (i < 0){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(students);


        //<包装类,String:默认已经实现了Comparable接口>
//        List student = new ArrayList();
//        student.add(2);
//        student.add(3);
//        student.add(9);
//        student.add(1);
//        Collections.sort(student);
//        System.out.println(student);




        //自然排序
//        Set<People> peopleSet = new TreeSet<People>();
//        peopleSet.add(new People(04,"zhangsan",29));
//        peopleSet.add(new People(02,"lisi",30));
//        peopleSet.add(new People(01,"王五",31));
//        peopleSet.add(new People(10,"赵六",32));
//
//        //放入TreeSet的集合中的对象必须实现comparable接口
//        System.out.println(peopleSet);

        //通过集合工具类
//        List<People> peopleSet = new ArrayList<People>();
//        peopleSet.add(new People(04,"zhangsan",29));
//        peopleSet.add(new People(02,"lisi",30));
//        peopleSet.add(new People(01,"王五",31));
//        peopleSet.add(new People(10,"赵六",32));
//        Collections.sort(peopleSet);
//        System.out.println(peopleSet);
    }
}
