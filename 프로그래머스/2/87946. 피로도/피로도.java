class Solution {
    static int[] b;
    static boolean[] v;
    static int[][] dun;
    static int answer;
    static int len;
    static int hp;
    
    static void countD() {
        
        int count = 0;
        int tempHp = hp;

        for (int i = 0; i<len; i++) {
            int index = b[i];
            
            int pilyo = dun[index][0];
            int somo = dun[index][1];
            
            //System.out.println(pilyo+" "+somo +" "+tempHp);
            
            if(tempHp < pilyo) break;
            
            tempHp -= somo;
            count++;
        }
        
        answer = Math.max(count, answer);
        

        //System.out.println(answer +"    : answer" );

        
    }
    
    static void pum(int cnt) {
        if(cnt >= len) {
            
            countD();
            
            return;
        }
        
        for (int i = 0; i<len; i++) {
            if(v[i]) continue;
            
            v[i] = true;
            b[cnt] = i;
            
            pum(cnt+1);
            
            v[i] = false;
        }
        
    }
    
    public int solution(int k, int[][] dungeons) {
        hp = k;
        dun = dungeons;
        len = dungeons.length;

        b = new int[len];
        v = new boolean[len];
        
        pum(0);
        
        return answer;
    }
}