import java.util.*;

class Solution {
    static int[] u;
    
    static int find(int v) {
        if(u[v] == v) {
            return u[v];
        }
        
        else {
            return u[v] = find(u[v]);
        }
    }
    
    static void union(int n1 , int n2) {
        int root1 = find(n1);
        int root2 = find(n2);
        
        if(root1 == root2) return;
        
        // else {
        //     u[n1] = Math.min(root1, root2);
        //     u[n2] = Math.min(root1, root2);
        // }
        
        if (root1 != root2) {
            u[root2] = root1;  // root2의 부모를 root1로 설정
        }
        
    } 
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        u = new int[n]; for (int i = 0; i<n; i++) u[i] = i;
        
        for (int i = 0; i<computers.length; i++) {
            int[] t = computers[i];
            
            for (int j = 0; j< t.length; j++) {
                if(i == j || t[j] == 0) continue;
                
                union(i,j);
            }
        }
        
        // for (int t : u) {
        //     System.out.print(t + " ");
        // }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i = 0; i<n; i++) {
            find(i);
        }
        
        for (int t : u) {
            hs.add(t);
        }
        
        return hs.size();
    }
}