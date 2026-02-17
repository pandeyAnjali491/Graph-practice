import java.util.*;

public class checkpost {
    static int min;
    static int freq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wei[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            wei[i] = sc.nextInt();
        }
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            rev.get(v).add(u);
        }
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n+1];
        for (int j = 1; j <= n; j++) {
            if (!vis[j]) {
                toposort(adj,j,vis,st);
            }
        }
        // System.out.println(st);
        long cost = 0;
        long totalFreq = 1;
        int mod = (int)1e9+7;
        Arrays.fill(vis, false);
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!vis[u]) {
                min = Integer.MAX_VALUE;
                dfs(rev,u,vis,wei);
                // System.out.println(u);
                cost += min;
                totalFreq = (totalFreq * freq)% mod;
            }
        }
        System.out.print(cost+" ");
        System.out.println(totalFreq);
    }

    public static void toposort(ArrayList<ArrayList<Integer>> adj ,int u,boolean vis[],Stack<Integer> st){
        vis[u] = true;
        for (Integer v : adj.get(u)) {
            if (!vis[v]) {
                toposort(adj, v, vis, st);
            }
        }
        st.add(u);
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean vis[],int wei[]){
        vis[u] =true;
        if(min>wei[u]){
            min = wei[u];
            freq = 1;
        }
        else if (min==wei[u]) {
            freq++;
        }
        for (Integer v : adj.get(u)) {
            if (!vis[v]) {
                dfs(adj, v, vis,wei);
            }
        }
    }
}
