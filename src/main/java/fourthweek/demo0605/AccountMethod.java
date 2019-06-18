package fourthweek.demo0605;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  21:15
 */
public class AccountMethod {
       private int money;

    public AccountMethod(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMethod account = (AccountMethod) o;
        return money == account.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    //取款方法
    public synchronized void drawMoney(int money){
        if (this.getMoney() > money){
            this.setMoney(this.getMoney() - money);
            System.out.println("取款成功,余额为"+this.getMoney());
        }else{
            System.out.println("余额不足,取款失败!");
        }
    }
}
