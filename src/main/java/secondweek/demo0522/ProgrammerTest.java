package secondweek.demo0522;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:37
 */
public class ProgrammerTest {
    private String name;

    public static void main(String[] args) {
        Computer cp = new Computer("苹果",9999,new GeforceVideoCard("gefGraph",350,1600));
        ProgrammerTest pt = new ProgrammerTest();

        //购买电脑
        pt.buyComputer(cp);
        //使用电脑
        pt.useComputer(cp);
        //换Geforce类型的独立显卡
        pt.changeGefVideoCard(cp);
        pt.useComputer(cp);
        //换Ati类型的独立显卡
        pt.changeAtiVideoCard(cp);
        pt.useComputer(cp);
    }

    //购买电脑
    public void buyComputer(Computer cp){
        System.out.println("购买的电脑的参数为 : " + cp.toString());
}

    //使用电脑
    public void useComputer(Computer cp){
        cp.runProgram();
    }

    //换Geforce类型的独立显卡
    public void changeGefVideoCard(Computer cp){
        cp.setVideoCard(new GeforceVideoCard("gefGraph",350,1600));
        System.out.println("更换为Geforce类型的独立显卡后电脑参数为:" + cp.toString());
    }

    //换Ati类型的独立显卡
    public void changeAtiVideoCard(Computer cp){
        cp.setVideoCard(new AtiVideoCard("atiGraph",300,1200));
        System.out.println("更换为Geforce类型的独立显卡后电脑参数为:" + cp.toString());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
