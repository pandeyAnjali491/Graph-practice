import java.util.*;
public class iceSkating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edge[][] = new int[n][2]; 
        int m = 0;
        for (int i = 0; i < n; i++) {
            edge[i][0] = sc.nextInt()-1;
            edge[i][1] = sc.nextInt()-1;
            m = Math.max(m,Math.max(edge[i][0], edge[i][1]));
        }
        int list[] = new int[m+1];
        Arrays.fill(list,-1);
        for (int i = 0; i < n; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            list[u] = v;
            list[v] = u;
        }
        int vis[][] = new int[m+1][m+1];
        int count = 0;
        for (int i = 0; i < edge.length; i++) {
            int sr = edge[i][0];
            int st = edge[i][1];
            if (vis[sr][st]==0) {
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{sr,st});
                vis[sr][st] = 1;
                while (!q.isEmpty()) {
                    int node[] = q.poll();
                    int u = node[0];
                    int v = node[1];
                    vis[u][v] = 1;
                    // right
                    for(int k=u+1;k<=m;k++){
                        if(list[v]==k && vis[k][v]==0){
                            q.offer(new int[]{k,v});
                        }
                    }
                    // left
                    for(int k=u-1;k>=0;k--){
                        if(list[v]==k && vis[k][v]==0){
                            q.offer(new int[]{k,v});
                        }
                    }
                    // up
                    for(int k=v-1;k>=0;k--){
                        if(list[u]==k && vis[u][k]==0){
                            q.offer(new int[]{u,k});
                        }
                    }
                    // down
                    for(int k=v+1;k<=m;k++){
                        if(list[u]==k && vis[u][k]==0){
                            q.offer(new int[]{u,k});
                        }
                    }
                }
                count++;
            }
        }
        System.out.println(count-1);     
    }
}
