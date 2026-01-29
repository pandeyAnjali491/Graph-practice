import java.util.*;
public class ringRoad {

    public static int dfs(ArrayList<ArrayList<int[]>> adj,int x,int vis[],int count){
        int min = Integer.MAX_VALUE;
        // base case - when all nodes are visited add edge to 1 (loop)
        if (count==adj.size()-1) {
            for (var edge : adj.get(x)) {
                int y = edge[0];
                int w = edge[1];
                if (y==1) {
                    return w;
                }
            }
        }
        for (var edge : adj.get(x)) {
            int y = edge[0];
            int w = edge[1];
            if (vis[y]==0) {
                vis[y] = 1;
                min = Math.min(min,w + dfs(adj, y, vis,count+1));
                vis[y] = 0;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int edge[][] = new int[v][3];
        for (int i = 0; i < v; i++) {
            edge[i][0] = sc.nextInt(); 
            edge[i][1] = sc.nextInt(); 
            edge[i][2] = sc.nextInt(); 
        }
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            int w = edge[i][2];
            adj.get(x).add(new int[]{y,0});
            adj.get(y).add(new int[]{x,w});
        }
        // for (var al : adj) {
        //     for (var node : al) {
        //         System.out.print("[ "+node[0]+" , "+node[1]+" ]");
        //     }
        //     System.out.println();
        // }
        int vis[] = new int[v+1];
        vis[1] = 1;
        System.out.println(dfs(adj,1,vis,1));
    }
}
