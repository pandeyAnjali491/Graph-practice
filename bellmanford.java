import java.util.Arrays;

public class bellmanford {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dis[] = new int[V];
        Arrays.fill(dis,100000000);
        dis[src] = 0;
        for(int i=0;i<V-1;i++){
            for(int e[]:edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if(dis[u]==100000000) continue;
                if(dis[v]>dis[u]+w){
                    dis[v] = dis[u] + w;
                }
            }
        }
        boolean cycle = false;
        for(int e[]:edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if(dis[u]==100000000) continue;
            if(dis[v]>dis[u]+w){
                dis[v] = dis[u] + w;
                cycle = true;
                break;
            }
        }
        if(cycle) return new int[]{-1};
        return dis;
    }
}
