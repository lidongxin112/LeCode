package simple;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> aa = new ArrayList<>();
        aa.add("1");
        aa.add("1");
        aa.add("2");
        aa.add("1");
        aa.add("1");
        aa.add("1");
        aa.add("1");
        for (int i=0;i<8;i++){
            System.out.println(aa.get(i));
        }
    }
}
