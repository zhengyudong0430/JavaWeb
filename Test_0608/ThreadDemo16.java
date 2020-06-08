public class ThreadDemo16 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i<1000_0000; i++) {

                }
            }
        };
        System.out.println("线程开始前："+t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println("线程运行中："+t.getState());
        }
        System.out.println("线程结束后："+t.getState());
    }
}
