import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
public class ThreadDemo8 {
private  static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isQuit) {
                    System.out.println("别烦我，我正在转账呢");
                    try{
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("");
                }

        };
        t.start();
        Thread.sleep(5000);
        System.out.println("有内鬼，终止交易");
        isQuit = true;
    }
}
