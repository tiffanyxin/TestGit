package thirdweek.demo0601;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/1  15:21
 */
public class VCD implements Comparable<VCD>{

    private int id;
    private double price;
    private boolean isRent;

    public VCD(int id, double price, boolean isRent) {
        this.id = id;
        this.price = price;
        this.isRent = isRent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VCD vcd = (VCD) o;
        return id == vcd.id &&
                Double.compare(vcd.price, price) == 0 &&
                isRent == vcd.isRent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, isRent);
    }

    @Override
    public String toString() {
        return "VCD{" +
                "id=" + id +
                ", price=" + price +
                ", isRent=" + isRent +
                '}';
    }

    @Override
    public int compareTo(VCD o) {
        return Integer.compare(this.id,o.getId());
    }
}
