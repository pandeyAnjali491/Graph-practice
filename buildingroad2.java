import java.io.*;
import java.util.*;
public class buildingroad2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] vis = new int[v + 1];
        int count = 0;

        for (int i = 1; i <= v; i++) {
            if (vis[i] == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                count++;
                Queue<Integer> q = new ArrayDeque<>();

                q.offer(i);
                vis[i] = 1;

                while (!q.isEmpty()) {
                    int u = q.poll();
                    temp.add(u);

                    for (Integer n : adj.get(u)) {
                        if (vis[n] == 0) {
                            vis[n] = 1;
                            q.offer(n);
                        }
                    }
                }
                res.add(temp);
            }
        }

        System.out.println(count - 1);

        int last = res.get(0).get(0);
        for (int i = 1; i < res.size(); i++) {
            int first = res.get(i).get(0);
            System.out.println(last + " " + first);
            last = first;
        }
    }
}
