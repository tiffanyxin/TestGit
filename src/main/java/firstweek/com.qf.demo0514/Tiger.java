package firstweek.com.qf.demo0514;

/**
 * @author Tiffany_xin
 * @time 2019/5/21  19:52
 */

public class Tiger {
    private String name;
    private String color;
    private int weight;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if ( age>=0 && age<=50){
            this.age = age;
            return;
        }
    }

    public void eat(){
        System.out.println("吃东西");
    }
    public void run(){
        System.out.println("跑起来");
    }
    public void drink(){
        System.out.println("喝水");
    }
}
