import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1 , o2) -> o1[0] - o2[0] );
        PriorityQueue<int[]> q = new PriorityQueue<>(
          (o1, o2) -> o1[1] - o2[1]  
        );
        
        int index = 0;
        int time = 0;
        int cnt = 0;
        int sum = 0;
        
        while(cnt < jobs.length) {
            
            for (int i = index; i<jobs.length; i++) {
                if(jobs[i][0] <= time) {
                    q.add(jobs[i]);
                    index++;
                }
            }
            
            if(q.isEmpty() ) {
                time = jobs[index][0];
            } else {
                int[] t = q.poll();
                time = time + t[1];
                cnt++;
                sum += time - t[0];
            }
            
        }
        
        
        int answer = sum / jobs.length;
        return answer;
    }
}