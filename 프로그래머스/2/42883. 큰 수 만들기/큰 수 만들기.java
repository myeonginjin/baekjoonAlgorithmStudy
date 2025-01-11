import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int len = number.length() - k;
    
        int last = len;
        
        int str = 0;
        
        while (len --> 0) {
            char max = 0;
            char c = '?';
            
            for (int i = str; i<= k; i++) {
                c = number.charAt(i);
                
                if (max < c) {
                    
                    max = c;
                    str = i+1;
                }
                
            }
            sb.append(max);
            k++;
        }

        
        return sb.toString();
    }
}