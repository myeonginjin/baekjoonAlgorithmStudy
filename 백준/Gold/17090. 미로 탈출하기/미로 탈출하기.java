import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static char[][] a;
    static boolean[][] can;
    static boolean[][] cant;
    static boolean[][] visited;
    static int answer;

    static boolean canGo(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    static boolean dfs(int r, int c) {
        if (!canGo(r, c)) return true; // 경계를 벗어나면 탈출 가능
        if (can[r][c]) return true; // 이미 탈출 가능으로 판정된 경우
        if (cant[r][c]) return false; // 이미 탈출 불가능으로 판정된 경우

        if (visited[r][c]) return false; // 사이클 발생 → 탈출 불가
        visited[r][c] = true; // 현재 탐색 중인 위치를 방문 처리

        int nr = r, nc = c;

        // 방향 설정
        switch (a[r][c]) {
            case 'U': nr = r - 1; break;
            case 'R': nc = c + 1; break;
            case 'D': nr = r + 1; break;
            case 'L': nc = c - 1; break;
        }

        // DFS 탐색
        boolean canEscape = dfs(nr, nc);
        if (canEscape) {
            can[r][c] = true;
        } else {
            cant[r][c] = true;
        }

        visited[r][c] = false; // 백트래킹
        return canEscape;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new char[n][m];
        can = new boolean[n][m];
        cant = new boolean[n][m];
        visited = new boolean[n][m]; // 방문 체크 배열 추가

        for (int i = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (can[i][j]) {
                    answer++;
                    continue;
                }
                if (!cant[i][j] && dfs(i, j)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}