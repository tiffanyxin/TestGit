package firstweek.com.qf.demon0516;


public class methodS {
    public static void main(String[] args) {

        int integer = sumTow(5, 10);
        int i = sumTow(5);
        System.out.println(integer);
        System.out.println(i);
        mySwitch();


    }

    public static void mySwitch() {
        int score = 6;
        switch (score) {
            case 1:
                System.out.println("you !");
                break;
            case 2:
            case 3:
                System.out.println("me!");
                break;
            default:
                System.out.println("everybody!");
                break;
        }
    }

    public static int sumTow(int a,int b){
        int sum = a+b;
        return sum;
    }

    public static int sumTow(int a){
        return a;
    }

}
