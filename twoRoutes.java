import java.util.*;

public class twoRoutes {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int e = sc.nextInt();
    //     ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
    //     ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
    //     for (int i = 0; i <= n; i++) {
    //         adj1.add(new ArrayList<>());
    //         adj2.add(new ArrayList<>());
    //     }
    //     for (int i = 0; i < e; i++) {
    //         int x = sc.nextInt();
    //         int y = sc.nextInt();
    //         adj1.get(x).add(y);
    //         adj1.get(y).add(x);
    //     }
    //     for(int i=1;i<=n;i++){
    //         for (int j = 1; j <= n; j++) {
    //             if ( i!=j && !adj1.get(i).contains(j)) {
    //                 adj2.get(i).add(j);
    //             }
    //         }
    //     }
    //     // System.out.println(adj1);
    //     // System.out.println(adj2);
    //     int cost1 = mst(adj1, new boolean[n+1], n,new int[n+1]);
    //     int cost2 = mst(adj2, new boolean[n+1], n,new int[n+1]);
    //     // System.out.println(cost1);
    //     // System.out.println(cost2);
    //     if (cost1==Integer.MAX_VALUE || cost2==Integer.MAX_VALUE) {
    //         System.out.println(-1);
    //         return;
    //     }
    //     System.out.println(Math.max(cost1, cost2));
    // }
    // public static int mst(ArrayList<ArrayList<Integer>> adj,boolean vis[],int n,int dis[]){
    //     PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
    //     q.add(new int[]{1,0});
    //     Arrays.fill(dis,Integer.MAX_VALUE);
    //     dis[1] = 0;
    //     while (!q.isEmpty()) {
    //         int node[] = q.poll();
    //         int u = node[0];
    //         int w = node[1];
    //         if (vis[u]) {
    //             continue;
    //         }
    //         vis[u] = true;
    //         for (Integer v : adj.get(u)) {
    //             if(dis[v]>dis[u]+1){
    //                 dis[v] = dis[u]+1;
    //                 q.add(new int[]{v,dis[v]});
    //             }
    //         }
    //     }
    //     return dis[n];
    // }

    // method 2 - calling bfs 1 time only
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }
        boolean directRail = false;
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if((x==1 && y==n) || (x==n && y==1)) directRail = true;
            adj1.get(x).add(y);
            adj1.get(y).add(x);
        }
        for(int i=1;i<=n;i++){
            for (int j = 1; j <= n; j++) {
                if ( i!=j && !adj1.get(i).contains(j)) {
                    adj2.get(i).add(j);
                }
            }
        }
        int cost = 0;
        if (directRail) {
            cost = bfs(adj2,new boolean[n+1],n);
        }
        else{
            cost = bfs(adj1,new boolean[n+1],n);
        }
        if (cost==Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(cost);
    }
    public static int bfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int n){
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[]{1,0});
        while (!q.isEmpty()) {
            int node[] = q.poll();
            int u = node[0];
            int lev = node[1];
            if (u==n) {
                return node[1];
            }
            if (vis[u]) {
                continue;
            }
            vis[u] = true;
            for (Integer v :adj.get(u)) {
                if (vis[v]) {
                    continue;
                }
                q.add(new int[]{v,lev+1});
            }
        }
        return Integer.MAX_VALUE;
    }
}
