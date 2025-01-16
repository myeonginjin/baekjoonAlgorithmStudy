class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.substring(0,1).equals("+")) {
            return Integer.parseInt(s.substring(1, s.length()));
        }
        
        if(s.substring(0,1).equals("-")) {
            return -Integer.parseInt(s.substring(1, s.length()));
        }
        
        return Integer.parseInt(s);
    }
}