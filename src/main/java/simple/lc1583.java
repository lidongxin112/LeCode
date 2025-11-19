package simple;

public class lc1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int [][] close = new int[n][n];   //关系的亲近
        int [] temmate = new int[n];      //i的队友是谁
        int ans = 0;
        for (int i=0;i<preferences.length;i++){
            for (int j=0;j<preferences[i].length;j++){
                close[i][preferences[i][j]] = j;
            }
        }
        //整理配对情况
        for (int []pair:pairs){
            temmate[pair[0]] = pair[1];
            temmate[pair[1]] = pair[0];
        }
        //遍历所有人
        for (int x=0;x<n;x++){
            int y = temmate[x];
            //查看亲密度有无在y之前
            for (int u:preferences[x]){
                if (u==y){
                    break;
                }
                int v = temmate[u];
                if (close[u][x]<close[u][v]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
