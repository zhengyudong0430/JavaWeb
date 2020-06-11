


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mian11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String []a = null;
        a = str.split(" ");
        int []num = new int[a.length];
        int k = 0;
        for(int i = 0; i<a.length; i++ ) {
            num[i] = Integer.valueOf(a[i]);
            k = num[num.length-1];
        }

        Arrays.sort(num,0,num.length-1);
        for(int i = 0; i<k-1;i++) {
            System.out.print(num[i]+" ");
        }
        System.out.print(num[k-1]);


    }
}
