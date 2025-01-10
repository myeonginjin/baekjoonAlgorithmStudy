import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i<s.length(); i++) {
            String t = s.substring(i, i+1);
            
            if(t.equals("(")) st.push(1);
            
            else  {
                
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        
        if(st.size()!=0) return false;
        
        return answer;
    }
}