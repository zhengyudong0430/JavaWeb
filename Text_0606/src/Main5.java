import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int x = i;
        int y = j;
        while(i!=j) {
            while(i>j) {
                i = i-j;
            }
            while(i<j) {
                j = j-i;
            }
        }
        System.out.println(x*y/i);
    }
}
