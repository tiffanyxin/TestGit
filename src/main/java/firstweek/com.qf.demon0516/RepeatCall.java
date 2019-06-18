package firstweek.com.qf.demon0516;

/**
 * @author Tiffany_xin
 * @time 2019/5/16  15:17
 */
public class RepeatCall {
    public static void main(String[] args){
        //递归
        doWhat(100);

    }

    public static void doWhat(int count){
        if (count <= 0){
            return;
        }

        count--;
        System.out.println(count);

        doWhat(count);
    }
}
