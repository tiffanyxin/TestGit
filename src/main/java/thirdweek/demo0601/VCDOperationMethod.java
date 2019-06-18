package thirdweek.demo0601;

import java.util.*;

public class VCDOperationMethod {

    //根据用户的选择进行系统操作
    public static Map<String, List<Integer>> interActive(int number, List<VCD> list, Scanner scan,
                                                         Map<String,List<Integer>> rentMap,
                                                         Map<String, Integer> userMap,
                                                         List<Integer> vcdListId, String userName){

        Map<String,List<Integer>> map = new HashMap<String, List<Integer>>();
        switch (number){
            case 1:
                //添加VCD信息
                addVCD(list,scan);
                menu();
                break;
            case 2:
                //显示VCD信息
                System.out.println("VCD信息  :  "+list);
                menu();
                break;
            case 3:
                //删除VCD信息
                delete(list,scan);
                System.out.println("删除成功!");
                menu();
                break;
            case 4:
                //用户输入要修改的VCD的id号
                System.out.println("请输入要修改的VCD的id号");
                //显示当前可修改的VCD的id号
                for (VCD vcd : list){
                    System.out.print(vcd.getId() + " ");
                }
                System.out.println();
                int vcdId = scan.nextInt();
                //显示供修改的VCD字段
                updateMenu();
                System.out.println("请按数字选择选项:");
                //循环选择,除非用户选择返回上一层
                boolean updateFlag = false;
                while (!updateFlag){
                    int num = scan.nextInt();
                    //修改VCD信息
                    Boolean aBoolean = interActiveUpdateVCD(num,vcdId,scan ,list, rentMap,vcdListId,userName);
                    if (!updateFlag==aBoolean){
                        break;
                    }
                }
                System.out.println("修改成功!");
                menu();
                break;
            case 5:
                //查看VCD信息
                selectVCD(list,scan);
                menu();
                break;
            case 6:
                //排序
                listSort(list);
                System.out.println("已经排好序!");
                System.out.println(list);
                menu();
                break;
            case 7:
                //切换用户
                userName = scannerUserNameJudge(scan, userMap, userName);
                vcdListId = scannerPassWordJudge(scan, userMap, userName);
                System.out.println("登录成功!");
                menu();
                map.put(userName,vcdListId);
                return map;
            case 8:
                //租赁功能
                rentMenu();
                System.out.println("请按数字选择选项:");
                //循环选择,除非用户选择返回上一层
                boolean flag = false;
                while (!flag){
                    int num = scan.nextInt();
                    Boolean aBoolean = interActiveRent(num, list, scan, rentMap,userMap,vcdListId,userName);
                    if (!flag==aBoolean){
                        break;
                    }
                }
                menu();
                break;
            case 9:
                //退出
                System.exit(0);
                break;
            default:
                System.out.println("请输入1-9的数字选项:");
                break;
        }
        map.put(userName,vcdListId);
        return map;
    }


    //根据用户选择修改VCD信息
    public static Boolean interActiveUpdateVCD(int number,int vcdId, Scanner scan, List<VCD> list, Map<String, List<Integer>> rentMap,
                                               List<Integer> vcdListId, String userName) {
        switch (number){
            case 1:
                //修改价格
                updatePrice(scan,list,vcdId);
                updateMenu();
                break;
            case 2:
                //显示当前出租标识的值
                boolean isRent = false;
                for (VCD vcd: list){
                    if (vcd.getId() == vcdId){
                        isRent = vcd.isRent();
                        System.out.println("当前VCD的出租标识值为"+ isRent);
                        break;
                    }
                }
                //修改出租标识
                updateIsRent(scan,list,vcdId,isRent,rentMap,vcdListId,userName);
                updateMenu();
                break;
            case 3:
                //返回上一层
                return true;
            default:
                System.out.println("请输入1-3的数字选项:");
                break;
        }
        return false;
    }


