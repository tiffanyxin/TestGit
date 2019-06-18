package fourthweek.demo0605;
import java.util.concurrent.*;

/**
 * @author Tiffany_xin
 * @time 2019/6/5  11:39
 */
public class ForkJobPoolTest {
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<String> submit = forkJoinPool.submit(new ForkJobThread());
        String s = submit.get();
        System.out.println(s);
        forkJoinPool.submit(new ForkJobThread2());
        forkJoinPool.awaitTermination(1,TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
}

 class ForkJobThread2 extends RecursiveAction{
     @Override
     protected void compute() {
         System.out.println("enhong");
     }
 }


class ForkJobThread extends RecursiveTask<String>{
    @Override
    protected String compute() {
        return "wo";
    }
}

