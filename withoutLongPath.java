import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class withoutLongPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int edges[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // System.out.println(adj);
        int deg[] = new int[n + 1];
        Arrays.fill(deg, -1);
        int vis[] = new int[n + 1];
        boolean possible = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        // 1 - outgoing
        // 0 - incoming
        deg[1] = 1;
        vis[1] = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = 1;
            for (Integer v : adj.get(u)) {
                if (vis[v] == 1 && deg[v] == deg[u]) {
                    possible = false;
                    q.clear();
                    break;
                }
                if (vis[v] == 0) {
                    deg[v] = 1 - deg[u];
                    q.offer(v);
                }
            }
        }
        if (!possible) {
            System.out.println("NO");
        } else {
            // for (int i = 0; i <= n; i++) {
            //     System.out.print(deg[i] + " ");
            // }
            System.out.println("YES");
            for (int i = 0; i < m; i++) {
                int u = edges[i][0];
                System.out.print(deg[u]);
            }
        }
    }
}
