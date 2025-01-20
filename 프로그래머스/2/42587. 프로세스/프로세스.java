import java.util.*;

class Solution {
    
    static int[] cnt;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        cnt = new int[10];
        ArrayDeque<int[]> q = new ArrayDeque<>( );
        
        for (int i = 0; i<priorities.length; i++) {
            int p = priorities[i];
            cnt[p]++;
            
            q.add(new int[]{i, p});
        }
        
        int max = 0;
        for (int i = 9; i>=0; i--) {
            if(cnt[i]!=0) {
                max = i;
                break;
            }
        }
        
        while(!q.isEmpty()) {
            int[] t = q.poll();
            
            int l = t[0];
            int p = t[1];
            
            if(p == max) {
                
                if(l == location) {
                    return answer+1;
                }
                
                cnt[p]--;
                if(cnt[p]==0){
                    max = checkNext(max);
                }
                
                answer++;
            }
            
            else {
                q.add(t);
            }
            
            
        }
        
        return answer;
    }
    
    static int checkNext(int m) {
        for (int i = m-1; i>=0; i--) {
            if(cnt[i]!=0) return i;
        }
        return -1;
    }
}