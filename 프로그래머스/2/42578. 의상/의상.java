import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String[] t : clothes) {
            String type = t[1];
            
            hm.put(type, hm.getOrDefault(type, 0) + 1 );
        }
        
        int answer = 1;
        
        
        for (Map.Entry<String,Integer> t : hm.entrySet() ) {
            answer *= t.getValue() + 1;
        }
        
        answer--;
        
       
        return answer;
    }
}