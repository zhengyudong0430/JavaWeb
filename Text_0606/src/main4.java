import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int k=0;
        int x = i;
        int y = j;
        if(i>j) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        while(i%j!=0) {
           k = i%j;
            i = j;
            j = k;
        }
        System.out.println(x*y/k);
    }


}
