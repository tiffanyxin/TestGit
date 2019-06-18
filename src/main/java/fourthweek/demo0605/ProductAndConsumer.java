package fourthweek.demo0605;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  21:47
 */
public class ProductAndConsumer {
    public static void main(String[] args) {
        Pie pie = new Pie(10);
        Product product1 = new Product(pie);
        Product product2 = new Product(pie);
        Consumer consumer = new Consumer(pie);
        product1.start();
        product2.start();
        consumer.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//消费者
class Consumer extends Thread{
    private Pie pie;

    public Consumer(Pie pie){
        this.pie = pie;
    }

    @Override
    public void run() {
        while (true){
          synchronized (pie){
                if (pie.getCount() > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pie.setCount(pie.getCount()-1);
                    System.out.println("卖出一个烧饼！");
                    pie.notify();
                }else {
                    try {
                        System.out.println("卖完了！");
                        pie.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}



//生产者
class Product extends Thread{
   private Pie pie;

    public Product(Pie pie){
        this.pie = pie;
    }

    @Override
    public void run() {
        while (true){
           synchronized (pie){
                if (pie.getCount() < 20){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pie.setCount(pie.getCount()+1);
                    System.out.println("做出一个烧饼！");
                    pie.notify();
                }else {
                    try {
                        System.out.println("做满了！");
                        pie.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
