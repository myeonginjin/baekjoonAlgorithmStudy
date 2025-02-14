import java.util.*;

class Solution {
    static String[] answer;
    static boolean[] v;
    static List<String> path = new ArrayList<>();
    static String[][] ts;
    
    static boolean dfs(String current, int count) {
        path.add(current);
        
        if (count == ts.length) {
            answer = path.toArray(new String[0]);
            return true;
        }
        
        for (int i = 0; i < ts.length; i++) {
            if (!v[i] && ts[i][0].equals(current)) {
                v[i] = true;
                if (dfs(ts[i][1], count + 1)) return true; // 정답을 찾았으면 즉시 리턴
                v[i] = false; // 백트래킹
            }
        }
        
        path.remove(path.size() - 1);
        return false;
    }
    
    public String[] solution(String[][] tickets) {
        ts = tickets;
        
        // 출발지 기준 정렬 후, 도착지 기준 정렬
        Arrays.sort(ts, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        v = new boolean[ts.length];
        dfs("ICN", 0);
        
        return answer;
    }
}