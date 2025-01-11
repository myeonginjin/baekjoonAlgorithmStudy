class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        int moveCnt = len -1;
        
        char[] a = name.toCharArray();
        
        for (int i = 0; i < len; i++) {
            char c = a[i];
            
             answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            
            int index = i + 1;
            
            while (index < len && a[index] == 'A') {
                index++;
            }
            
            moveCnt = Math.min(moveCnt, i*2 + len - index);
            moveCnt = Math.min(moveCnt, (len-index) * 2 + i);
        
        }
        
        
        return answer + moveCnt;
    }
}