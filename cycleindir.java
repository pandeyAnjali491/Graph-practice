import java.util.ArrayList;

public class cycleindir {
    class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        // System.out.println(adj);
        int vis[] = new int[V];
        int path[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                vis[i]=1;
                path[i]=1;
                if(dfs(adj,i,vis,path)){
                    return true;
                }
                path[i]=0;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int i,int vis[],int path[]){
        for(Integer u:adj.get(i)){
            if(path[u]==1) return true;
            else if(vis[u]==0){
                path[u]=1;
                vis[u]=1;
                if(dfs(adj,u,vis,path)) return true;
                path[u]=0;
            }
        }
        return false;
    }
}
}
