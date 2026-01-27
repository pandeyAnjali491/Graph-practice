import java.util.*;
public class depth1Sch {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[adj.size()];
        int node = 0;
        ArrayList<Integer> res = new ArrayList<>();
        recdfs(adj,vis,node,res);
        return res;
    }
    public void recdfs(ArrayList<ArrayList<Integer>> adj,int vis[],int node,ArrayList<Integer> res){
        vis[node] = 1;
        res.add(node);
        for(Integer n:adj.get(node)){
            if(vis[n]==0){
                recdfs(adj,vis,n,res);
            }
        }
    }
}
