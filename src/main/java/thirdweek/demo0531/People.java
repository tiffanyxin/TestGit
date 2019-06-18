package thirdweek.demo0531;


/**
 * @author Tiffany_xin
 * @time 2019/5/31  18:53
 */
public class People implements Comparable<People>{
    private int number;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public People(int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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


    public int compareTo(People o) {
        if (this.number > o.getNumber()){
            return 1;
        }
        if (this.number == o.getNumber()){
            return 0;
        }
        if (this.number < o.getNumber()){
            return -1;
        }
        return 0;
    }
}
