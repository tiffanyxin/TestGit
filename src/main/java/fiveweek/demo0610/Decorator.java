package fiveweek.demo0610;

/**
 * @author Tiffany_xin
 * @time 2019/6/10  20:25
 */
public abstract class  Decorator implements Plugin{
    protected Plugin plugin;

    public Decorator(Plugin plugin){
        this.plugin = plugin;
    }

}
