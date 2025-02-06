class Solution {
    public int solution(int n) {
        //int answer = dfs(n);
        int answer = 0;
        long[] dp = new long[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i<=n; i++) {
            dp[i] =  ( dp[i-1] + dp[i-2] ) % 1234567;
        }
        
        return  (int)dp[n];
    }
    
//     static int dfs(int n) {
//         if(n==0) return 0;
        
//         if(n==1) return 1;
        
//         return dfs(n - 1) + dfs(n - 2);
//     }
}