import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        char[] c = s.toCharArray();
        
        int[] loc = new int[256]; for (int i = 0; i<256; i++) loc[i] = -1;

        StringBuilder sb = new StringBuilder();
        
        
        for (int i = 0; i<c.length; i++) {
            int word = c[i];
            int l = loc[word];

            if(l == -1) {
                answer[i] = -1;
            }
            
            else {
                answer[i] = i - l;
            }
            loc[word] = i;  
        }
        
        return answer;
    }
}