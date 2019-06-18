package secondweek.demo0521;

import firstweek.com.qf.demo0514.PublicKeyword;

/**
 * @author Tiffany_xin
 * @time 2019/5/21  21:37
 */
public class DefaultKeywordsTest {
    private DefaultKeywordsTest(){
        System.out.println("");
    }

    public static void main(String[] args) {
        PublicKeyword pk = new PublicKeyword();
        System.out.println(pk.name);

        DefaultKeyword dk = new DefaultKeyword();
        System.out.println(dk.name);
        System.out.println(dk.getAge());
    }
}
