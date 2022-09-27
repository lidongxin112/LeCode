package com.zifuchuan;

/**
 * @author 东鑫
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，
 * 才返回 true 。
 * <p>
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 *
 */
/*
 分类讨论
 */
public class lc794 {
    public boolean validTicTacToe(String[] board) {
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < board.length; i++) {
            for (char c : board[i].toCharArray()) {
                x = (c == 'X') ? (x + 1) : x;
                y = (c == 'O') ? (y + 1) : y;
            }
        }
        return !((y != x && y != x - 1) ||
                (y != x - 1 && win(board, 'X')) ||
                (y != x && win(board, 'O')));
    }

    public boolean win(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            if ((c == board[0].charAt(i) && c == board[1].charAt(i) && c == board[2].charAt(i)) ||
                    (c == board[i].charAt(0) && c == board[i].charAt(1) && c == board[i].charAt(2))) {
                return true;
            }
        }
        return ((c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2)) ||
                c == board[2].charAt(0) && c == board[1].charAt(1) && c == board[0].charAt(2));
    }

}
