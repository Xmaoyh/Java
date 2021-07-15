package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("abcdc");
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        final int N = s == null ? 0 : s.length();
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        int ans = 0;
        int left = -1;
        for (int i = 0; i < N; i++) {
            final int idx = (int)s.charAt(i);
            // (left, i)已经是一个有效的解
            // 现在要把s[i]加进来
            // 1. 坏了才移动
            // 那么看一下是否会坏？
            while (pos[idx] > left) {
                // 如果(left, i)里面已经有了s[i]
                // 那么需要移动左边，
                // 移动的时候，怎么移动？
                // 可以直接将left 移动到pos[s[i]]
                // 因为我们采用的区间是左开右闭
                left = pos[idx];
            }
            pos[idx] = i;
            ans = Math.max(ans, i - left);
        }
        return ans;
    }

}
