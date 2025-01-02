import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> hs = new HashSet<>();
        
        for (String t : phone_book) hs.add(t);
        
        for (int i = 0; i<phone_book.length; i++){
            
            String t  = phone_book[i];
            
            
            
            for (int j = 0; j <t.length()-1; j++) {
                
                String head = t.substring(0,j+1);
                
                if(hs.contains(head)) answer = false;
            }
        }
            
        return answer;
    }
}