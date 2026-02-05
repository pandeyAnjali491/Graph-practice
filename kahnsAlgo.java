import java.util.*;
public class kahnsAlgo {
    class Solution {
        // kahn's algorithm
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // indeg array
        HashMap<Integer,Integer> dg = new HashMap<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            dg.put(i,0);
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            dg.put(v,dg.get(v)+1);
        }
        // System.out.println(adj);
        Queue<Integer> q = new ArrayDeque<>();
        for(Integer u:dg.keySet()){
            if(dg.get(u)==0){
                q.offer(u);
            }
        }
        // System.out.println(q);
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer v:adj.get(u)){
                dg.put(v,dg.get(v)-1);
                if(dg.get(v)==0){
                    q.offer(v);
                }
            }
        }
        for(Integer k:dg.keySet()){
            if(dg.get(k)>0) return true;
        }
        
        return false;
    }
}
}
