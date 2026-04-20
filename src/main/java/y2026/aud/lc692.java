package y2026.aud;

import java.util.*;

public class lc692 {
    /**
     * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
     * 示例 1：
     *
     * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     *     注意，按字母顺序 "i" 在 "love" 之前。
     * 示例 2：
     *
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     *     出现次数依次为 4, 3, 2 和 1 次。
     *     1 <= words.length <= 500
     * 1 <= words[i].length <= 10
     * words[i] 由小写英文字母组成。
     * k 的取值范围是 [1, 不同 words[i] 的数量]
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String s:  words){
            map.put(s,map.getOrDefault(s,0) + 1);
        }
//        return map.entrySet().stream()
//                .sorted((o1, o2) -> o2.getValue().equals(o1.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue())
//                .map(Map.Entry::getKey)
//                .limit(k)
//                .toList();
        // - 如果频率相同，按字典序降序排（为了在弹出时留下字典序小的）
        // - 如果频率不同，按频率升序排（小顶堆，弹出频率最低的）
        PriorityQueue<String> head = new PriorityQueue<>(
                (o1,o2) ->{
                    int w1 = map.get(o1);
                    int w2 = map.get(o2);
                    if (w1 == w2){
                        return o1.compareTo(o2);
                    }
                    return w1 - w2;
                }
        );
        for (String s: map.keySet()){
            head.offer(s);
            if (head.size() > k){
                head.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!head.isEmpty()){
            result.add(0,head.poll());
        }
        Collections.reverse(result);
        return result;
    }
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        rec.sort(new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = new lc692().topKFrequent(words, k);
        List<String> strings1 = new lc692().topKFrequent2(words, k);
        System.out.println(strings);
    }
}
