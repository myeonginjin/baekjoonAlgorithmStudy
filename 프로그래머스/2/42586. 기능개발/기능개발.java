import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        int index = 0;
        
        while(index<progresses.length) {
            
            for (int i = index; i<progresses.length; i++) { //작업 진행
                progresses[i] += speeds[i];
            }
            
            int cnt = 0;
            for (int i = index; i<progresses.length; i++) { //배포 검사
                   if(progresses[i] >= 100) {
                       cnt++;
                       index = i;
                   } else break;
            }
            if(cnt!=0) {
                index++;
                arr.add(cnt);
            }
        }
        
        answer = new int[arr.size()];
        int t = 0;
        for(int i : arr) answer[t++] = i; 
        
        
        return answer;
    }
}