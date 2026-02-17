import java.io.*;
import java.util.*;

public class investigation {
    
    public static void main(String[] args)throws Exception {
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        // ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        // for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        // for (int i = 0; i < m; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     int a = Integer.parseInt(st.nextToken());
        //     int b = Integer.parseInt(st.nextToken());
        //     int c = Integer.parseInt(st.nextToken());
        //     adj.get(a).add(new int[]{b, c});
        // }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<int[]>>adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj.get(a).add(new int[]{b, c});
        }
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.offer(new long[] { 1, 0 });

        long dis[] = new long[n + 1];
        long cnt[] = new long[n + 1];
        long minL[] = new long[n + 1];
        long maxL[] = new long[n + 1];
        Arrays.fill(minL, Long.MAX_VALUE);
        Arrays.fill(maxL, 0);
        minL[1] = maxL[1] = 0;
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[1] = 0;
        cnt[1] = 1;
        long mod = (long) 1e9+7;

        while (!q.isEmpty()) {
            long node[] = q.poll();
            int u = (int)node[0];
            long d = node[1];
            if (d > dis[u])
                continue;
            for (int nei[] : adj.get(u)) {
                int v = nei[0];
                int w = nei[1];
                if (dis[v] == dis[u] + w) {
                    cnt[v] = (cnt[u]+cnt[v])%mod;
                    // System.out.println(lev[v]+" for v"+v);
                    minL[v] = Math.min(minL[v], minL[u] + 1);
                    maxL[v] = Math.max(maxL[v], maxL[u] + 1);
                } 
                else if (dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    cnt[v] = cnt[u];
                    minL[v] = minL[u] + 1;
                    maxL[v] = maxL[u] + 1;
                    q.add(new long[] { v, dis[v] });
                }
            }
        }
        System.out.print(dis[n] + " ");
        System.out.print(cnt[n] + " ");
        System.out.print(minL[n] + " ");
        System.out.print(maxL[n]);
    }
}
