import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class flightroutecheck {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws Exception {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = nextInt();
        int e = nextInt();
        int edges[][] = new int[e][2];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            int u = nextInt();
            int v = nextInt();
            adj.get(u).add(v);
            rev.get(v).add(u);
        }
        // brute force

        // System.out.print(adj);
        // for (int i = 1; i <= n; i++) {
        //     boolean vis[] = new boolean[n+1];
        //     dfs(adj,i,vis);
        //     for(int j=1;j<=n;j++){
        //         if (!vis[j]){
        //             System.out.println("NO");
        //             System.out.println(i +" "+j);
        //             return;
        //         }
        //     }
        // }
        // System.out.println("YES");

        boolean vis1[] = new boolean[n+1];
        boolean vis2[] = new boolean[n+1];
        int count1[] = new int[1];
        int count2[] = new int[1];
        dfs(adj, 1, vis1,count1);
        dfs(rev, 1, vis2, count2);
        if (count1[0]==n && count2[0]==n) {
            System.out.println("YES");
        }
        else{
            for (int i = 1; i <= n; i++) {
                if (!vis1[i]) {
                    System.out.println("NO");
                    System.out.println(1+" "+i);
                    break;
                }
                if (!vis2[i]) {
                    System.out.println("NO");
                    System.out.println(i+" "+1);
                    break;
                }
            }
        }

    }
    public static void dfs( ArrayList<ArrayList<Integer>> adj,int st,boolean vis[],int count[]){
        vis[st] = true;
        count[0]++;
        for(Integer v:adj.get(st)){
            if (!vis[v]) {
                dfs(adj, v, vis,count);
            }
        }
    }
}
