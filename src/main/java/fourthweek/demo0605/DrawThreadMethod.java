package fourthweek.demo0605;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  21:13
 */
public class DrawThreadMethod {
    public static void main(String[] args) {
        AccountMethod account = new AccountMethod(101);
        WifeDraw wifeDraw = new WifeDraw(account);
        HusbandDraw husbandDraw = new HusbandDraw(account);
        wifeDraw.start();
        husbandDraw.start();

    }
}

//丈夫
class HusbandDraw extends Thread{
    private AccountMethod account;
    public  HusbandDraw(AccountMethod account){
        this.account = account;
    }
    @Override
    public void run() {
        account.drawMoney(100);
    }
}


//妻子
class WifeDraw extends Thread{
    private AccountMethod account;
    public  WifeDraw(AccountMethod account){
        this.account = account;
    }
    @Override
    public void run() {
        account.drawMoney(100);
    }
}

