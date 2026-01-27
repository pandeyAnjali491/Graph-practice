import java.util.*;
public class connectedGraph {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        int vis[] = new int[V];
        // adj list
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();
        for(int k=0;k<edges.length;k++){
            int u = edges[k][0];
            int v = edges[k][1];
            ArrayList<Integer> arr1 = adj.getOrDefault(u,new ArrayList<>());
            arr1.add(v);
            ArrayList<Integer> arr2 = adj.getOrDefault(v,new ArrayList<>());
            arr2.add(u);
            adj.put(u,arr1);
            adj.put(v,arr2);
        }
        for(int k=0;k<V;k++){
            if(!adj.containsKey(k)){
                adj.put(k,new ArrayList<>());
            }
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