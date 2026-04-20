package y2026.April;

public class lc657 {
    public boolean judgeCircle(String moves) {
        char[] charArray = moves.toCharArray();
        int num = 0;
        int num2 = 0;
        for (char c : charArray){
            switch ( c){
                case 'U':
                    num++;
                    break;
                case 'D':
                    num--;
                    break;
                case 'L':
                    num2 += 2;
                    break;
                case 'R':
                    num2 -=2;
                    break;
            }
        }
        if (num == 0 && num2 == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println('a' | 'a');
        System.out.println(1 | 0 | ('a' - 0));
    }
}
