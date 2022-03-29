package simple;

/**
 * @author 东鑫
 * 1716. 计算力扣银行的钱
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * <p>
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，
 * 他都会比 前一个周一 多存入 1 块钱。
 * <p>
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 */
public class lc1716 {
    public int totalMoney(int n) {
        int nu = n / 7 + 1;
        int sum = 0;
        int num = 0;
        int c = 0;
        for (int i = 0; i < nu; i++) {
            int k = 0;
            ;
            for (int j = 1; j <= 7 && num < n; j++) {
                num++;
                k += j + c;
            }
            c++;
            sum+=k;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = new lc1716().totalMoney(20);
        System.out.println(i);
    }
}
