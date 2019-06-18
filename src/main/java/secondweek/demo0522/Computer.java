package secondweek.demo0522;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:43
 */
public class Computer {
    private String brand;
    private double price;
    private VideoCard VideoCard;

    public Computer(String brand, double price,VideoCard VideoCard) {
        this.brand = brand;
        this.price = price;
        this.VideoCard = VideoCard;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", VideoCard=" + VideoCard.toString() +
                '}';
    }

    //运行程序
    public void runProgram(){
        System.out.println("使用电脑:  run a program|  " + "PlayGame|  " + "take a movie");
    }

    //运行游戏
    public void playGame(){
        System.out.println("run a playGame!!!");
    }

    //播放视频
    public void takeAMovie (){
        System.out.println("take a movie!!!");
    }

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

    public VideoCard getVideoCard() {
        return VideoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        VideoCard = videoCard;
    }
}
