package y2026.May;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 如果非空，则仅由小写英文字母组成
 */
public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(new lc14().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
