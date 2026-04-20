package y2026.aud;

public class stringShort {

    public static int findW(String str1,String str2){
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(0)){
                int j = 1;
                while (j < str2.length() && i + j < str1.length() && str1.charAt(i + j) == str2.charAt(j)){
                    j++;
                }
                if (j == str2.length()){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int findW1(String str1,String str2){
        for(int i=0;i<str1.length();i++){
            for (int j=i;j<str1.length();j++){
                if (str1.substring(i,j+1).equals(str2) && j-i+1 == str2.length()){
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String str1 = "abcdabcdabcd";
        String str2 = "abce";
        int index = findW(str1, str2);
        int index1 = findW1(str1, str2);

        System.out.println(index);
        System.out.println(index1);

    }
}