    //修改VCD出租标识信息
    public static void updateIsRent(Scanner scan, List<VCD> list, int vcdId,boolean isRent,
                                    Map<String, List<Integer>> rentMap,
                                    List<Integer> vcdListId, String userName) {
        System.out.println("请输入要修改的值true或者false:");
        String next = scan.next();
        Boolean scanBoolean=false;
        try {
            //捕获输入的类型异常做处理
            scanBoolean = Boolean.valueOf(next);
        } catch (Exception e) {
            System.out.println("输入类型错误,请输入true");
        }

        //输入的值与当前的值相等则,
        if ( scanBoolean == isRent){
            System.out.println("已是当前值,不需要再修改了");
        }else {
            if(scanBoolean == true){
                //出租代码
                for (VCD vcd : list) {
                    if (vcd.getId() == vcdId) {
                        //已租VCD，那把VCD信息表中的isRent字段设置为true
                        vcd.setRent(scanBoolean);
                        vcdListId.add(vcd.getId());
                        System.out.println("修改成功");
                        break;
                    }
                }
                //把出租标识为true的VCD存入租赁信息表中
                rentMap.put(userName, vcdListId);
            }else{
                //归还代码
                for (VCD vcd:list) {
                    if (vcd.getId() == vcdId){
                        vcd.setRent(scanBoolean);
                        System.out.println("修改成功");
                        break;
                    }
                }
                //遍历租赁信息表把所有客户租了该VCD的id号删除(包含之前的客户租赁信息处理)
                for (Map.Entry<String, List<Integer>> entry : rentMap.entrySet()){
                    List<Integer> valueList = entry.getValue();
                    String nameKey = entry.getKey();
                    for (Integer id : valueList ){
                        if (id == vcdId){
                            valueList.remove(new Integer(id));
                            break;
                        }
                    }
                    rentMap.put(nameKey,valueList);
                }

            }
        }
    }


    //修改VCD价格信息
    public static void  updatePrice(Scanner scan, List<VCD> list,int vcdId) {
        System.out.println("请输入要修改的值:");
        String next = scan.next();
        double price = 0.0;
        try{
            price = Integer.valueOf(next);
        }catch (Exception e){
            System.out.println("输入的值类型错误,请重新输入:");
            return;
        }
        //遍历VCD信息表找到对应的vcdId,然后设置price的值
        for (VCD vcd : list){
            if (vcd.getId() == vcdId){
                vcd.setPrice(price);
                System.out.println("修改成功!");
                return;
            }
        }
    }


    //根据用户选择租赁功能进行系统响应
    public static Boolean interActiveRent(int number,List<VCD> list,Scanner scan, Map<String,List<Integer>> rentMap,
                                          Map<String, Integer> userMap,List<Integer> vcdListId,String userName){
        switch (number){
            case 1:
                //新增人员
                addUser(userMap,scan);
                rentMenu();
                break;
            case 2:
                //人员租赁VCD
                System.out.println("可租赁VCD的id如下，请选择id号租赁：");
                showVCD_id(list);
                int reCount=2;
                int rentReCount=2;
                rentVCD(list,scan,rentMap,vcdListId,userName,reCount,rentReCount);
                rentMenu();
                break;
            case 3:
                //人员归还VCD
                System.out.println("请输入要归还的VCD的id号：");
                int returnCount=2;
                returnVCD(list,scan,rentMap,vcdListId,userName,returnCount);
                rentMenu();
                break;
            case 4:
                //统计每个人租赁VCD的数量并打印
                totalRentPrint(rentMap);
                rentMenu();
                break;
            case 5:
                //返回上一层
                return true;
            default:
                System.out.println("请输入1-5的数字选项:");
                break;
        }
        return false;
    }



    //统计每个人租赁VCD的数量并打印
    public static void totalRentPrint(Map<String, List<Integer>> rentMap) {
        for (Map.Entry<String, List<Integer>> entry : rentMap.entrySet()){
            int count = 0;
            for (Integer id : entry.getValue() ){
                count++;
            }
            System.out.println(entry.getKey()+"租赁VCD的数量为："+ count);
        }
    }


