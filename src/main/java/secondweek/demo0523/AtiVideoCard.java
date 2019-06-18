package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:50
 */
public class AtiVideoCard extends VideoCard {
    private String brand;
    private double price;
    private double resolutionRatio;

    public AtiVideoCard(String brand, double price, double resolutionRatio) {
        this.brand = brand;
        this.price = price;
        this.resolutionRatio = resolutionRatio;
    }

    @Override
    public void renderGraphics() {
        System.out.println("AtiVideoCard 显卡的渲染图形!");
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
