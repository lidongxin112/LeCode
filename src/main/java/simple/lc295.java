package simple;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc295 {
//    class MedianFinder {
//        //        List<Integer> list = new ArrayList<>();
//        PriorityQueue<Integer> queMin;
//        PriorityQueue<Integer> queMax;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MedianFinder() {
//            queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
//            queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
//
//        }
//
//        public void addNum(int num) {
////            list.add(num);
//            if (queMin.isEmpty() || num <= queMin.peek()) {
//                queMin.offer(num);
//            }
//            if (queMax.size() + 1 < queMin.size()) {
//                queMax.offer(queMin.poll());
//            } else {
//                queMax.offer(num);
//                if (queMax.size() > queMin.size()) {
//                    queMin.offer(queMax.poll());
//                }
//            }
//        }
//
//        public double findMedian() {
////            int a = list.size();
////            Collections.sort(list);
////            double b = 0;
////
////            if (a % 2 == 0) {
////                b = (list.get(a / 2 - 1) + list.get(a / 2)) / 2.0;
////            } else {
////                b = list.get(a / 2);
////            }
////            list.clear();
////            return b;
////        }
//            if (queMin.size() > queMax.size()) {
//                return queMin.peek();
//            }
//            return (queMin.peek() + queMax.peek()) / 2.0;
//        }
class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}
        /**
         * Your MedianFinder object will be instantiated and called as such:
         * MedianFinder obj = new MedianFinder();
         * obj.addNum(num);
         * double param_2 = obj.findMedian();
         */
        public static void main(String[] args) {
            List<Integer> in = new ArrayList<>();
            in.add(1);
            in.add(2);
            System.out.println(in.get(0));
            in.clear();
            System.out.println(in);
        }
    }
