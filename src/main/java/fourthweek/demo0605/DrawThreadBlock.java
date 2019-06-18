package fourthweek.demo0605;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  21:28
 */
public class DrawThreadBlock {
    public static void main(String[] args) {

        AccountBlock account = new AccountBlock(109);
        WifeDrawBlock wifeDrawBlock = new WifeDrawBlock(account,100);
        HusbandDrawBlock husbandDrawBlock = new HusbandDrawBlock(account,100);
        wifeDrawBlock.start();
        husbandDrawBlock.start();

    }
}

//丈夫
class HusbandDrawBlock extends Thread{
    private AccountBlock account;
    private int money;
    public  HusbandDrawBlock(AccountBlock account,int money){
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
            synchronized (account){
                if (account.getCash() > money){
                    account.setCash(account.getCash() - money);
                    System.out.println("husband取款成功,余额为"+ account.getCash());
                }else {
                    System.out.println("husband取款失败,余额不足,余额为"+ account.getCash());
                }
            }
    }
}


//妻子
class WifeDrawBlock extends Thread{
    private AccountBlock account;
    private int money;
    public WifeDrawBlock(AccountBlock account,int money){
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (account){
            if (account.getCash() > money){
                account.setCash(account.getCash() - money);
                System.out.println("wife取款成功,余额为"+ account.getCash());
            }else {
                System.out.println("wife取款失败,余额不足!");
            }
        }
    }
}

