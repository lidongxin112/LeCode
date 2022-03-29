package simple;

import java.util.*;

public class BililiDayBy2021825 {
    //First
    /*
    /*
计算共有的最小元素
给定一个含有多行的一位数组，每行元素都已经严格递增排序好了，请你找到在这些行中同时出现的最小元素。如果找不到元素返回-1
每行一个数组
每个数组逗号分隔
输出描述
输出一个整数
样例输入
1,2,3,4,5,9
2,4,5,8,9,10
3,5,7,9,11
1,3,5,7,9
样例输出
5
提示
1 <= m.length, m[i].length <= 500
1 <= m[i][j] <= 10^4

m[i] 已按严格递增顺序排列。
*/
//    public int FindBig(int [][] sn){
//        int a = 0;
//        Set<Integer> ab = new HashSet<>();
//
//    }
    public static void main(String[] args) {
        ArrayList<String> ns = new ArrayList<>();
        while (true){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals("")){
                break;
            }
            ns.add(str);
        }
        int b = ns.size();
        String [][] as = new String[b][];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<b;i++){
           as[i]  = ns.get(i).split(",");
        }
        for (int i=0;i<b;i++){
            for (int j=0;j<as[i].length;j++){
                int key = Integer.parseInt(as[i][j]);
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        List<Integer> aaa = new ArrayList<>();
        for (Map.Entry<Integer,Integer> m:map.entrySet()){
            if (m.getValue()==b){
                aaa.add(m.getKey());
            }
        }
        Integer[] bbb =aaa.toArray(new Integer[0]);
        Arrays.sort(bbb);
        System.out.println(bbb[0]);
    }

}
