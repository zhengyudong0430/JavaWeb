public class ThreadDemo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true) {
                    System.out.println("我是新线程");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        while(true) {
            System.out.println("我是线程");
            Thread.sleep(100);
        }
    }
}
