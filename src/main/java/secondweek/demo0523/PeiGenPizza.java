package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/23  21:59
 */
public class PeiGenPizza extends Pizza {

    public PeiGenPizza(String name, double price, int size) {
        super(name, price, size);
    }

    @Override
    public void show() {
        System.out.println("Ok,Wait a minute,PeiGenPizza will come!");
    }
}
