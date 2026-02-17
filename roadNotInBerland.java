import java.util.*;

public class roadNotInBerland {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edges[][] = new int[n - 1][2];
        DSU set = new DSU(n);
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (set.find(u)==set.find(v)) {
                q.add(new int[]{u,v});
            }
            else set.union(u,v);
        }
        ArrayList<Integer> com = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (set.par[i]==i) {
                com.add(i);
            }
        }
        // System.out.println(com);
        if (com.size()-1 > q.size()) {
            System.out.println("Impossible");
        }
        else if (com.size()==1) {
            System.out.println(0);
        }
        else{
            System.out.println(com.size()-1);
            int st = com.get(0);
            for (int i = 1; i < com.size(); i++) {
                int ex[] = q.poll();
                System.out.print(ex[0]+" "+ex[1]+" ");
                System.out.print(st+" "+com.get(i)+" ");
            }
        }
    }
}

class DSU {
    int par[];
    int size[];
    int n;

    DSU(int n) {
        this.n = n;
        size = new int[n+1];
        par = new int[n+1];
        for (int i = 0; i <= n; i++) {
            par[i] = i;
        }
    }

    public int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (size[parA] >= size[parB]) {
            par[parB] = parA;
            size[parA] += size[parB];
        } else {
            par[parA] = parB;
            size[parB] += size[parA];
        }
    }
}