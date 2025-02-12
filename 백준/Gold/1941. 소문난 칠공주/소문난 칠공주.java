

import java.util.*;

public class Main {
    static char[][] a;
    static ArrayList<int[]> p; // 25개의 좌표 저장
    static int[][] b; // 선택된 7명
    static int cnt;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    
    // 7명이 서로 연결되어 있는지 확인하는 BFS
    static void check7Prin() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        // 첫 번째 노드를 BFS 시작점으로 설정
        queue.add(b[0]);
        visited[b[0][0]][b[0][1]] = true;
        
        int connectCount = 1; // 연결된 개수
        int sCount = (a[b[0][0]][b[0][1]] == 'S') ? 1 : 0; // 'S' 개수

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
                    for (int[] pos : b) {
                        if (pos[0] == nr && pos[1] == nc) {
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                            connectCount++;
                            if (a[nr][nc] == 'S') sCount++;
                            break; // 이미 b에 있는 값만 찾으면 되므로 break
                        }
                    }
                }
            }
        }

        // 모든 7명이 연결되어 있고, 'S'가 4명 이상이면 카운트 증가
        if (connectCount == 7 && sCount >= 4) {
            cnt++;
        }
    }

    // 25개 좌표 중 7개를 선택하는 조합
    static void comb(int index, int str) {
        if (index == 7) {
            check7Prin(); // 선택된 7명에 대해 연결 여부 검사
            return;
        }

        for (int i = str; i < 25; i++) {
            int[] t = p.get(i);
            b[index] = t; // 7명 중 한 명 선택
            comb(index + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = new char[5][5];
        p = new ArrayList<>();
        b = new int[7][2]; // 7명 선택 저장 배열

        // 5x5 입력 받기
        for (int i = 0; i < 5; i++) {
            a[i] = sc.next().toCharArray();
            for (int j = 0; j < 5; j++) {
                p.add(new int[]{i, j}); // 25개의 좌표 저장
            }
        }

        // 25개 중 7명을 선택하는 조합 시작
        comb(0, 0);

        // 가능한 경우의 수 출력
        System.out.println(cnt);
    }
}