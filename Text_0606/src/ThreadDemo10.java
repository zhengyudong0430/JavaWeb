

public class ThreadDemo10 {
    public static void main(String[] args) {
        Thread  t = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i<10; i++) {
                    System.out.println(Thread.interrupted());
                }
            }
        };
     t.start();
    }
}
