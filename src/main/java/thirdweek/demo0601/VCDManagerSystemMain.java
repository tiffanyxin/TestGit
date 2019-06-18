package thirdweek.demo0601;

import java.util.*;
import static thirdweek.demo0601.VCDOperationMethod.*;

/**
 * @author Tiffany_xin
 * @time 2019/6/1  14:46
 */
public class VCDManagerSystemMain {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        //用户信息
        Map<String, Integer> userMap = new HashMap<String, Integer>();
        userMap.put("张三", 123);
        userMap.put("李四", 456);
        userMap.put("王五", 789);

        //VCD
        List<VCD> list = new ArrayList<VCD>();
        list.add(new VCD(01, 11, false));
        list.add(new VCD(03, 13, false));
        list.add(new VCD(02, 12, false));


        //人员租赁信息表
        Map<String, List<Integer>> rentMap = new HashMap<String, List<Integer>>();


        //用户名正确才会往下走,最多输入三次系统自动退出
        String userName = null;
        userName = scannerUserNameJudge(scanner, userMap, userName);

        //用户名正确，判断密码,最多输入三次后系统自动退出
        List<Integer> vcdListId;
        vcdListId = scannerPassWordJudge(scanner, userMap, userName);

        System.out.println("登录成功!");
        //输出菜单
        menu();
        //请选择功能
        System.out.println("请按数字选择相应的功能:");

        //一直循环,除非用户选择退出
        while (true) {
            int number = scanner.nextInt();
            //每次都返回由当前用户名和当前用户租赁的vcdListId构成的Map， 确保可以进行用户切换！
            Map<String, List<Integer>> stringAndListMap = interActive(number, list, scanner, rentMap, userMap, vcdListId, userName);
            for (Map.Entry<String, List<Integer>> stringAndList : stringAndListMap.entrySet()) {
                userName = stringAndList.getKey();
                vcdListId = stringAndList.getValue();
            }
        }
    }
}

