import java.util.*;

class Solution {
    static ArrayList<Integer>[] g;
    static boolean[] v;
    static HashSet<int[]> hs;
    static int answer = Integer.MAX_VALUE;
    static int cnt;
    
    public int solution(int n, int[][] wires) {
        g = new ArrayList[n+1]; for (int i = 1; i<=n; i++) g[i] = new ArrayList<>();
        hs = new HashSet<>();
        
        for (int i = 0; i<wires.length; i++) {
            int[] t = wires[i];
            
            int go = t[0];
            int to = t[1];
            
            g[go].add(to);
            g[to].add(go);
            
            hs.add(new int[]{go, to});
        }
        
        for (int[] del : hs) {
            
            //초기화
            v = new boolean[n+1];
            cnt = 0;  
            
            int go = del[0];
            int to = del[1];
            
            //System.out.printf("go : %d   to : %d   ->>>  ", go, to);
            
            //연결 끊기
            for (int i = 0; i<g[go].size(); i++) {
                if(g[go].get(i) == to) {
                    g[go].remove(i);
                    break;
                }
            }
            //연결 끊기
            for (int i = 0; i<g[to].size(); i++) {
                if(g[to].get(i) == go) {
                    g[to].remove(i);
                    break;
                }
            }
            
            //개수 세기
            for (int i = 1; i<=n; i++){
                if(g[i].size()!=0) {

                    //System.out.print("  start : "+g[i].get(0) +"   ->>>  ");
                    dfs(g[i].get(0));
                    
                    int group1 = cnt;
                    int group2 = n - cnt;
                    
                    answer = Math.min( Math.abs( group1 - group2 ) , answer );
                    
                    
                    break;
                }
            }
            
            //연결 다시 하기
            g[go].add(to);
            g[to].add(go);
            
            
        }
        
        

        
        return answer;
    }
    
    static void dfs(int node) {
        v[node] = true;
        cnt++;
        
        for (int i = 0; i<g[node].size(); i++) {
            int next = g[node].get(i);
                
            if(v[next]) continue;
            
            dfs(next);
        }
    }
}

