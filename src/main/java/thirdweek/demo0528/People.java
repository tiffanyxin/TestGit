package thirdweek.demo0528;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/5/28  21:55
 */
public class People {
    private int age;
    private String name;

    public People(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
