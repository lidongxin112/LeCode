package JUC;

public class demo {

    public static void main(String[] args) {

        int i = 1;
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        new Thread(() -> {
            int a = i;
            a++;
        }).start();
        System.out.println(i);
    }
}
