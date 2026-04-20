package y2026.April;

public class a {
    public static void main(String[] args) {

        for (int i=0;i<100;i++){
            int b = i;
            Thread a = new Thread(() -> {
                if (b % 2 == 0){
                    System.out.println(b);
                }
            });
            a.start();
            Thread c = new Thread(() -> {
                if (b % 2 != 0){
                    System.out.println(b);
                }
            });
            c.start();
        }
    }
}
