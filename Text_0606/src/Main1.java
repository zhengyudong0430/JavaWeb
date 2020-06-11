import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
         int A = (a+c)/2;
         int B = A-a;
         int C = B-b;
         if((b+d)/2==B) {
             System.out.println(A+" "+B+" "+C);

         }else{
             System.out.println("No");
    }}
}
