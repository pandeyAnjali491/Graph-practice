import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]); 
        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        // for(var a:adj){
        //     for(var b:a){
        //         System.out.print("["+b[0]+","+b[1]+"]");
        //     }
        //     System.out.println();
        // }
        boolean fin[] = new boolean[V];
        int dis[] = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        q.offer(new int[]{src,0});
        while(!q.isEmpty()){
            int node[] = q.poll();
            int u=node[0];
            if(fin[u]) continue;
            fin[u]=true;
            for(var nei:adj.get(u)){
                int v = nei[0];
                int w = nei[1];
                if(!fin[v]){
                    if((dis[u]+w)<dis[v]){
                        dis[v]=dis[u]+w;
                        q.offer(new int[]{v,dis[v]});
                    }
                }
            }
        }
        return dis;
        
    }
}
