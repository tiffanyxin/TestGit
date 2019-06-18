package secondweek.demo0523;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:37
 */
public class ProgrammerTest {
    private String name;

    public static void main(String[] args) {
        Computer computer = new Computer("苹果",9999,new GeforceVideoCard("gefGraph",350,1600));
        ProgrammerTest programmerTest = new ProgrammerTest();

        //购买电脑
        programmerTest.buyComputer(computer);
        //使用电脑
        programmerTest.useComputer(computer);
        //换Geforce类型的独立显卡
        programmerTest.changeGefVideoCard(computer);
        programmerTest.useComputer(computer);
        //换Ati类型的独立显卡
        programmerTest.changeAtiVideoCard(computer);
        programmerTest.useComputer(computer);
    }

    //购买电脑
    public void buyComputer(Computer computer){
        System.out.println("购买的电脑的参数为 : " + computer.toString());
}

    //使用电脑
    public void useComputer(Computer computer){
        computer.runProgram();
    }

    //换Geforce类型的独立显卡
    public void changeGefVideoCard(Computer computer){
        computer.setVideoCard(new GeforceVideoCard("gefGraph",350,1600));
        System.out.println("更换为Geforce类型的独立显卡后电脑参数为:" + computer.toString());
    }

    //换Ati类型的独立显卡
    public void changeAtiVideoCard(Computer computer){
        computer.setVideoCard(new AtiVideoCard("atiGraph",300,1200));
        System.out.println("更换为Geforce类型的独立显卡后电脑参数为:" + computer.toString());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
