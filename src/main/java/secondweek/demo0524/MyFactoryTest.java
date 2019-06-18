package secondweek.demo0524;

/**
 * @author Tiffany_xin
 * @time 2019/5/24  20:35
 */
public class MyFactoryTest {
    //工厂模式,用一个方法替代new创建对象

    public static void main(String[] args) {

      People people = MyFactory.createPeople("RED");
    }
}
