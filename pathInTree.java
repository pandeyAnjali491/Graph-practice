import java.io.*;
import java.util.*;

public class pathInTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int ask(int a, int b) throws Exception {
        System.out.println("? " + a + " " + b);
        System.out.flush();          // VERY IMPORTANT

        int res = Integer.parseInt(br.readLine());
        if (res == -1) {
            System.exit(0);          // too many queries
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            // -------------------------
            // YOUR SOLUTION LOGIC HERE
            // -------------------------
            ArrayList<Integer> seq = new ArrayList<>();
            boolean vis[] = new boolean[n+1];
            dfs(adj,1,seq,vis);
            // System.out.println(seq);
            boolean answered = false;
            int i=0;
            for (i = 0; i < seq.size()-1; i=i+2) {
                int u = seq.get(i);
                int v = seq.get(i+1);
                int res = ask(u, v);
                if (res==1) {
                    int res1 = ask(u, u);
                    if (res1==1) {
                        System.out.println("! "+u);
                        System.out.flush();
                        answered = true;
                        break;
                    }
                    else{
                        System.out.println("! "+v);
                        System.out.flush();
                        answered = true;
                        break;
                    }
                }
            }  
            if(i==seq.size()-1){
                int res1 = ask(i, i);
                if (res1==1) {
                    System.out.println("! "+i);
                    answered = true;
                    System.out.flush();
                }
            }
            if (!answered) {
                System.out.println("! 1");   // fallback
                System.out.flush();
            }          
        }
    }
    public static void dfs(List<Integer>[] adj,int u,ArrayList<Integer> res,boolean vis[]){
        vis[u] = true;
        res.add(u);
        for (Integer v : adj[u]) {
            if (!vis[v]) {
                dfs(adj, v, res, vis);
            }
        }
    }
}
