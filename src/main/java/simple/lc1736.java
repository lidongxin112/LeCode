package simple;

public class lc1736 {
    public String maximumTime(String time){
        char[] chars = time.toCharArray();

        if (chars[0] == '?' && chars[1] == '?') {
            chars[0] = '2';
            chars[1] = '3';

        } else if (chars[0] == '?' && chars[1] != '?') {
            if (chars[1] <= '3') {
                chars[0] = '2';
            } else {
                chars[0] = '1';
            }
        } else if (chars[0] != '?' && chars[1] == '?') {
            if (chars[0] == '2') {
                chars[1] = '3';
            } else {
                chars[1] = '9';
            }
        }


        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }

        return new String(chars);
    }

//    public static void main(String[] args) {
//
//
//        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
//        a.put(a,b);
//    }
}
