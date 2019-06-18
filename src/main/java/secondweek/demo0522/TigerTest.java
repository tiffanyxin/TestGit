package secondweek.demo0522;

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
        TigerA tigerA = new TigerA();
        TigerB tigerB = new TigerB();
        tigerA.setAge(15);
        tigerA.setName("兰博");
        tigerA.setWeight(100);
        tigerA.setColor("黄色");

        tigerB.setAge(50);
        tigerB.setName("基尼");
        tigerB.setWeight(200);
        tigerB.setColor("棕色");

        List<List> attrs = new ArrayList<List>();
        List attrs1 = new ArrayList();
        List attrs2 = new ArrayList();

        attrs1.add(tigerA.getName());
        attrs1.add(tigerA.getWeight());
        attrs1.add(tigerA.getColor());

        attrs2.add(tigerB.getName());
        attrs2.add(tigerB.getWeight());
        attrs2.add(tigerB.getColor());

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
