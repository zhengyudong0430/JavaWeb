
public class Main9{
    static int cnt = 6;
    static{
        cnt += 9;
    };
    static{
        cnt /=3;
    };
    public static void main(String[] args){
        int i = 4%2;
        System.out.println(i);
        System.out.println("cnt =" + cnt);
    }

}
