import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] population;
    static List<Integer>[] adjList;
    static boolean[] selected;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        population = new int[n+1];
        adjList = new ArrayList[n+1];
        selected = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                adjList[i].add(neighbor);
                adjList[neighbor].add(i);
            }
        }

        subset(1);

        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    static void subset(int index) {
        if (index == n + 1) {
            if (isValid()) {
                calculateDifference();
            }
            return;
        }

        selected[index] = true;
        subset(index + 1);
        selected[index] = false;
        subset(index + 1);
    }

    static boolean isValid() {
        boolean[] visited = new boolean[n+1];
        int trueCount = 0, falseCount = 0;
        for (int i = 1; i <= n; i++) {
            if (selected[i]) trueCount++;
            else falseCount++;
        }
        if (trueCount == 0 || falseCount == 0) return false;

        Queue<Integer> queue = new LinkedList<>();
        // Check first part
        for (int i = 1; i <= n; i++) {
            if (selected[i]) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList[current]) {
                if (!visited[neighbor] && selected[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // Check second part
        for (int i = 1; i <= n; i++) {
            if (!selected[i]) {
                queue.add(i);
                visited[i] = true;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList[current]) {
                if (!visited[neighbor] && !selected[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // Check if all nodes are visited
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        
        return true;
    }

    static void calculateDifference() {
        int trueSum = 0, falseSum = 0;
        for (int i = 1; i <= n; i++) {
            if (selected[i]) trueSum += population[i];
            else falseSum += population[i];
        }
        minDifference = Math.min(minDifference, Math.abs(trueSum - falseSum));
    }
}
