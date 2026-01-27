import java.util.ArrayList;
import java.util.Collections;

public class topologiidfs {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        int vis[] = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                vis[i]=1;
                dfs(adj,i,vis,res);   
            }
        }
        // System.out.println(res);
        Collections.reverse(res);
        // System.out.println(res);
        return res;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int u,int vis[],ArrayList<Integer>res){
        for(Integer v:adj.get(u)){
            if(vis[v]==0){
                vis[v]=1;
                dfs(adj,v,vis,res);
            }
        }
        res.add(u);
    }
}
