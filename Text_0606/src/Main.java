import java.io.SequenceInputStream;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static  int []weight ;
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            N = scanner.nextInt();
            weight = new int [N+1];
            for(int i = 1; i<=N; i++) {
                weight[i] = scanner.nextInt();
            }
            bag(40,N);
            System.out.println(count);
        }
    }

    private static void bag(int w, int n) {
        if(w==0) {
            count++;
            return;
        }
        if(w<0||w>0&&n<1) {
            return;
        }
        bag(w-weight[n],n-1);
        bag(w,n-1);
    }
}
