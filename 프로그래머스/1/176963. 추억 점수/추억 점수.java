import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String, Integer> hs = new HashMap<>();
        
        for (int i = 0; i<name.length; i++){
            String n = name[i];
            int num = yearning[i];
            
            hs.put(n, num);
        }
        
        answer = new int[photo.length];
        
        for (int i = 0; i<photo.length; i++){
            
            String[] c = photo[i];
            int sum = 0;
            
            for (int j = 0; j<c.length; j++) {
                String nam = c[j];
                
                if(hs.containsKey(nam)) {
                    sum += hs.get(nam);
                }
            }
            answer[i] = sum;
        }
        
        
        return answer;
    }
}