import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class highScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int edge[][] = new int[e][3];
        for (int i = 0; i < e; i++) {
            edge[i][0] = sc.nextInt();
            edge[i][1] = sc.nextInt();
            edge[i][2] = sc.nextInt();
        }
        long dis[] = new long[n + 1];
        Arrays.fill(dis, Long.MIN_VALUE);
        dis[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < e; j++) {
                int u = edge[j][0];
                int v = edge[j][1];
                int w = edge[j][2];
                if (dis[u] == Long.MIN_VALUE) {
                    continue;
                }
                if (dis[v] < dis[u] + w) {
                    dis[v] = dis[u] + w;
                }
            }
        }
        boolean bad[] = new boolean[n + 1];
        for (int j = 0; j < e; j++) {
            int u = edge[j][0];
            int v = edge[j][1];
            int w = edge[j][2];
            if (dis[u] == Long.MIN_VALUE) {
                continue;
            }
            if (dis[v] < dis[u] + w) {
                bad[v] = true;
            }
        }
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            rev.add(new ArrayList<>());
        }
        for (int[] ed : edge) {
            int u = ed[0];
            int v = ed[1];
            rev.get(v).add(u);
        }
        boolean vis[] = new boolean[n + 1];
        dfs(n, rev, vis);
        for (int i = 1; i <= n; i++) {
            if (bad[i] && vis[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(dis[n]);

    }

    static void dfs(int u, ArrayList<ArrayList<Integer>> rev, boolean[] vis) {
        vis[u] = true;
        for (int v : rev.get(u)) {
            if (!vis[v])
                dfs(v, rev, vis);
        }
    }

}
