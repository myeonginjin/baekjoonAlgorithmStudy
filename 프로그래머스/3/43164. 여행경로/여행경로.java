import java.util.*;

class Solution {
    static String[][] ts;
    static String[] answer;
    static boolean[] v;
    static boolean find = false;
    static ArrayList<String> rs = new ArrayList<>();
    
    static void dfs(String go, String route, int cnt) {
        if(cnt > ts.length) {
            rs.add(route);
            return;
        }
        
        for (int i = 0; i<ts.length; i++) {
            if( ts[i][0].equals(go) && !v[i]) {                
                v[i] = true;
                String to = ts[i][1];
                
                dfs(to, route+to+" "  , cnt+1);
                
                v[i] = false;
            }
        }
        
    }
    public String[] solution(String[][] tickets) {
        ts = tickets;
        v = new boolean[ts.length];
        
        dfs("ICN", "ICN ", 1);
        
        Collections.sort(rs);
        
        String[] answer = rs.get(0).split(" ");
        
        return answer;
    }
}