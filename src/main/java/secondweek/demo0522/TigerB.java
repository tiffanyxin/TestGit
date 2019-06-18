package secondweek.demo0522;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:16
 */
public class TigerB extends Tiger {
    private int age;

    @Override
    public int getAge(){
       return age;
    }

    @Override
    public void setAge(int age) {
        if ( age>=0 && age<=50){
            this.age = age;
            return;
        }
    }
}
