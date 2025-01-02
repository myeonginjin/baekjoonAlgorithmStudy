import java.util.*;

class Solution {
    static ArrayList<Integer>[] g;
    static int num;
    static boolean v[];
    static PriorityQueue<int[]> q = new PriorityQueue<>( (o1,o2) -> { return -Integer.compare(o1[1], o2[1]) ;});
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        num = n;
        g = new ArrayList[n+1]; for(int i = 0; i<=n; i++) g[i] = new ArrayList<>();
        v = new boolean[n+1];
        
        for (int i = 0; i<edge.length; i++) {
            int[] t = edge[i];
            
            int go = t[0];
            int to = t[1];
            
            g[go].add(to);
            g[to].add(go);
        }
        
        bfs(1, 1);
        
        // while(!q.isEmpty()) {
        //     int[] t = q.poll();
        //     System.out.println(t[0] + "   " + t[1]);
        // }
        
        
        int maxLen = q.poll()[1];
        answer++;
        
        while(!q.isEmpty()) {
            int len = q.poll()[1];
            if(maxLen != len) break;
            
            answer++;
        }
        
        return answer;
    }
    
    public void dfs(int node, int dis) {
        if(v[node]) return;
        
        v[node] = true;
        q.add(new int[] {node, dis});
        
        for (int i = 0; i<g[node].size(); i++) {
            int next = g[node].get(i);
            
            dfs(next, dis + 1);
        }
    }
    
    public void bfs(int node , int dis) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        v[node] = true;
        que.add(new int[] {node, dis});
        
        while(!que.isEmpty()) {
            
            int[] t = que.poll();
            int n = t[0];
            int d = t[1];
            
            for (int i = 0; i<g[n].size(); i++) {
                int next = g[n].get(i);
                
                if(v[next]) continue;
                
                v[next] = true;
                que.add(new int[]{next, d+1});
                q.add(new int[]{next, d+1});
            }
        }
        
    }
}