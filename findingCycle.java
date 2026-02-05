import java.util.*;

public class findingCycle {

    public static void bellmanFord(int V, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        long dis[] = new long[V];
        Arrays.fill(dis, 0);
        int par[] = new int[V];
        Arrays.fill(par, -1);
        boolean cycle = false;
        for (int i = 0; i < V - 1; i++) {
            for (int e[] : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if (dis[v] > dis[u] + w) {
                    par[v] = u;
                    dis[v] = dis[u] + w;
                }
            }
        }

        int part = -1;
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if (dis[v] > dis[u] + w) {
                if (dis[v] < 0) {
                    part = v;
                    cycle = true;
                    break;
                }
                par[v] = u;
                dis[v] = dis[u] + w;
            }
        }
        if (!cycle) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < V; i++) {
                part = par[part];
            }
            res.add(part);
            int curr = par[part];
            while (curr != part) {
                res.add(curr);
                curr = par[curr];
            }
            res.add(part);
            Collections.reverse(res);
            System.out.println("YES");
            for (Integer ele : res) {
                System.out.print(ele + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[e][3];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        bellmanFord(n + 1, edges);
        sc.close();
    }
}