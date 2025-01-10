import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        boolean answer = true;

        char[] words = s.toCharArray();
        
        boolean open = false;
        int openCnt = 0;
        
        for (char c : words) {
            
            if(!open && c == '(') { //괄호 시작
                open = true;
                openCnt++;
            }
            
            else if (open && c == '('){
                openCnt++;
            }
            
            else if (!open && c == ')') {
                answer = false;
                return false;
            }
            
            else if (open && c == ')') {
                openCnt--;
                
                if(openCnt == 0) open = false;
            }
        }
        
        if(openCnt != 0) answer = false;
        else answer = true;

        return answer;
    }
}