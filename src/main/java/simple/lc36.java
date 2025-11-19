package simple;

/**
 * 有效的数独
 */
public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='.'){
                    continue;
                }
                else{
                    char c = board[i][j];
                    for (int e=0;e<board.length&& e!=i;e++){
                        if (board[e][j]==c){
                            return false;
                        }
                    }
                    for (int e=0;e<board[0].length&& e!=j;e++){
                        if (board[i][e]==c){
                            return false;
                        }
                    }
                    for (int i1= i + 1;i1 % 3 !=0 ;i1++){
                        for (int j1=j / 3 *3;j1<j / 3 * 3 +  3;j1++){
                            if (board[i1][j1]==c){
                                return false;
                            }
                        }
                    }

//                    int var = boo(board, i, j);
//                    if (var ==0){
//                        return false;
//                    }
                }
            }
        }
        return true;
    }
    public int boo(char[][] board,int i,int j){
        int a1 = 0;
        char c = board[i][j];
        for (int e=0;e<board.length&& e!=i;e++){
            if (board[e][j]==c){
                return a1;
            }
        }
        for (int e=0;e<board[0].length&& e!=j;e++){
            if (board[i][e]==c){
                return a1;
            }
        }
        int ii = i / 3;
        int jj = j / 3;
        for (int i1=ii * 3;i1<(ii+1) * 3&&i1!=i;i1++){
            for (int j1=jj * 3;j1<(jj+1) * 3&&j1!=j;j1++){
                if (board[i1][j1]==c){
                    return a1;
                }
            }
        }
        return a1 = 1;
    }

    public static void main(String[] args) {
        char [][]a = {
                {'.','.','5','.','.','.','.','.','.'},
                {'.','.','.','8','.','.','.','3','.'},
                {'.','5','.','.','2','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','9'},
                {'.','.','.','.','.','.','4','.','.'},
                {'.','.','.','.','.','.','.','.','7'},
                {'.','1','.','.','.','.','.','.','.'},
                {'2','4','.','.','.','.','9','.','.'}
};
        System.out.println(new lc36().isValidSudoku(a));
    }
}
