package simple;

public class lc1893 {
    public boolean isCovered(int[][] ranges,int left,int right){
        for (int i=0;i<ranges.length;i++){
            for (int j=0;j<ranges.length;j++){
                if (ranges[j][0]<=left&&ranges[j][1]>=left){
                    left++;
                    j--;
                }
                if (left>right){
                    return true;
                }
            }
        }
        return false;
//        int curleft = left;
//        Arrays.sort(ranges, Comparator.comparing(o-> o[0]));
//        for (int[] r:ranges){
//            int rangeLeft = r[0];
//            int rangeRight = r[1];
//            if (rangeLeft<=curleft&&curleft<=rangeRight){
//                curleft=rangeRight+1;
//            }
//        }
//        return curleft>right;
    }


}
