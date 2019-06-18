package firstweek.com.qf.demon0518;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiffany_xin
 * @time 2019/5/18  12:51
 */

/**
 * 定义一颗树(name,s_id,p_id)
 * 方法体输入(List<TreeNodes> ,int pid), 遍历List集合的TreeNodes是否等于父节点,不等于什么不用做
 *       里面递归有点乱(关键思路是,a.走一遍过,更深层次的先不考虑!  b.考虑两种情况单层和多层情况!)
 * 测试类()
 */
public class TreeNodeMain {
    //Java利用递归实现查找树的节点的所有子节点和所有的终结节点(这里就不去重了,求得所有节点然后写个去重方法即可)

    //用于存放所有的子节点和终结点
    //执行函数treeMenuList后childNode和lastChildNode都会存在重复值，因此需要去重处理
    static List<TreeNodes> childNode = new ArrayList<TreeNodes>();
    static List<TreeNodes> lastChildNode = new  ArrayList<TreeNodes>();


    public static void main(String[] args) {


        List<TreeNodes>  treeNodes = new  ArrayList<TreeNodes>();

        treeNodes.add(new TreeNodes(1,0));
        treeNodes.add(new TreeNodes(2,0));
        treeNodes.add(new TreeNodes(3,0));

        treeNodes.add(new TreeNodes(4,1));
        treeNodes.add(new TreeNodes(5,1));

        treeNodes.add(new TreeNodes(6,2));
        treeNodes.add(new TreeNodes(7,2));

        treeNodes.add(new TreeNodes(8,3));
        treeNodes.add(new TreeNodes(9,3));

        treeNodes.add(new TreeNodes(15,8));
        treeNodes.add(new TreeNodes(10,9));
        treeNodes.add(new TreeNodes(11,10));
        treeNodes.add(new TreeNodes(12,10));
        treeNodes.add(new TreeNodes(13,10));
        treeNodes.add(new TreeNodes(14,10));

        int rootId = 3;
        System.out.println("查找　rootId　=　" + rootId + "的子节点");
        treeMenuList(treeNodes,rootId);

        for(TreeNodes node : childNode) {
            System.out.println(" childNode id = " + node.getId());     //调用getId输出子节点
        }

        for(TreeNodes node : lastChildNode) {
            System.out.println("lastChildNode id = " + node.getId());
        }

    }



    public static List<TreeNodes> treeMenuList(List<TreeNodes>  treeNodes , int pid) {

        List<TreeNodes> tempTreeNode =  new ArrayList<TreeNodes>();
        List<TreeNodes> tempTreeNode1 =  new  ArrayList<TreeNodes>();
        for(TreeNodes node : treeNodes) {
            if(node.getPid() == pid) {
                //说明存在子节点

                tempTreeNode1 = treeMenuList(treeNodes,node.getId());      //getPid(),getId();
                if(tempTreeNode1.isEmpty()) {
                    //不存在子节点
                    lastChildNode.add(node);       //存入当前递归的node(id,pid),遍历输出时调用getId输出子id
                }
                childNode.add(node);

                //函数结束后返回tempTreeNode给上一级以供判断
                tempTreeNode.add(node);
            }
        }


        return tempTreeNode;       //返回tempTreeNode给上一级以供判断isEmpty(),递归需要用到,
    }
}

//节点类
class TreeNodes{
    int id;
    int pid;
    String name;

    public TreeNodes() {
        super();
    }
    public TreeNodes(int id, int pid) {
        super();
        this.id = id;
        this.pid = pid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
