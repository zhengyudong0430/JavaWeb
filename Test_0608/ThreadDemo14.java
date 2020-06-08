import static java.lang.Thread.*;

public class ThreadDemo14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i<10; i++ ) {
                    System.out.println("我是线程1");
                    try{
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } ;
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i<10; i++) {
                    System.out.println("我是线程2");
                    try{
                         Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t2.join();
        t1.join();
        System.out.println("主线程结束了");
    }
}
