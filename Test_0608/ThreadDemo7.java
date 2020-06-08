public class ThreadDemo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("cxk") {
            @Override
            public void run() {
                for(int i = 0;i<10;i++) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程要退出了");
            }

        };
        System.out.println(t1.getName());
        System.out.println(t1.getId());
        System.out.println(t1.getPriority());
        System.out.println(t1.getState());
        System.out.println(t1.isAlive());
        System.out.println(t1.isDaemon());
        t1.start();
        while (t1.isAlive()) {
            System.out.println("cxk 线程正在运行!");
            System.out.println(t1.getState());
            System.out.println(t1.isInterrupted());
            Thread.sleep(30);
        }
    }
}
