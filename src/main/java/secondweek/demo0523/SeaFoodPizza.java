package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/23  22:00
 */
public class SeaFoodPizza extends Pizza {
    
    public SeaFoodPizza(String name, double price, int size) {
        super(name, price, size);
    }

    @Override
    public void show() {
        System.out.println("Ok,Wait a minute,SeaFoodPizza will come!");
    }
}