    //人员归还VCD
    public static void returnVCD(List<VCD> list, Scanner scan, Map<String, List<Integer>> rentMap,
                                 List<Integer> vcdListId,String userName,int returnCount) {
        int vcdId = scan.nextInt();
        //判断归还的id号是否存在租赁表中
        if (vcdListId.contains(vcdId)){
            //归还VCD，设置该VCD信息的isRent字段为false
            for (VCD vcd:list) {
                if (vcd.getId() == vcdId){
                    vcd.setRent(false);
                    break;
                }
            }
            //租赁信息表删除该VCD的id号
            vcdListId.remove(new Integer(vcdId));
            rentMap.put(userName,vcdListId);
            System.out.println("您已归还成功！");
            return;
        }
        System.out.println("您并没有租赁该VCD，无法归还，请输入正确VCD的id号进行归还！");

        if(returnCount == 0){
            //设置递归跳出
            return;
        }
        returnCount--;
        returnVCD(list,scan,rentMap,vcdListId,userName,returnCount);
    }



    //人员租赁VCD
    public static void rentVCD(List<VCD> list, Scanner scan, Map<String, List<Integer>> rentMap,
                               List<Integer> vcdListId,String userName,int reCount,int rentReCount) {
        int vcdId = scan.nextInt();
        //判断输入的id是否已被当前用户租了
        if (!vcdListId.contains(vcdId)){
            //当前用户没租该VCD
            //判断输入的id是否存在
            int count=0;
            for (VCD vcd:list){
                if(vcd.getId() == vcdId){
                    count++;
                    //这里id都是唯一，所以相等就跳出循环，没必要继续比较了
                    break;
                }
            }
            if (count==0){
                System.out.println("您输入的id不存在，请重新安照id表输入：");
                //输入的id不存在，重复输入控制三次
                if (rentReCount == 0){
                    //跳出递归
                    return;
                }
                rentReCount--;
                rentVCD(list,scan,rentMap,vcdListId,userName,count,rentReCount);
                //跳出递归后,结束方法并返回
                return;
            }
            //count不等于0，id存在往下走
            for (VCD vcd:list) {
                if (vcd.getId() == vcdId){
                    //保证该VCD没有被其它用户租，通过isRent字段判断
                    if (!vcd.isRent()){
                        //已租VCD，那把VCD信息表中的isRent字段设置为true
                        vcd.setRent(true);
                        vcdListId.add(vcd.getId());
                        break;
                    }
                    System.out.println("该VCD已被其它用户租走，请重新选择！");
                    return;
                }
            }
            //把要租的VCD的id信息存入租赁信息表中
            rentMap.put(userName,vcdListId);
            System.out.println("租赁的信息如下：");
            for (Map.Entry<String, List<Integer>> entry : rentMap.entrySet()){
                //只打印当前用户的租赁信息
                if (entry.getKey() == userName){
                    System.out.print(entry.getKey() + "租赁VCD成功，VCD的id号为:"+ entry.getValue() + "  ");
                    System.out.println();
                    break;
                }
            }
            return;
        }
        System.out.println("你已经租赁该VCD，不能重复租，请选择其它VCD！");
        //已租VCD，重复输入控制三次
        if (reCount==0){
            return;
        }
        reCount--;
        rentVCD(list,scan,rentMap,vcdListId,userName,reCount,rentReCount);
    }


    //租赁VCD前显示所有的VCD信息供用户选择
    public static void showVCD_id(List<VCD> list) {
        for (VCD vcd:list){
            System.out.print(vcd.getId() + " ");
        }
        System.out.println();
    }



    //新增人员
    public static void addUser(Map<String, Integer> userMap,Scanner scan) {
        System.out.println("请输入要新增的用户名:");
        String userName = scan.next();
        System.out.println("请输入新增用户名的密码：");
        int userPassword = scan.nextInt();

        userMap.put(userName,userPassword);
        System.out.println("新增人员成功，现有用户：");
        //并显示用户名
        for (String key : userMap.keySet()){
            System.out.print(key + " ");
        }
        System.out.println();
    }



    //排序
    public static void listSort(List<VCD> list) {
         Collections.sort(list);
    }


    //查看VCD信息
    public static void selectVCD(List<VCD> list,Scanner scan) {
        System.out.println("请输入要查看的VCD编号:");
        int num = scan.nextInt();
        Iterator<VCD> iterator = list.iterator();
        while (iterator.hasNext()){
            VCD next = iterator.next();
            if (next.getId()==num){
                System.out.println(next);
            }
        }
    }



