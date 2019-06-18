package secondweek.demo0521;

/**
 * @author Tiffany_xin
 * @time 2019/5/21  19:33
 */
public class Melon {
    private String name;
    private String color;
    private String size;

    {
        System.out.println("欢迎品尝");
    }

    public Melon(){
        this.name="香瓜";
        System.out.println(this.name);
    }

    public Melon(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
        System.out.println(this.name);
    }

}
