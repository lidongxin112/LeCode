package y2026.aud;

public class alixiaolu {
    /**
     * 判断医生和患者的对话句数。
     * 已知规则：
     * ab、aba、aab、aabb 都算 1 句，abbba 算 2 句。
     * 这里按连续分段处理：
     * 当一段长度大于 1 的 b 结束后再次出现 a，视为开启新的一句。
     *
     * @param a 对话字符串，只包含 a 和 b
     * @return 对话句数
     */
    public int judage(String a) {
        int sentenceCount = 1;
        int bCount = 0;
        for (int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            if (current == 'b') {
                bCount++;
                continue;
            }
            if (bCount > 1) {
                sentenceCount++;
            }
            bCount = 0;
        }
        return sentenceCount;
    }

    public static void main(String[] args) {
        alixiaolu a = new alixiaolu();
        System.out.println(a.judage(" baab"));
        System.out.println(a.judage("a"));
        System.out.println(a.judage("ab"));
        System.out.println(a.judage("aba"));
        System.out.println(a.judage("aab"));
        System.out.println(a.judage("aabb"));
        System.out.println(a.judage("abba"));
        System.out.println(a.judage("abbba"));
    }
}
