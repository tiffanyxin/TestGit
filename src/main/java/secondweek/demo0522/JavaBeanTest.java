package secondweek.demo0522;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  9:47
 */

//java的顶级父类Object
public class JavaBeanTest {
    private String name;
    private String sex;

    String s = "b";

    {
        System.out.println("");
    }

    static {
        System.out.println("");
    }

    //调用父类的构造器
    public JavaBeanTest() {
        super();
    }

    public JavaBeanTest(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    //指示某个其他对象是否与此对象“相等”； 返回该对象的哈希码值
    //重写equals()方法必须重写hashCode()方法
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        JavaBeanTest that = (JavaBeanTest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }

    //返回该对象的字符串表示
    @Override
    public String toString() {
        return "JavaBeanTest{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    //创建并返回此对象的一个副本
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //垃圾回收器调用此方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
