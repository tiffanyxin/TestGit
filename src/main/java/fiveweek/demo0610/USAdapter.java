package fiveweek.demo0610;

/**
 * @author Tiffany_xin
 * @time 2019/6/10  20:51
 */
public class USAdapter {
    public void execute(int size){
        System.out.println("us");
    }
}

interface China{
    void execute();
}

class ChinaAdapter extends USAdapter implements China{
//    private USAdapter usa = new USAdapter();
    @Override
    public void execute() {
        execute(0);
    }
}
