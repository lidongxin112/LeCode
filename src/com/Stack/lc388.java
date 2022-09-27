package com.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：
 * 这里将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。
 * subdir1 包含文件 file1.ext 和子目录 subsubdir1；subdir2 包含子目录 subsubdir2，
 * 该子目录下包含文件 file2.ext 。
 * 在文本格式中，如下所示(⟶表示制表符)：
 *
 * @author 东鑫
 */
public class lc388 {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        String[] words = input.split("\n");
        int[] pathLens = new int[words.length + 1];
        //pathLens[i]存放地i层次的最后面的元素的路径长度
        pathLens[0] = -1;//层次最少是1，为了统一dp操作（具体看下面循环体），取pathLens[0]=-1
        int ans = 0;
        //自左向右，dp
        for (String word : words) {
             int level = word.lastIndexOf('\t') + 1 + 1;//层次计算
            int nameLen = word.length() - (level - 1);//计算名字长度
            //word的父文件夹必定目前是level-1层次的最后一个，因此pathLens[level-1]就是父文件夹路径长度
            //这个word必然是目前本层次的最后一个，因此需要刷新pathLens[level],+1是因为要加一个'\'
            pathLens[level] = pathLens[level - 1] + 1 + nameLen;
            //如果是文件，还需要用路径长度刷新ans
            if (word.contains(".")) ans = Math.max(ans, pathLens[level]);
        }
        return ans;
    }
    public int lengthLongestPath1(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (pos < n) {
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            pos++;
            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "file1.txt\nfile2.txt\nlongfile.txt";
        int i = new lc388().lengthLongestPath1(s);
    }
}
