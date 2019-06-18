package fourthweek.demo0605;


import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  21:28
 */
public class AccountBlock {
    private int cash;

    public AccountBlock(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBlock that = (AccountBlock) o;
        return cash == that.cash;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cash);
    }
}
