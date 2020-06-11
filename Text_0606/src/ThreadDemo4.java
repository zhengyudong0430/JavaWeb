public class ThreadDemo4 {
    static  class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我当然也是一个线程");
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("我也是一个线程");
            }
        };
        t2.start();
        Thread t3 = new Thread(new MyRunnable());
        t3.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("哼，我也是一个线程");
            }
        };
        Thread t4 = new Thread(runnable);
        t4.start();
        Thread t5 = new Thread(()->{
            System.out.println("我难道不是线程？");
        });
        t5.start();
    }
}
