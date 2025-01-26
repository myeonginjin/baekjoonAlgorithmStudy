

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double t = Math.sqrt(n);
        
        System.out.println(t);
        
        if( (int)t == t ) {
            answer = (long) Math.pow( t + 1 , 2 );
        } else {
            answer = -1;
        }
        
        return answer;
    }
}