import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class party {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> edge = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int man = sc.nextInt();
            if(man==-1) continue;
            edge.add(new int[]{man,i});
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int indeg[] = new int[n+1];
        for (int[] is : edge) {
            // System.out.println("( "+is[0]+","+is[1]+")");
            adj.get(is[0]).add(is[1]);
            indeg[is[1]]++;
        }                                                                                    
        // for (int i = 0; i <= n; i++) {
        //     System.out.println(i+" deg = "+indeg[i]);
        // }
        // System.out.println(adj);
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i]==0) {
                q.offer(i);
            }
        }
        // System.out.println(q);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (Integer v : adj.get(u)) {
                    indeg[v]--;
                    if(indeg[v]==0) q.offer(v);
                }
            } 
            count++;
        }
        System.out.println(count);
    }
}
