import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class buildingroads {
    public static void main(String[] args) {
        int v;
        int e;
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        int edges[][] = new int[e][2];
        for (int i = 0; i < edges.length; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[i][0] = x;
            edges[i][1] = y;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        // System.out.println(adj);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        // System.out.println(adj);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int vis[] = new int[v + 1];
        int count = 0;
        for (int i = 1; i < vis.length; i++) {
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
        // System.out.println(res);
        System.out.println(count - 1);

        int last = res.get(0).get(0);
        for (int i = 1; i < res.size(); i++) {
            int first = res.get(i).get(0);
            System.out.println(last + " " + first);
            last = first;
        }

    }
}
