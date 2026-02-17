import java.util.*;

public class planetAndKingdom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            rev.get(v).add(u);
        }
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if(!vis[i]) topoSort(adj,i,st,vis);   
        }
        Arrays.fill(vis,false);
        int com[] = new int[n+1];
        int cp=1;
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!vis[u]) {
                dfs(rev,u,vis,cp,com);
                cp++;
            }
        }
        System.out.println(cp-1);
        for (int i=1;i<=n;i++) {
            System.out.print(com[i]+" ");
        }
    }
    public static void topoSort(ArrayList<ArrayList<Integer>> adj,int u,Stack<Integer> st,boolean vis[]){
        vis[u] = true;
        for(Integer v:adj.get(u)){
            if (!vis[v]) {
                topoSort(adj, v, st, vis);
            }
        }
        st.add(u);
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean vis[],int cp,int com[]){
        vis[u] = true;
        com[u] = cp;
        for (Integer v : adj.get(u)) {
            if (!vis[v]) {
                dfs(adj, v, vis, cp, com);
            }
        }
    }
}
