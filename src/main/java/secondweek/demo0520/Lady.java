package secondweek.demo0520;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  18:55
 */
public class Lady {

    private String lname;

    public Lady(String l_name) {
        this.lname = l_name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    //购买宠物狗
    public void purchasePetDog(){
        System.out.println("Lady has purchased a pet dog!");
    }
    //购买宠物猫
    public void purchasePetCat(){
        System.out.println("Lady has purchased a pet cat!");
    }
    //举行聚会
    public void holdCelebrate(){
        System.out.println("Lady will hold a party!");
    }
    //介绍宠物猫
    public void introducePetCat(){
        System.out.println("Lady will introduce a pet cat!");
    }
    //介绍宠物狗
    public void introducePetDog(){
        System.out.println("Lady will introduce a pet dog!");
    }
}
