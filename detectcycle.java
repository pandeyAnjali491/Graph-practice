import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class detectcycle {
    // method 1
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int par[] = new int[adj.size()];
        Arrays.fill(par, -1);
        // System.out.println(adj);
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                boolean pre = bfs(adj, i, par, vis);
                if (pre) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int st, int par[], int vis[]) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(st);
        vis[st] = 1;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (Integer y : adj.get(x)) {
                if (y == par[x])
                    continue;
                else if (vis[y] == 1)
                    return true;
                else {
                    q.offer(y);
                    par[y] = x;
                    vis[y] = 1;
                }
            }
        }
        return false;
    }

    // method 2
    class Solution {
        public boolean isCycle(int V, int[][] edges) {

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());

            for (int[] e : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }

            int[] par = new int[V];
            Arrays.fill(par, -1);

            for (int i = 0; i < V; i++) {
                if (par[i] == -1) {
                    par[i] = i; // mark start as visited
                    if (bfs(adj, i, par))
                        return true;
                }
            }
            return false;
        }

        public boolean bfs(ArrayList<ArrayList<Integer>> adj, int st, int[] par) {
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(st);

            while (!q.isEmpty()) {
                int x = q.poll();
                for (int y : adj.get(x)) {
                    if (par[y] == -1) {
                        par[y] = x; // mark visited
                        q.offer(y);
                    } else if (y != par[x]) {
                        // visited neighbor not parent → cycle
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // using dfs
        public boolean isCycle(int V, int[][] edges) {

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] e : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }

            int[] par = new int[V];
            Arrays.fill(par, -1);

            for (int i = 0; i < V; i++) {
                if (par[i] == -1) {
                    par[i] = i;
                    if (dfs(adj, i, par))
                        return true;
                }
            }
            return false;
        }

        public boolean dfs(ArrayList<ArrayList<Integer>> adj, int st, int[] par) {
            boolean res = false;
            for (Integer u : adj.get(st)) {
                if (par[u] == -1) {
                    par[u] = st;
                    res = dfs(adj, u, par);
                } else {
                    if (u != par[st])
                        return true;
                }
            }
            return res;
        }
}
