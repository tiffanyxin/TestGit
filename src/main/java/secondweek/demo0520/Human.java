package secondweek.demo0520;

/**
 * @author Tiffany_xin
 * @time 2019/5/20  19:35
 */
public class Human {
    private String hname;
    private int hage;
    private boolean isRichSecondGeneration;
    private String car;

    public Human(String h_name, int h_age, boolean isRichSecondGeneration, String car) {
        this.hname = h_name;
        this.hage = h_age;
        this.isRichSecondGeneration = isRichSecondGeneration;
        this.car = car;
    }

    public void introduceBMW(){
        BMW bmw = new BMW("four","white","BMW");
        System.out.println(hname + "开着" + car + ",很自豪地向女友介绍起来!");
        System.out.println("This is a " + bmw.getDoorCount() + "-door " + bmw.getColor() +" " + bmw.getBrand()+ "!");
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public int getHage() {
        return hage;
    }

    public void setHage(int hage) {
        this.hage = hage;
    }

    public boolean isRichSecondGeneration() {
        return isRichSecondGeneration;
    }

    public void setRichSecondGeneration(boolean richSecondGeneration) {
        isRichSecondGeneration = richSecondGeneration;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
