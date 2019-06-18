package fiveweek.demo0614;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/15  15:16
 */
public class Order implements Serializable{
    private static final long serialVersionUID = 9023805833535581745L;
    private int age;


    public Order(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Order{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return age == order.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
