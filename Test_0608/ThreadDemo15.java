public class ThreadDemo15 {
    public static void main(String[] args) {
        for (Thread.State state:Thread.State.values()
             ) {
            System.out.println(state);
        }
    }
}
