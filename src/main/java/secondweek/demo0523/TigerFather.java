package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/21  19:41
 */
public abstract class TigerFather implements Run{
    private String name;
    private String color;
    private int weight;
    private int age;

    public  void setWeight(int weight){
        if (weight <= 1000 && weight>=1){
            this.weight = weight;
            return;
        }
    }
    public  void setAge(int age){
        if (age >= 0 && age <= 50){
            this.age = age;
            return;
        }
    }

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


    public int getAge() {
        return age;
    }


    public void eat(){
        System.out.println("吃东西");
    }

    public void drink(){
        System.out.println("喝水");
    }
}
