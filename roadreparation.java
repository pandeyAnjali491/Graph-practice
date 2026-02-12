// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.Scanner;

// public class roadreparation {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int e = sc.nextInt();

//         ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < e; i++) {
//             int x = sc.nextInt();
//             int y = sc.nextInt();
//             int w = sc.nextInt();
//             adj.get(x).add(new int[]{y,w});
//             adj.get(y).add(new int[]{x,w});
//         }
//         boolean fin[] = new boolean[n+1];
//         PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
//         q.offer(new int[]{1,0});
//         long cost = 0;
//         while (!q.isEmpty()) {
//             int node[] = q.poll();
//             int x = node[0];
//             int w = node[1];
//             if (fin[x]) {
//                 continue;
//             }
//             cost += w;
//             fin[x] = true;
//             for (int[] nei :adj.get(x)) {
//                 int y = nei[0];
//                 int w1 = nei[1];
//                 q.add(new int[]{y,w1});
//             }
//         }
//         for (int i = 1; i < n; i++) {
//             if (!fin[i]) {
//                 System.out.println("IMPOSSIBLE");
//                 return;
//             }
//         }
//         System.out.println(cost);
//     }
// }

import java.io.*;
import java.util.*;

public class roadreparation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int e = Integer.parseInt(first[1]);

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            adj.get(x).add(new int[]{y, w});
            adj.get(y).add(new int[]{x, w});
        }

        boolean[] fin = new boolean[n + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        q.offer(new int[]{1, 0});
        long cost = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int w = node[1];

            if (fin[x]) continue;

            fin[x] = true;
            cost += w;

            for (int[] nei : adj.get(x)) {
                q.offer(new int[]{nei[0], nei[1]});
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!fin[i]) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        System.out.println(cost);
    }
}

