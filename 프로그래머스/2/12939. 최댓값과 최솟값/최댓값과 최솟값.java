import java.util.*;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(s, " ");
        
        String[] arr = s.split(" ");
        
        int tokens = st.countTokens();
        for (int i = 0; i<tokens; i++) {
            int num = Integer.parseInt(arr[i]);
            
            System.out.print(num +" ");
            
            max = Math.max(max, num);
            min = Math.min(min, num);

        }
        String answer = "";
        answer += String.valueOf(min);
        answer += " ";
        answer += String.valueOf(max);
        return answer;
    }
}