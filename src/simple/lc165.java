package simple;

public class lc165 {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        for (int i = 0; i < a.length || i < b.length; i++) {
            System.out.println(a[i]);
            System.out.println(b[i]);
            int x = 0, y = 0;
            if (i < a.length) {
                x = Integer.parseInt(a[i]);
            }
            if (i < b.length) {
                y = Integer.parseInt(b[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "1.01";
//        System.out.println("\\.");
        String a2[] = a.split("\\.");
        for (String a1:a2){
            int x = Integer.parseInt(a1);
            System.out.println(x);
        }
    }
}
