package fourthweek.demo0606;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/6/6  16:32
 */
public class Employee implements Comparable<Employee> {

    private int age;
    private int workTime;
    private int salary;

    public Employee(int age, int workTime, int salary) {
        this.age = age;
        this.workTime = workTime;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        //等于当前对象,不用比了,直接return true
        if (this == o) return true;
        //如果不是对象,或者两个对象的类不相同,直接return false
        if (o == null || getClass() != o.getClass()) return false;
        //转换成当前类型,比较字段大小,int 用==, String类用equals
        Employee employee = (Employee) o;
        return age == employee.age &&
                workTime == employee.workTime &&
                salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, workTime, salary);
    }

    @Override
    public int compareTo(Employee o) {
        int a = Integer.compare(this.age,o.getAge());
        if (a==0){
            int b = Integer.compare(this.workTime,o.getWorkTime());
            if (b == 0){
                return Integer.compare(this.salary,o.getSalary());
            }
            return b;
        }
        return a;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", workTime=" + workTime +
                ", salary=" + salary +
                '}';
    }
}
