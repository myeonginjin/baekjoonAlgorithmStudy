import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
                int answer = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i<bridge_length; i++) q.add(0);
        
        int curW = 0;
        
        for (int w : truck_weights) {
            
            System.out.println("w :  " + w +"   aws:" + answer + "   ");
            
            if (w + curW <= weight) {
                int t  = q.poll();
                curW -= t;
                q.add(w);
                curW +=w;
                
                answer++;
                continue;
            }
            
            while ( true ) {
                answer++;
                
                int tt = q.poll();
                curW -= tt;
                
                if(w + curW <= weight) {
                    q.add(w);
                    curW += w;
                    
                    System.out.println( w +"  " +  curW +"  "+ q.size());
                    break;
                } else {
                    q.add(0);
                }
            }
        }
        

        return answer += bridge_length;
    }
}