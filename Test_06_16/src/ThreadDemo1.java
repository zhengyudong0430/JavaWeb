public class ThreadDemo1 {
    static class Singleton{
        public Singleton() {
        }
        private static Singleton instance = new Singleton();
        public static Singleton getInstance() {
            return instance;
        }
    }
    public static void main(String[] args) {
      Singleton s = Singleton.getInstance();
      Singleton s1 = Singleton.getInstance();
        System.out.println(s==s1);
    }
}
