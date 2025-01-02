import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hs = new HashMap<>();
        
        for (int i = 0; i<completion.length; i++){
            String t = completion[i];
            
            if(!hs.containsKey(t)) hs.put(t, 1);    
            
            else {
                int cnt = hs.get(t);
                hs.replace(t, cnt +1);
            }
        }
        
        for (int i = 0; i<participant.length; i++) {
            String t = participant[i];
            
            if(!hs.containsKey(t)) answer = t;
            
            else {
                int cnt = hs.get(t);
                
                if(cnt == 1) hs.remove(t);
                else {
                    hs.replace(t, cnt -1);
                }
            }
        }
        
        return answer;
    }
}