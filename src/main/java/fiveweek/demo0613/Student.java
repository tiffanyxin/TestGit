package fiveweek.demo0613;

/**
 * @author Tiffany_xin
 * @time 2019/6/13  15:00
 */
public class Student{
    private String name;
    private int age ;

    public Student(){
        System.out.println("这里是无参构造函数");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("这里是有参构造函数");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
