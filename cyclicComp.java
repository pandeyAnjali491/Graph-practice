import java.util.*;
public class cyclicComp {

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int st,boolean vis[]){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(st);
        vis[st] = true;
        boolean valid = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (adj.get(u).size()!=2) {
                valid =  false;
            }
            for (Integer v : adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }
        return valid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // System.out.println(adj);
        boolean vis[] = new boolean[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!vis[i]){
                if(isCycle(adj,i,vis)){
                    count++;
                }
            }   
        }
        System.out.println(count);
    }
}