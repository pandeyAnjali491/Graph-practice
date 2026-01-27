import java.util.*;

public class roundtrip {
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int st, int[] par,ArrayList<Integer> arr) {
        for (Integer u : adj.get(st)) {
            if (par[u] == -1) {
                par[u] = st;
                arr.add(u);
                if(dfs(adj, u, par,arr)) {
                    return true;
                }
                arr.remove(arr.size()-1);
            } else {
                if (u != par[st]){
                    arr.add(u);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[e][2];
        for(int i=0;i<e;i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] j : edges) {
            int u = j[0];
            int v=j[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // System.out.println(adj);
        int[] par = new int[V+1];
        Arrays.fill(par, -1);
        boolean isCycle = false;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (par[i] == -1) {
                par[i] = i;
                res.add(i);
                if (dfs(adj, i, par,res)){
                    isCycle = true;
                    break;
                }
            }
        }
        if (isCycle) {
            int j = 0;
            while (res.get(j)!=res.get(res.size()-1)) {
                j++;
            }
            System.out.println(res.size()-j);
            for (int i = j; i < res.size(); i++) {
                System.out.print(res.get(i)+" ");
            }
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
