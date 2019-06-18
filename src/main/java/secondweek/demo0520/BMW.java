package secondweek.demo0520;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  19:32
 */
public class BMW {
    private String doorCount;
    private String color;
    private String brand;

    public BMW(String doorCount, String color, String brand) {
        this.doorCount = doorCount;
        this.color = color;
        this.brand = brand;
    }

    public String getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(String doorCount) {
        this.doorCount = doorCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
