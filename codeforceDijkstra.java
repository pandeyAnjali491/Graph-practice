import java.util.*;

public class codeforceDijkstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int edges[][] = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }
        // for(var list:adj){
        // for(var li:list){
        // System.out.print("["+li[0]+","+li[1]+"]");
        // }
        // System.out.println();
        // }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dis[] = new int[n + 1];
        int par[] = new int[n + 1];
        boolean fin[] = new boolean[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(par, -1);
        q.offer(new int[] { 1, 0 });
        dis[1] = 0;
        while (!q.isEmpty()) {
            int node[] = q.poll();
            int u = node[0];
            if (fin[u])
                continue;
            fin[u] = true;
            for (int nei[] : adj.get(u)) {
                int v = nei[0];
                int w = nei[1];
                if (fin[v]) continue;
                if (dis[v] > (dis[u] + w)) {
                    dis[v] = dis[u] + w;
                    par[v] = u;
                    q.offer(new int[] { v, dis[v] });
                }
            }
        }
        if (dis[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            int curr = n;
            ArrayList<Integer> path = new ArrayList<>();
            while (curr != -1) {
                path.add(curr);
                curr = par[curr];
            }
            Collections.reverse(path);
            for (Integer ele : path) {
                System.out.print(ele + " ");
            }
        }

    }
}