    //删除VCD信息
    public static void delete(List<VCD> list,Scanner scan) {
        System.out.println("请输入要删除的VCD编号:");
        int id = scan.nextInt();
        Iterator<VCD> iterator = list.iterator();
        while (iterator.hasNext()){
            VCD next = iterator.next();
            if (next.getId()==id){
                iterator.remove();
            }
        }
    }


    //添加VCD信息,根据id去重
    public static void addVCD(List<VCD> list,Scanner scan) {
        System.out.println("请输入要添加的VCD信息,编号和价格");
        int id = scan.nextInt();
        int price = scan.nextInt();
        for(VCD vcd : list){
            if (vcd.getId() == id){
                System.out.println("VCD已存在,请重新添加!");
                return;
            }
        }
        list.add(new VCD(id,price,false));
        System.out.println("添加成功!");
    }


    //租赁菜单
    public static void rentMenu(){
        System.out.println("租赁功能选项:");
        System.out.println("  "+"1.新增人员");
        System.out.println("  "+"2.人员租赁VCD");
        System.out.println("  "+"3.人员归还VCD");
        System.out.println("  "+"4.统计每个人租赁VCD的数量并打印");
        System.out.println("  "+"5.返回上一层");
    }


    //修改菜单
    public static void updateMenu(){
        System.out.println("修改VCD信息选项:");
        System.out.println("  "+"1.价格");
        System.out.println("  "+"2.出租标识");
        System.out.println("  "+"3.返回上一层");
    }


    //菜单
    public static void menu(){
        System.out.println("菜单信息如下:");
        System.out.println("  "+"1.添加VCD信息");
        System.out.println("  "+"2.显示VCD信息");
        System.out.println("  "+"3.删除VCD信息");
        System.out.println("  "+"4.修改VCD信息");
        System.out.println("  "+"5.查看VCD信息");
        System.out.println("  "+"6.排序");
        System.out.println("  "+"7.切换用户");
        System.out.println("  "+"8.租赁功能");
        System.out.println("  "+"9.退出");
    }


    //用户名正确，判断密码,最多输入三次后系统自动退出
    public static List<Integer> scannerPassWordJudge(Scanner scanner, Map<String, Integer> userMap, String userName) {
        for (int i=0; i<3; i++){
            boolean  flagBoolean = passWordJudge(scanner, userMap,userName);
            if (flagBoolean){
                break;
            }
            if (i==2){
                System.exit(0);
            }
        }
        return new ArrayList<Integer>();
    }


    //用户名正确才会往下走,最多输入三次系统自动退出
    public static String scannerUserNameJudge(Scanner scanner, Map<String, Integer> userMap, String userName) {
        for (int i=0; i<3; i++){
            String  flagString = userNameJudge(scanner, userMap);
            String[] split = flagString.split(",");
            userName = split[1];
            if (Boolean.valueOf(split[0])){
                break;
            }
            if (i==2){
                System.exit(0);
            }
        }
        return userName;
    }


    //密码判断
    public static Boolean passWordJudge(Scanner scan,Map<String, Integer> userMap,String userName){
        boolean flag = false;
        int passWord=0;
        System.out.println("请输入密码:");
        try{
            //输入字母类型转换异常报错处理
             passWord = Integer.valueOf(scan.next());
        }catch (Exception e){
            System.out.println("输入的密码有误，请输入数字密码！！！");
            return flag;
        }

        //密码不正确返回false
        if (userMap.get(userName) != passWord){
            System.out.println("密码有误，请重新输入!");
            return flag;
        }
        //密码正确返回true
        return !flag;
    }


    //用户名判断
    public static String userNameJudge(Scanner scan,Map<String, Integer> userMap){
        boolean flag = false;
        System.out.println("请输入用户名:");
        String nameScan = scan.next();
        //用户名不正确返回false
        if (!userMap.containsKey(nameScan)){
            System.out.println("输入用户名有误!");
            return flag +","+ nameScan;
        }
        //用户名正确返回true
        return !flag +","+ nameScan;
    }
}

