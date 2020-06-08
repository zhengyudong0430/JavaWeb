public class ThreadDemo5 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //t1.start();
        t1.run();
    }
}
