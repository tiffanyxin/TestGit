package fiveweek.demo0610;

/**
 * @author Tiffany_xin
 * @time 2019/6/10  20:30
 */
public class Mp3Decorator extends Decorator{

    public Mp3Decorator(Plugin plugin){
        super(plugin);
    }

    @Override
    public void add() {
        plugin.add();
        System.out.println("Mp3");
    }
}
