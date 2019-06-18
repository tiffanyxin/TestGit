package secondweek.demo0522;

/**
 * @author Tiffany_xin
 * @time 2019/5/22  21:14
 */
public class TigerA extends Tiger {
    private int weight;

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        if (weight <= 1000 && weight>=1){
            this.weight = weight;
            return;
        }
    }
}
