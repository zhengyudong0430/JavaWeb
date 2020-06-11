public class ThreadDemo21 {
     static class counter {
         public int count = 0;

         public void  increase() {
             ++count;
         }
     }public static void main(String[] args) throws InterruptedException {
         counter counter = new counter();
           Thread t1 =  new Thread(){
               @Override
               public void run() {
                   for(int i = 0; i<5000; i++) {
                       counter.increase();
                   }
               }
           };
           Thread t2 = new Thread() {
               @Override
               public void run() {
                   for(int i = 0; i<5000; i++) {
                       counter.increase();
                   }
               }
           };
           t1.start();
           t2.start();
           t1.join();
           t2.join();
           System.out.println(counter.count);
        }
   }
