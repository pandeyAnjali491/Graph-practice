import java.util.*;

public class darkroads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            int total = 0;
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                total += w;
                adj.get(u).add(new int[] { v, w });
                adj.get(v).add(new int[] { u, w });
            }
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            q.add(new int[] { 0, 0 });
            int cost = 0;
            boolean vis[] = new boolean[n];
            while (!q.isEmpty()) {
                int node[] = q.poll();
                int u = node[0];
                int w = node[1];
                if (vis[u]) {
                    continue;
                }
                vis[u] = true;
                cost += w;
                for (int[] nei : adj.get(u)) {
                    int v = nei[0];
                    int w1 = nei[1];
                    q.add(new int[] { v, w1 });
                }
            }
            System.out.println(total - cost);
        }
    }
}
