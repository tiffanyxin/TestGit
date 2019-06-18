package secondweek.demo0521;

/**
 * @author Tiffany_xin
 * @time 2019/5/21  19:14
// */
public class MobilePhone {
    private String brand;
    private String color;
    private String size;

    public MobilePhone() {
        this("苹果");
    }

    public MobilePhone(String brand) {
        this(brand,"黄色");
    }

    public MobilePhone(String brand, String color) {
        this(brand,color,"6寸");
    }

    public MobilePhone(String brand, String color, String size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public void show(){
        System.out.print("手机的品牌是:"+ brand+" | ");
        System.out.print("手机的颜色是:"+ color+" | ");
        System.out.println("手机的大小是:"+ size);
    }
}
//public class MobilePhone {
//     private static String brand="苹果";
//     private static String color="黄色";
//     private static String size="6寸";
//
//    public MobilePhone() {
//        this(brand);
//    }
//
//    public MobilePhone(String brand) {
//        this(brand,color);
//    }
//
//    public MobilePhone(String brand, String color) {
//        this(brand,color,size);
//    }
//
//    public MobilePhone(String brand, String color, String size) {
//        MobilePhone.brand = brand;
//        MobilePhone.color = color;
//        MobilePhone.size = size;
//    }
//
//    public void show(){
//        System.out.print("手机的品牌是:"+ brand+" | ");
//        System.out.print("手机的颜色是:"+ color+" | ");
//        System.out.println("手机的大小是:"+ size);
//    }
//}
//
