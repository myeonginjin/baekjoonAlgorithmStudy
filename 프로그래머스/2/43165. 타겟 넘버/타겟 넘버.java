class Solution {
    static int[] a;
    static boolean[] v;
    static int t;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        a = numbers;
        v = new boolean[numbers.length];
        t = target;
        
        dfs(0, 0);
        
        
        return answer;
    }
    
    static void dfs(int index, int sum) {
        if(index == a.length) {
            if(sum == t) answer++;
            
            return;
        }
        
        
        v[index] = true;
        dfs(index+1, sum + a[index]);
        
        v[index] = false;
        dfs(index+1, sum - a[index]);
    }
}