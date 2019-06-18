package fourthweek.demo0605;


/**
 * @author Tiffany_xin
 * @time 2019/6/5  20:24
 */

//第一题
public class ReplaceThread {
    public static void main(String[] args) throws InterruptedException {
        //字母
        WordThread wordThread = new WordThread();
        wordThread.start();

        //数字
        NumberThread numberThread = new NumberThread(wordThread);
        Thread thread = new Thread(numberThread);
        thread.start();

        Thread.sleep(2000);
    }
}

//数字
class NumberThread implements Runnable{
    //传入另外一个线程的对象,以确定两个线程的锁是同一个对象
    private  WordThread wordThread;

    public NumberThread(WordThread wordThread){
        this.wordThread = wordThread;
    }

    @Override
    public void run() {
        for (int i=1; i<27; i++){
           synchronized (wordThread){
               System.out.println(i);
               try {
                   wordThread.notify();
                   wordThread.wait();

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}

//字母
class WordThread extends Thread{

    @Override
    public void run() {
        for (int i=97; i<123; i++){
            synchronized (this){
                System.out.println((char)i);
                try {
                    this.notify();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


