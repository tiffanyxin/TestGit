package secondweek.demo0523;

import java.util.Scanner;

/**
 * @author Tiffany_xin
 * @time 2019/5/23  22:01
 */
public class PizzaTest {
    public static void main(String[] args) {
        System.out.println("请输入需要制作的披萨: ");
        System.out.println("培根披萨 或者 海鲜披萨. ");

        Scanner scanner = new Scanner(System.in);
        String pizza = scanner.next();

        if("培根披萨".equals(pizza)){
            Pizza peiGenPizza = new PeiGenPizza("培根披萨",998,14);
            peiGenPizza.show();
            System.out.println("这"+ peiGenPizza.getName() + "的价格为:" + peiGenPizza.getPrice()+",大小为:" + peiGenPizza.getSize()+"寸");
            return;
        }
        if("海鲜披萨".equals(pizza)){
            Pizza seaFoodPizza = new SeaFoodPizza("海鲜披萨",1998,16);
            seaFoodPizza.show();
            System.out.println("这" + seaFoodPizza.getName() + "的价格为:" + seaFoodPizza.getPrice() + ",大小为:" + seaFoodPizza.getSize() + "寸");
            return;
        }

        System.out.println("你的输入有误,请重新输入!");


    }
}
