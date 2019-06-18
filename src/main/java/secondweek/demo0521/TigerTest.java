package secondweek.demo0521;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiffany_xin
 * @time 2019/5/21  19:59
 */
public class TigerTest {
    private TigerTest(){
        System.out.println("");
    }

    public static void main(String[] args) {
        show();
    }

    public static void show(){
        Tiger tiger1 = new Tiger();
        Tiger tiger2 = new Tiger();
        tiger1.setAge(15);
        tiger1.setName("兰博");
        tiger1.setWeight(100);
        tiger1.setColor("黄色");

        tiger2.setAge(50);
        tiger2.setName("基尼");
        tiger2.setWeight(200);
        tiger2.setColor("棕色");

        List<List> attrs = new ArrayList<List>();
        List attrs1 = new ArrayList();
        List attrs2 = new ArrayList();

        attrs1.add(tiger1.getName());
        attrs1.add(tiger1.getWeight());
        attrs1.add(tiger1.getColor());

        attrs2.add(tiger2.getName());
        attrs2.add(tiger2.getWeight());
        attrs2.add(tiger2.getColor());

        attrs.add(attrs1);
        attrs.add(attrs2);

        StringBuilder sd = new StringBuilder();
        for (List attr:attrs){
            sd.append("{");
            sd.append("老虎:名称='" + attr.get(0)+"',");
            sd.append("体重="+ attr.get(1)+",");
            sd.append("颜色='"+ attr.get(2)+"'");
            sd.append("}");
            sd.append("  ");
        }
        System.out.println(sd.toString());

    }
}
