import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int k = K;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i : scoville) q.add(i);
        
        int cnt = 0;
        
        while(q.size() > 1) {
            int t = q.poll();
            
            if(t < k) {
                int mix = t + (q.poll() * 2);
                cnt++;
                q.add(mix);
            }
            
            else break;
        }
        
        int answer = q.size() == 1 ? q.poll() < k ? -1 : cnt : cnt;
        return answer;
    }
}