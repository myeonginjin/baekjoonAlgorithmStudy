import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        int idx = 0;
        
        while (idx < progresses.length) {
            int cnt = 0;
            
            for (int i = idx; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            for (int i = idx; i<progresses.length; i++) {
                if(progresses[i] >= 100) {
                    cnt++;
                    if(i == progresses.length -1) {
                        idx = progresses.length;
                        break;
                    }
                } else {
                    idx = i;
                    break;
                }
            }
            if(cnt != 0) arr.add(cnt);
        }
        
        answer = new int[arr.size()];
        int iidx = 0;
        
        for (int i : arr) {
            answer[iidx++] = i;
        }
        
        
        
        
        return answer;
    }
}