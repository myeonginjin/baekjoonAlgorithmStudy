import java.util.*;

class Solution {
    
    static class Music {
        int n;
        int cnt;
        
        public Music(int num, int cnt) {
            this.n = num;
            this.cnt = cnt;
        }
    }
    
    static class Genre {
        String type;
        int cnt;
        
        public Genre(String t, int cnt) {
            this.type = t;
            this.cnt = cnt;
        }
    }
        
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String, ArrayList<Music>> hs = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for (int i = 0; i<plays.length; i++) {
            int cnt = plays[i];
            Music m = new Music(i, cnt);
            
            String genr = genres[i];
            
            if(hs.containsKey(genr)) {
                hs.get(genr).add(m);
                count.replace(genr, count.get(genr) + cnt);
            }
            
            else {
                ArrayList<Music> t = new ArrayList<>();
                t.add(m);
                hs.put(genr, t);
                
                count.put(genr, cnt);
            }
        }
        
        ArrayList<Genre> a = new ArrayList<>();
        
        for (Map.Entry<String , Integer> en : count.entrySet()) {
            Genre g = new Genre(en.getKey() , en.getValue());
            a.add(g);
        }
        Collections.sort(a, (o1, o2) -> -Integer.compare(o1.cnt, o2.cnt) );
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (Genre g : a) {
            ArrayList<Music> m = hs.get(g.type);
            Collections.sort(m, (o1, o2) -> { 
                if(o1.cnt == o2.cnt) return Integer.compare(o1.n, o2.n);
                else return -Integer.compare(o1.cnt , o2.cnt);
                });
            
            int range = m.size() >= 2 ? 2 : 1;
            for (int i = 0; i<range; i++) {
                ans.add(m.get(i).n);
            }
        }
        
        answer = new int[ans.size()];
        int index = 0;
        for (Integer t : ans) answer[index++] = t;
        
        return answer;
    }
}