package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/23  21:55
 */
public abstract class Pizza {
    private String name ;
    private double price;
    private int size;

    public Pizza(String name, double price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public abstract void show();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
