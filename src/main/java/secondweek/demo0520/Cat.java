package secondweek.demo0520;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  19:17
 */
public class Cat {
    private String cname;
    private String csex;
    private int cage;
    private String ccategory;

    public Cat(){
        this("Tom","female",6,"Bob");
        System.out.println("nininininininii");
    }

    public Cat(String c_name, String c_sex, int c_age, String c_category) {
        this.cname = c_name;
        this.csex = c_sex;
        this.cage = c_age;
        this.ccategory = c_category;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCcategory() {
        return ccategory;
    }

    public void setCcategory(String ccategory) {
        this.ccategory = ccategory;
    }

    //捉老鼠
    public void scratchMouse(){
        System.out.println("This cat will scratch mouse!");
    }
    //吃鱼
    public void eatFish(){
        System.out.println("This cat will eat lots of fish!");
    }
}
