

import java.util.Scanner;

public class  Main2{
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNext()) {
            String  str = scanner.nextLine();
            String  [] strs = str.split(" ");
            int []array = new int [strs.length];
            for(int i = 0; i<array.length; i++) {
                array[i] = Integer.valueOf(strs[i]);
            }
            int num = array[0];
            int count = 0;
            for(int j=1; j<array.length; j++) {
                if(array[j] == num) {
                    count++;
                } else if(count>0) {
                   count--;
                }else {
                    num = array[j];
                }
            }
            System.out.println(num);
        }

    }
}