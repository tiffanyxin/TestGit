package secondweek.demo0524;

/**
 * @author Tiffany_xin
 * @time 2019/5/24  20:34
 */
public class MyFactory {

    public static People createPeople(String type){
        if ("RED".equals(type)){
            People people = new Student();
            return people;
        }
        if ("White".equals(type)){
            People people = new Teacher();
            return people;
        }
        return null;
    }
}
