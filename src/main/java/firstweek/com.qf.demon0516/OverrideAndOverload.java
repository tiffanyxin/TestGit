package firstweek.com.qf.demon0516;


public class OverrideAndOverload {
    public static void main(String[] args){
        //重写多态的一种表现
    People p = new MrHuang();
    p.doing();

    }

}

class People{
    public void doing(){
        System.out.println("you are a stupid!");
    }
}

class MrHuang extends People{
    @Override
    public void doing(){
        System.out.println("you are MrHuang!");
    }
}
