package com.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 东鑫
 * 306. 累加数
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，
 * 字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 */
public class lc306 {
        String num;
        int n;
        List<List<Integer>> list = new ArrayList<>();
        public boolean isAdditiveNumber(String _num) {
            num = _num;
            n = num.length();
            return dfs(0);
        }
        boolean dfs(int u) {
            int m = list.size();
            if (u == n) return m >= 3;
            int max = num.charAt(u) == '0' ? u + 1 : n;
            List<Integer> cur = new ArrayList<>();
            for (int i = u; i < max; i++) {
                cur.add(0, num.charAt(i) - '0');
                if (m < 2 || check(list.get(m - 2), list.get(m - 1), cur)) {
                    list.add(cur);
                    if (dfs(i + 1)) return true;
                    list.remove(list.size() - 1);
                }
            }
            return false;
        }
        boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
            List<Integer> ans = new ArrayList<>();
            int t = 0;
            for (int i = 0; i < a.size() || i < b.size(); i++) {
                if (i < a.size()) t += a.get(i);
                if (i < b.size()) t += b.get(i);
                ans.add(t % 10);
                t /= 10;
            }
            if (t > 0) ans.add(t);
            boolean ok = c.size() == ans.size();
            for (int i = 0; i < c.size() && ok; i++) {
                if (c.get(i) != ans.get(i)) ok = false;
            }
            return ok;
        }


      public boolean isAdditiveNumber1(String num) {
              return dfs(num, 0, 0, 0, 0);
          }
          public boolean dfs(String num, int index, int count, long prepre, long pre){
              //index:处理到了哪一个位置；count:已经处理了多少个数；prepre, pre:前面的两个数
              if (index >= num.length()) return count > 2;
             long cur = 0;
              for (int i = index; i < num.length(); i++){
                  char c = num.charAt(i);
                  if (num.charAt(index) == '0' && i > index) return false;
                  // 剪枝1：不能做为前导0，但是它自己是可以单独做为0来使用的

                  cur = cur * 10 + c - '0';
                  if (count >= 2){
                      long sum = prepre + pre;
                      if (cur > sum) return false;// 剪枝2：如果当前数比之前两数的和大了，说明不合适
                      if (cur < sum) continue;// 剪枝3：如果当前数比之前两数的和小了，说明还不够，可以继续添加新的字符进来
                  }
                  if (dfs(num, i + 1, count + 1, pre, cur)) return true;// 当前满足条件了，或者还不到两个数，向下一层探索
              }
              return false;
         }



    public static void main(String[] args) {
        boolean additiveNumber = new lc306().isAdditiveNumber1("112358");
        System.out.println(additiveNumber);
    }
}
