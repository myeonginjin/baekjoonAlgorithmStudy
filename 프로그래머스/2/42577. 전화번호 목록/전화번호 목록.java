import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> hs = new HashSet<>();
        for (String str : phone_book) hs.add(str);
        
        
        for (String str : phone_book) {
            
            
            for (int i = 0; i<str.length()-1; i++) {
                String temp = str.substring(0, i+1);
                if(hs.contains(temp)) answer = false;
            }
        }
        
        return answer;
    }
}