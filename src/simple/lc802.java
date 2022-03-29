package simple;

import java.util.ArrayList;
import java.util.List;

public class lc802 {
    //graph的长度n为节点值，二维数组里的数组元素为节点指向的位置，可能存在相互指向，没有终点，找到有终点的节点
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int [] color = new int[n];
        List<Integer> arr = new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            if(safe(graph,color,i)){
                arr.add(i);
            }
        }
        return arr;
    }
    //x 为节点
    //color 数组 记录 节点 是否 0 尚未访问 1节点还位于递归栈中  2节点为安全状态
    public boolean safe(int [][] graph,int [] color,int x){
        if (color[x] > 0 ){
            return color[x] == 2;
        }
        color[x] =1;
        for (int y:graph[x]){
            if (!safe(graph,color,y)){
                return false;
            }
        }
        color[x] = 2;
        return true;
    }

    public static void main(String[] args) {

    }

}
