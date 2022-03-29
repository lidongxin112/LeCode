package com.weiyunsuan;

public class lc29 {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == 1) {
                    return Integer.MIN_VALUE;
                }
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            if (divisor == Integer.MIN_VALUE) {
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }
            if (dividend == 0) {
                return 0;
            }
            boolean rev = false;
            if (dividend > 0) {
                dividend = -dividend;
                rev = !rev;
            }
            if (divisor > 0) {
                divisor = -divisor;
                rev = !rev;
            }

            int left = 1, right = Integer.MAX_VALUE, ans = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                boolean check = quickAdd(divisor, mid, dividend);
                if (check) {
                    ans = mid;
                    if (mid == Integer.MAX_VALUE) {
                        break;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return rev ? -ans : ans;
        }

        public boolean quickAdd(int y, int z, int x) {
            int result = 0, add = y;
            while (z != 0) {
                if ((z & 1) != 0) {
                    if (result < x - add) {
                        return false;
                    }
                    result += add;
                }
                if (z != 1) {
                    if (add < x - add) {
                        return false;
                    }
                    add += add;
                }
                z >>= 1;
            }
            return true;
        }

    public static void main(String[] args) {
        int divide = new lc29().divide(10, 3);
        System.out.println(divide);

    }
}
