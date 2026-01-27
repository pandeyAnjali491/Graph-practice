import java.io.*;
import java.util.*;

public class roundtrip2 {

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int st,
            int[] par, ArrayList<Integer> arr) {
        for (Integer u : adj.get(st)) {
            if (par[u] == -1) {
                par[u] = st;
                if (dfs(adj, u, par, arr)) {
                    return true;
                }
            } else if (u != par[st]) {
                par[u]=st;
                int des = u;
                arr.add(des);
                int curr = par[des];
                while (curr != des) {
                    arr.add(curr);
                    curr = par[curr];
                }
                arr.add(des);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] j : edges) {
            int u = j[0];
            int v = j[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] par = new int[V + 1];
        Arrays.fill(par, -1);

        boolean isCycle = false;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            if (par[i] == -1) {
                par[i] = i;
                if (dfs(adj, i, par, res)) {
                    isCycle = true;
                    break;
                }
            }
        }

        if (isCycle) {
            System.out.println(res.size());
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

}
