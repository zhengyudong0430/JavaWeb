public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t1 = new Thread("这是一个线程的名字"){
            @Override
            public void run() {
            while (true) {
                System.out.println("你好线程");
            }
            }
        } ;
        t1.start();
    }
}
