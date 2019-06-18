package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/23  9:50
 */
public abstract class VideoCard {
    private String brand;
    private double price;
    private double resolutionRatio;

    @Override
    public String toString() {
        return "VideoCard{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", resolutionRatio=" + resolutionRatio +
                '}';
    }

    //渲染图形
    public abstract void renderGraphics();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getResolutionRatio() {
        return resolutionRatio;
    }

    public void setResolutionRatio(double resolutionRatio) {
        this.resolutionRatio = resolutionRatio;
    }
}
