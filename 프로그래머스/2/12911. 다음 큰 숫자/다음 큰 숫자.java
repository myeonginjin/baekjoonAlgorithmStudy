class Solution {
    
    static int check(int n) {
        int cnt = 0;
        
        while(n != 1) {
            if(n%2==1) cnt++;
            
            n /= 2;
        }
        return cnt;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        int cnt = check(n);
        
        for (int i = n+1; i<=Integer.MAX_VALUE; i++) {
            if(check(i) == cnt) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}