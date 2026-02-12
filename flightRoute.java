import java.util.*;

public class flightRoute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v,w});
        }
        // for (int i = 0; i <= n; i++) {
        //     System.out.print(i+" -> ");
        //     for (int[] list : adj.get(i)) {
        //         System.out.print("["+list[0]+" , "+list[1]+"] ");
        //     }
        //     System.out.println();
        // }
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[][] = new boolean[n+1][n+1];
        dfs(adj,1,n,0,res,vis);
        // System.out.println(res);
        Collections.sort(res);
        for (int i = 0; i < k; i++) {
            System.out.print(res.get(i)+" ");
        }
    }
    public static void dfs(ArrayList<ArrayList<int[]>> adj ,int cur,int des,int cost,ArrayList<Integer> res,boolean vis[][]){
        if (cur==des) {
            res.add(cost);
            return;
        }
        for (int nei[] : adj.get(cur)) {
            int v = nei[0];
            int w = nei[1];
            if (!vis[cur][v]) {
                vis[cur][v] = true;
                dfs(adj, v, des, cost+w, res, vis);   
                vis[cur][v] = false;
            }
        }
    }
}
