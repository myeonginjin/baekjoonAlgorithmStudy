import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int i1 = 0;
        int i2 = 0;
        
        ArrayDeque<String> q = new ArrayDeque<>();
        for (int i = 0; i<goal.length; i++) q.add(goal[i]);
        
        while (i1 < cards1.length || i2 < cards2.length) {
            String t = q.peek();
            
            if(i1 < cards1.length && cards1[i1].equals(t)) {
                q.poll();
                i1++;
            }
            
            else if(i2 < cards2.length &&cards2[i2].equals(t)) {
                q.poll();
                i2++;
            }
            
            else {
                break;
            }
        }
        
        
        return q.size() != 0 ? "No" : "Yes";
    }
}