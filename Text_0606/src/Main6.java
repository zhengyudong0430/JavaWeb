import java.util.Scanner;
public class Main6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = 0;
        if(num1%4==0||num2%4==0) {
            count = num1*num2/2;
        }else{
            count = num1*num2/2+1;
        }
        System.out.println(count);
    }
}
