public class ThreadDemo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("别烦我，忙着转账呢");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账被终止！");
            }
        };
        t.start();
        Thread.sleep(200);
        System.out.println("有内鬼，终止交易");
        t.interrupt();
    }
}
