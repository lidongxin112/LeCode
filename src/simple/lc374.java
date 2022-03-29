package simple;

/**
 * @author 东鑫
 */
public class lc374 {
     int guess(int num){
         return 1;
     }
    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        int result;
        int flag;
        do {
            // 此处要避免数据溢出，不能写 (max + min) / 2
            result = min + (max - min) / 2;
            flag = guess(result);
            if (flag == -1) max = result - 1;
            if (flag == 1) min = result + 1;
        } while (flag != 0);
        return result;
    }
}
