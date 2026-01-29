import java.util.ArrayList;
import java.util.Scanner;

public class kefaPark {
    static int total = 0;

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int i, int leaf[], int cat[], int maxCat, int consCat,
            int vis[]) {
        if (consCat > maxCat) {
            return;
        }
        if (leaf[i] == 1) {
            total++;
            return;
        }
        vis[i] = 1;
        for (int j : adj.get(i)) {
            if (vis[j] == 0) {
                if (cat[j] == 0) {
                    dfs(adj, j, leaf, cat, maxCat, 0, vis);
                } else {
                    dfs(adj, j, leaf, cat, maxCat, consCat + 1, vis);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxCat = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int cat[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            cat[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // System.out.println(adj);
        // for (int i = 0; i <= n; i++) {
        // System.out.print(cat[i]+" ");
        // }
        int isleaf[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (adj.get(i).size() == 1) {
                isleaf[i] = 1;
            }
        }
        // System.out.println();
        // for (int i = 0; i <= n; i++) {
        // System.out.print(isleaf[i]+" ");
        // }
        int vis[] = new int[n + 1];
        if (cat[1] == 1) {
            dfs(adj, 1, isleaf, cat, maxCat, 1, vis);
        } else
            dfs(adj, 1, isleaf, cat, maxCat, 0, vis);
        System.out.println(total);
    }
}
