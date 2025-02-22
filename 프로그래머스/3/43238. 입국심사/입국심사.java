import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        
        long start = 1;
        long end = times[0] *  (long)n;
        
        while( start <= end ) {
            long mid = (start + end) / 2;
            long cnt = 0;
            
            for (int t  : times) {
                cnt += mid / t;
            }
            
            if(cnt < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}