public class ThreadDemo3 {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {

            }
        };
        t.start();
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread t2 = new Thread(runnable);
      t2.start();
        Thread t3 = new Thread(() -> {
            System.out.println("我是一个新线程");
        });
        t3.start();
    }


}
