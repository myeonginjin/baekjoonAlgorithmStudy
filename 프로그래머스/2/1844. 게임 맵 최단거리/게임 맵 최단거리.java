import java.util.*;

class Solution {
    static int rRange;
    static int cRange;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        rRange = maps.length;
        cRange = maps[0].length;
        
        int[][] step = new int[rRange][cRange];
        
        ArrayDeque<int[]> q = new ArrayDeque();
        
        q.add(new int[]{0,0,1});
        step[0][0] = -1;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while(!q.isEmpty()) {
            int[] t = q.poll();
            
            for (int i = 0; i<4; i++) {
                int nextR = t[0] + dr[i];
                int nextC = t[1] + dc[i];
                int s = t[2];
                
                if(rangeOk(nextR, nextC) && step[nextR][nextC] == 0 
                  && maps[nextR][nextC] ==1) {
                    q.add(new int[]{nextR, nextC, s + 1 });
                    step[nextR][nextC] = s + 1;
                }
            }
        }
        
        answer = step[rRange-1][cRange-1] != 0 ? step[rRange-1][cRange-1] : -1;
        
        return answer;
    }
    
    static boolean rangeOk(int r, int c){
        return r >= 0 && r < rRange && c >=0 && c < cRange;
    }
}