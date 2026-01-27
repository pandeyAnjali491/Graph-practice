import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class bfs {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        int vis[] = new int[V];
        // adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int k=0;k<edges.length;k++){
            int u = edges[k][0];
            int v = edges[k][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int i = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(i<V){
            if(vis[i]==0){
                Queue<Integer> q = new ArrayDeque<>();
                ArrayList<Integer> temp = new ArrayList<>();
                q.offer(i);
                vis[i] = 1;
                while(!q.isEmpty()){
                    int u = q.poll();
                    temp.add(u);
                    for(Integer v:adj.get(u)){
                        if(vis[v]==0){
                            q.offer(v);
                            vis[v]=1;
                        }
                    }
                }    
                ans.add(temp);
            }
            i++;
        }
      return ans;
    }
}
