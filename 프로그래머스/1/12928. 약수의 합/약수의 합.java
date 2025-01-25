class Solution {
    public int solution(int n) {
        int answer = 0;
        
        double div = 1.0;
        
        if (n==0) return 0;
        
        while(div <= n) {
            double num = n / div;

            if( Math.ceil(num) == (int) num) {
                answer +=  (int) num;
            }
            
            
            div++;
        }
        
        return answer;
    }
}