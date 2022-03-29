package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static List<Integer> list = new ArrayList<>();
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println(new App().digui(list));
    }
    public int digui(List<Integer> list){
        int b = 0;
        for (int a:list){
            for (int i=1;i<=a;i++){
                if (i==1||i%3==0){
                    list.remove(a);
                    break;
                }
                if (list.size()==1){
                    b = list.get(0);
                }
            }
        }
        return b;
    }
}
