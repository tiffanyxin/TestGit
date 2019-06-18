package fourthweek.demo0605;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  21:50
 */
public class Pie {
    private int count;

    public Pie(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pie pie = (Pie) o;
        return count == pie.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
