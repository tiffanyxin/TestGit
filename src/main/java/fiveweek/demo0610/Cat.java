package fiveweek.demo0610;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/11  9:25
 */
public class Cat implements Serializable {
    private int age;
    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(int age) {
        this.age = age;
    }
}
