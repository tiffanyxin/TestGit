package secondweek.demo0522;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:50
 */
public class AtiVideoCard extends VideoCard{
    private String brand;
    private double price;
    private double resolutionRatio;

    public AtiVideoCard(String brand, double price, double resolutionRatio) {
        this.brand = brand;
        this.price = price;
        this.resolutionRatio = resolutionRatio;
    }

    @Override
    public String toString() {
        return "AtiVideoCard{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", resolutionRatio=" + resolutionRatio +
                '}';
    }
}
