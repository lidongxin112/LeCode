package simple;

public class lc551 {
    public boolean checkRecord(String s) {

        int a = s.length();
        char b = 'A';//缺勤
        String e = "LLL";
        int nums = 0;
        for(int i=0;i<a;i++){
            if (s.charAt(i)==b){
                nums++;
            }
        }
        if (nums>=2){
            return false;
        }
        if (s.contains(e)){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new lc551().checkRecord("AA"));

    }
}
