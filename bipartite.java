import java.util.*;

public class bipartite {
    public static boolean possibleBipartition(int n, int[][] dis) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<dis.length;i++){
            int u = dis[i][0];
            int v = dis[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new ArrayDeque<>();
        int set[] = new int[n+1];
        Arrays.fill(set,-1);
        for(int i=0;i<n;i++){
            if(set[i]==-1){
                q.offer(i);
                set[i]=0;
                while(!q.isEmpty()){
                    int x = q.poll();
                    for(int y:adj.get(x)){
                        if(set[y]==-1){
                            set[y]=1-set[x];
                            q.offer(y);
                        }
                        else if(set[x]==set[y]) return false;
                    }
                }
            }
        }
        for (int i = 1; i < set.length; i++) {
            System.out.print((set[i]+1)+" ");
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[e][2];
        for(int i=0;i<e;i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        boolean res = possibleBipartition(v,edges);
        if(!res) System.out.println("IMPOSSIBLE");
    }
}
